package Game.entities.creatures;

import Game.RefLinks;
import Game.entities.Entity;
import Game.physics.*;
import Game.tiles.Tile;

public abstract class Creature extends Entity {

    public static final int DEFAULT_DAMAGE = 0;
    public static final double DEFAULT_TYRES_DEGRADATION = 0;
    public static final double DEFAULT_ENGINE_WEAR = 0;
    public static final double DEFAULT_GEARBOX_WEAR = 0;
    public static final int DEFAULT_GEAR = 0;
    public static final double DEFAULT_SPEED = 0;
    public static final double DEFAULT_FUEL_QUANTITY = 20;

    public static final int DEFAULT_CREATURE_WIDTH = 256;
    public static final int DEFAULT_CREATURE_HEIGHT = 256;

    protected Damage damage;
    protected EngineWear engineWear;
    protected GearBox gearBox;
    protected TyresDegradation tyresDegradation;
    protected Speed speed;
    protected Fuel fuel;
    protected KERS kers;
    protected DRS drs;

    protected int collision;// Variabila care va contoriza coliziunile cu zidurile si cu celelalte obiecte
    protected int isOutsideTrackLimits;// Variabila care va lua valoarea 1 atunci cand jucatorul paraseste circuirtul
    protected int isInsidePitLane;// Variabila care va lua valoarea 1 atunci cand jucatorul este pe linia de pit-stop
    protected int isInThePitBox; // Variabila care va lua valoarea 1 atunci cand jucatorul este in casuta de pit-stop, adica locul unde se realizeaza pit-stop-ul
    protected int hasCutTheCorner;// Variabila care va lua valoarea 1 atunci cand jucatorul a iesit de pe circuit si taie anumite zone cu iarba sau pietris
    // Este utilizata pentru a evita obtinera unor timpi mai buni scurtand virajele sau trisand

    protected double xMove;
    protected double yMove;

    public Creature(RefLinks refLinks, double x, double y, int width, int height) {
        super(refLinks, x, y, width, height);

        damage=new Damage(DEFAULT_DAMAGE);
        engineWear=new EngineWear(DEFAULT_ENGINE_WEAR);
        gearBox=new GearBox(DEFAULT_GEAR,DEFAULT_GEARBOX_WEAR);
        tyresDegradation=new TyresDegradation(DEFAULT_TYRES_DEGRADATION);
        kers=new KERS(refLinks);
        drs=new DRS(refLinks);
        speed=new Speed(DEFAULT_SPEED,kers,drs);
        fuel=new Fuel(DEFAULT_FUEL_QUANTITY);

        collision=0;
        isOutsideTrackLimits=0;
        isInsidePitLane=0;
        isInThePitBox=0;
        hasCutTheCorner=0;

        xMove = 0;
        yMove = 0;
    }

    public void move(){
        moveX();// miscare doar pe axa Ox
        moveY();// miscare doar pe axa Oy
    }

    public void moveX(){// miscare doar pe axa Ox
        if(xMove > 0){// Deplasare in dreapta
            int tempx = (int) (x + xMove + collide_rectangle.x + collide_rectangle.width) / Tile.TILEWIDTH;
            // tempx = pozitia curenta + pozitia la care se doreste sa se deplaseze jucatorul + varful dreptunchiului de coliziune (punctul (0,0)) + latimea dreptunghiului pentru a se putea verifica coliziunea pe partea dreapta
            // aceasta suma va avea ca rezultat coordonata in pixeli a tile-ului pe care il lovieste jucatorul
            // pentru a obtine pozitia in tile-uri, se va imparti suma la Tile.TILEWIDTH
            // se va verifica daca jucatorul loveste cu partea dreapta vreun obiect solid, adica un obiect pentru care metoda isDrivable() va returna false

            if(Collision(tempx, (int) (y + collide_rectangle.y) / Tile.TILEHEIGHT)==false && Collision(tempx, (int) (y + collide_rectangle.y + collide_rectangle.height) / Tile.TILEHEIGHT)==false){
                // y + collide_rectangle.y --- varful din dreapta-sus al dreptunghiului de coliziune
                // y + collide_rectangle.y + collide_rectangle.height --- varful din dreapta-jos al dreptunghiului de coliziune
                x += xMove;
            } else{// Loveste parapetii, exista coliziune
                // pentru a nu intra in tile-urile lovite
                x=tempx*Tile.TILEWIDTH- collide_rectangle.x-collide_rectangle.width-1;
                // coordonata tile-ului lovit - coordonata pe Ox a varfului din dreapta sus al dreptunghiului de coliziune - latimea dreptunghiului de coliziune - 1
                // -1 s-a adaugat pentru a se evita suprapunerea colizunii pe axa Oy, ca urmare a lipirii colturilor din dreapta sus si jos a dreptunghiului de coliziune de tile-ul lovit
                // jucatorul va fi pozitionat la limita tile-ului lovit

                collision=1;
            }

            CheckCollision();// Verificare colisiune

            CheckParameters(tempx, (int) (y + collide_rectangle.y) / Tile.TILEHEIGHT,tempx, (int) (y + collide_rectangle.y + collide_rectangle.height) / Tile.TILEHEIGHT);

        }else if(xMove < 0){// Deplasare in stanga
            int tempx = (int) (x + xMove + collide_rectangle.x) / Tile.TILEWIDTH;

            if(Collision(tempx, (int) (y + collide_rectangle.y) / Tile.TILEHEIGHT)==false && Collision(tempx, (int) (y + collide_rectangle.y + collide_rectangle.height) / Tile.TILEHEIGHT)==false){
                // y + collide_rectangle.y --- varful din stanga-sus al dreptunghiului de coliziune
                // y + collide_rectangle.y + collide_rectangle.height --- varful din stanga-jos al dreptunghiului de coliziune

                //Diferenta intre verificarea coliziunii pe partea dreapta si pe partea stanga se face prin intermediul variabilei tempx
                x += xMove;
            }
            else{// Loveste parapetii, exista coliziune
                x=tempx*Tile.TILEWIDTH+Tile.TILEWIDTH-collide_rectangle.x;
                // coordonata tile-ului lovit + latimea tile-ului lovit - coordonata pe Ox a varfului din dreapta sus al dreptunghiului de coliziune
                // jucatorul va fi pozitionat la limita tile-ului lovit

                collision=1;
            }

            CheckCollision();// Verificare colisiune

            CheckParameters(tempx, (int) (y + collide_rectangle.y) / Tile.TILEHEIGHT,tempx, (int) (y + collide_rectangle.y + collide_rectangle.height) / Tile.TILEHEIGHT);

        }
    }

    public void moveY(){// miscare doar pe axa Oy
        if(yMove < 0){// Deplasare in sus
            int tempy = (int) (y + yMove + collide_rectangle.y) / Tile.TILEHEIGHT;
            // pozitia pe axa Oy + deplasarea pe axa Oy + coordonata varfului superior al dreptunghiului de coliziune
            // rezultatul va fi in pixeli, pentru obtinerea pozitiei in functie de tile-uri, rezultatul va trebui impartit la Tile.TILEHEIGHT
            if(Collision((int) (x + collide_rectangle.x) / Tile.TILEWIDTH, tempy)==false && Collision((int) (x + collide_rectangle.x + collide_rectangle.width) / Tile.TILEWIDTH, tempy)==false){
                // x + collide_rectangle.x --- varful superior din partea stanga a dreptunghiului de coliziune
                // x + collide_rectangle.x + collide_rectangle.width --- varful superior din partea dreapta a dreptunghiului de coliziune
                y += yMove;
            }
            else{// Loveste parapetii, exista coliziune
                y=tempy*Tile.TILEHEIGHT+Tile.TILEHEIGHT-collide_rectangle.y;
                // coordonata tile-ului lovit + inaltimea tile-ului lovit - coordonata pe Oy a varfului din dreapta sus al dreptunghiului de coliziune
                // jucatorul va fi pozitionat la limita tile-ului lovit

                collision=1;
            }

            CheckCollision();// Verificare colisiune

            CheckParameters((int) (x + collide_rectangle.x) / Tile.TILEWIDTH, tempy,(int) (x + collide_rectangle.x + collide_rectangle.width) / Tile.TILEWIDTH, tempy);

        }else if(yMove > 0){// Deplasare in jos
            int tempy = (int) (y + yMove + collide_rectangle.y + collide_rectangle.height) / Tile.TILEHEIGHT;
            // pozitia pe axa Oy + deplasarea pe axa Oy + coordonata varfului superior al dreptunghiului de coliziune + coordonata varfului inferior al dreptunghiului de coliziune
            // rezultatul va fi in pixeli, pentru obtinerea pozitiei in functie de tile-uri, rezultatul va trebui impartit la Tile.TILEHEIGHT

            if(Collision((int) (x + collide_rectangle.x) / Tile.TILEWIDTH, tempy)==false && Collision((int) (x + collide_rectangle.x + collide_rectangle.width) / Tile.TILEWIDTH, tempy)==false){
                y += yMove;
            }
            else{// Loveste parapetii, exista coliziune
                y=tempy*Tile.TILEHEIGHT - collide_rectangle.y-collide_rectangle.height-1;
                // coordonata tile-ului lovit - coordonata pe Oy a varfului din dreapta sus al dreptunghiului de coliziune - lungimea dreptunghiului de coliziune - 1
                // -1 s-a adaugat pentru a se evita suprapunerea colizunii pe axa Ox, ca urmare a lipirii colturilor din dreapta jos si stanga jos a dreptunghiului de coliziune de tile-ul lovit
                // jucatorul va fi pozitionat la limita tile-ului lovit

                collision=1;
            }

            CheckCollision();// Verificare colisiune

            CheckParameters((int) (x + collide_rectangle.x) / Tile.TILEWIDTH, tempy,(int) (x + collide_rectangle.x + collide_rectangle.width) / Tile.TILEWIDTH, tempy);

        }
    }

    public boolean Collision(int x,int y){
        return refLinks.getWorld().getTile(x,y).isNotDrivable();
    }
    public void CheckCollision(){
        if(collision==1) {
            speed.CollisionSpeed(); // Masina va ricosa la impactul cu parapetul din cauciucuri
            setPlayerDamage();
            setParameters();
            collision=0;
        }else if(collision==0)
            setParameters();

        if(getPlayerGearBoxWear()>=99||getPlayerDamage()>=99||getPlayerEngineWear()>=99||getPlayerTyresDegradation()>=99)
            speed.setSpeed(0);
    }



    public void CheckParameters(int x, int y, int z, int t){

        if(OutOfTheTrackLimits(x,y)==true && OutOfTheTrackLimits(z,t)==true)
            isOutsideTrackLimits=1;

        if(CutTheCorner(x,y)==true && CutTheCorner(z,t)==true)
            hasCutTheCorner=1;

        if(InThePitLane(x,y)==true && InThePitLane(z,t)==true)
            isInsidePitLane=1;

        if(InThePitBox(x,y)==true && InThePitBox(z,t)==true)
            isInThePitBox=1;
    }


    public boolean OutOfTheTrackLimits(int x,int y){
        return refLinks.getWorld().getTile(x,y).OutOfTrackLimits();
    }
    public int getIsOutsideTrackLimits(){
        int var=isOutsideTrackLimits;
        if(isOutsideTrackLimits==1){
            isOutsideTrackLimits=0;
        }
        return var;
    }


    public boolean InThePitLane(int x, int y){
        return refLinks.getWorld().getTile(x,y).PitLane();
    }
    public int getIsInsidePitLane(){
        int var=isInsidePitLane;
        if(isInsidePitLane==1){
            isInsidePitLane=0;
        }
        return var;
    }


    public boolean InThePitBox(int x,int y){
        return refLinks.getWorld().getTile(x,y).PitBox();
    }
    public int getIsInThePitBox(){
        int var=isInThePitBox;
        if(isInThePitBox==1){
            isInThePitBox=0;
        }
        return var;
    }


    public boolean CutTheCorner(int x,int y){
        return refLinks.getWorld().getTile(x,y).CutTheCorner();
    }
    public int getHasCutTheCorner(){
        int var=hasCutTheCorner;
        if(hasCutTheCorner==1){
            hasCutTheCorner=0;
        }
        return var;
    }


    //dedesubt se regasesc metode get si set

    public double getxMove() {
        return xMove;
    }

    public void setxMove(double xMove) {
        this.xMove = xMove;
    }

    public double getyMove() {
        return yMove;
    }

    public void setyMove(double yMove) {
        this.yMove = yMove;
    }


    public int getXPositionRectangle(){
        return position_rectangle.x;
    }

    public int getYPositionRectangle(){
        return position_rectangle.y;
    }

    public int getWidthPositionRectangle(){
        return position_rectangle.width;
    }

    public int getHeightPositionRectangle(){
        return position_rectangle.height;
    }


    public int getPlayerDamage() {
        return damage.getDamage();
    }

    public void setPlayerDamage() {
        this.damage.setDamage(damage.increaseDamage());
    }


    public double getPlayerSpeed() {
        return speed.getSpeed();
    }


    public double getPlayerEngineWear() {
        return engineWear.getEngineWear();
    }

    public void setPlayerEngineWear() {
        this.engineWear.setEngineWear(engineWear.increaseWear(collision));
    }


    public double getPlayerTyresDegradation(){
        return tyresDegradation.getTyresDegradation();
    }

    public void setPlayerTyresDegradation(){
        this.tyresDegradation.setTyresDegradation(tyresDegradation.increaseWear(collision));
    }


    public double getPlayerGearBoxWear() {
        return gearBox.getGearBoxWear();
    }

    public void setPlayerGearBoxWear() {
        this.gearBox.setGearBoxWear(gearBox.increaseWear(collision));
    }


    public void setParameters() {
        gearBox.setPlayerGear(getPlayerSpeed());
        setPlayerEngineWear();
        setPlayerGearBoxWear();
        setPlayerTyresDegradation();
        fuel.FuelConsumption();
        kers.KERSConsumption();
    }


    public void AfterWinning(){
        gearBox.setGearBoxWear(0);
        engineWear.setEngineWear(0);
        tyresDegradation.setTyresDegradation(0);
        damage.setDamage(0);
    }


    // Metode utilizate in gameState
    // Cu ajutorul lor, se iau obiectele din player si prin metoda render a fiecaruia se vor afisa informatii pe ecran

    public Damage getFullDamageObject(){
        return this.damage;
    }

    public Speed getFullSpeedObject(){
        return this.speed;
    }

    public GearBox getFullGearBoxObject(){
        return this.gearBox;
    }

    public TyresDegradation getFullTyresDegradationObject(){
        return this.tyresDegradation;
    }

    public EngineWear getFullEngineWearObject(){
        return this.engineWear;
    }

    public Fuel getFullFuelObject(){
        return this.fuel;
    }

    public KERS getFullKERSObject(){
        return this.kers;
    }

    public DRS getFullDRSObject(){
        return this.drs;
    }
}