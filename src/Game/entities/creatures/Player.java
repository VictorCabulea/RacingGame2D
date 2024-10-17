package Game.entities.creatures;

import Game.RefLinks;
import Game.graphics.Assets;

import java.awt.*;


public class Player extends Creature {

    protected int indexIMG=3;
    protected int indexSPEED=0;

    public Player(RefLinks refLinks, double x, double y) {
        super(refLinks, 3750, 700, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        //valorile 700 si 500 sunt coordonatele pozitiei jucatorului la inceputul jocului
        position_rectangle.x = 105;
        position_rectangle.y = 120;
        position_rectangle.width = 10;
        position_rectangle.height = 10;
    }

    @Override
    public void update() {
        getInput();
        move();// metoda move din clasa Creature
        refLinks.getGameCamera().centeredOnTheEntity(this);
    }

    private void getInput() {
        xMove=0;
        yMove=0;
        // egale cu 0 pentru a incepe jocul de pe loc/ fara miscare

        // deplasare sus, jos, stanga, dreapta
        if(refLinks.getKeyManager().up == true && refLinks.getKeyManager().down == false && refLinks.getKeyManager().right == false && refLinks.getKeyManager().left == false){
            yMove=-speed.IncreaseSpeed();//sus
            indexSPEED=1;
        }
        if(refLinks.getKeyManager().up == false && refLinks.getKeyManager().down == true && refLinks.getKeyManager().right == false && refLinks.getKeyManager().left == false) {
            yMove = speed.IncreaseSpeed();//jos
            indexSPEED=2;
        }
        if(refLinks.getKeyManager().up == false && refLinks.getKeyManager().down == false && refLinks.getKeyManager().right == true && refLinks.getKeyManager().left == false) {
            xMove = speed.IncreaseSpeed();//dreapta
            indexSPEED=3;
        }
        if(refLinks.getKeyManager().up == false && refLinks.getKeyManager().down == false && refLinks.getKeyManager().right == false && refLinks.getKeyManager().left == true) {
            xMove = -speed.IncreaseSpeed();//stanga
            indexSPEED=4;
        }

        // deplasare diagonala
        // dreapta-sus, dreapta-jos, stanga-sus, dreapta-sus
        if(refLinks.getKeyManager().up == true && refLinks.getKeyManager().down == false && refLinks.getKeyManager().right == true && refLinks.getKeyManager().left == false) {
            yMove = -speed.IncreaseSpeed()/1.41;
            xMove = speed.IncreaseSpeed()/1.41;
            //diagonala: dreapta sus
            indexSPEED=5;
        }
        if(refLinks.getKeyManager().up == true && refLinks.getKeyManager().down == false && refLinks.getKeyManager().right == false && refLinks.getKeyManager().left == true) {
            yMove = -speed.IncreaseSpeed()/1.41;
            xMove = -speed.IncreaseSpeed()/1.41;
            //diagonala: stanga sus
            indexSPEED=6;
        }
        if(refLinks.getKeyManager().up == false && refLinks.getKeyManager().down == true && refLinks.getKeyManager().right == true && refLinks.getKeyManager().left == false) {
            yMove = speed.IncreaseSpeed()/1.41;
            xMove = speed.IncreaseSpeed()/1.41;
            //diagonala: dreapta jos
            indexSPEED=7;
        }
        if(refLinks.getKeyManager().up == false && refLinks.getKeyManager().down == true && refLinks.getKeyManager().right == false && refLinks.getKeyManager().left == true) {
            yMove = speed.IncreaseSpeed()/1.41;
            xMove = -speed.IncreaseSpeed()/1.41;
            //diagonala: stanga jos
            indexSPEED=8;
        }
        if ((refLinks.getKeyManager().up == false && refLinks.getKeyManager().down == false && refLinks.getKeyManager().right == false && refLinks.getKeyManager().left == false)
                || (refLinks.getKeyManager().up == true && refLinks.getKeyManager().down == true && refLinks.getKeyManager().right == true && refLinks.getKeyManager().left == false)
                || (refLinks.getKeyManager().up == true && refLinks.getKeyManager().down == true && refLinks.getKeyManager().right == false && refLinks.getKeyManager().left == true)
                || (refLinks.getKeyManager().up == true && refLinks.getKeyManager().down == false && refLinks.getKeyManager().right == true && refLinks.getKeyManager().left == true)
                || (refLinks.getKeyManager().up == false && refLinks.getKeyManager().down == true && refLinks.getKeyManager().right == true && refLinks.getKeyManager().left == true)
                || (refLinks.getKeyManager().up == true && refLinks.getKeyManager().down == true && refLinks.getKeyManager().right == true && refLinks.getKeyManager().left == true)
                || (refLinks.getKeyManager().up == true && refLinks.getKeyManager().down == true)
                || (refLinks.getKeyManager().right == true && refLinks.getKeyManager().left == true))
        {
            if (indexSPEED == 1) {
                yMove = -speed.DecreaseSpeed();
            }
            if (indexSPEED == 2) {
                yMove = speed.DecreaseSpeed();
                }
            if (indexSPEED == 3) {
                xMove = speed.DecreaseSpeed();
            }
            if (indexSPEED == 4) {
                xMove = -speed.DecreaseSpeed();
            }

            if (indexSPEED == 5) {
                xMove = speed.DecreaseSpeed();
                yMove = -speed.DecreaseSpeed();
            }
            if (indexSPEED == 6) {
                xMove = -speed.DecreaseSpeed();
                yMove = -speed.DecreaseSpeed();
            }
            if (indexSPEED == 7) {
                xMove = speed.DecreaseSpeed();
                yMove = speed.DecreaseSpeed();
            }
            if (indexSPEED == 8) {
                xMove = -speed.DecreaseSpeed();
                yMove = speed.DecreaseSpeed();
            }
        }
    }

    @Override
    public void render(Graphics g) {

        //Daca jucatorul va fi in miscare, se vor afisa imagini in functie de tasta/tastele apasate

        //Miscare sus, jos, stanga, dreapta
        if(refLinks.getKeyManager().up == true && refLinks.getKeyManager().down == false && refLinks.getKeyManager().right == false && refLinks.getKeyManager().left == false){
            collide_rectangle.x = 80;
            collide_rectangle.y = 0;
            collide_rectangle.width = 98;
            collide_rectangle.height = 256;
            g.drawImage(Assets.player_up, (int) (x - refLinks.getGameCamera().getxOffset()), (int) (y - refLinks.getGameCamera().getyOffset()), width, height, null);
            //Pentru testare: afisare pe ecran dreptunghi de coliziune
            //g.setColor(Color.red);
            //g.fillRect((int) (x + position_rectangle.x - refLinks.getGameCamera().getxOffset()), (int) (y + position_rectangle.y - refLinks.getGameCamera().getyOffset()), position_rectangle.width, position_rectangle.height);
            indexIMG = 1;
        }
        if(refLinks.getKeyManager().up == false && refLinks.getKeyManager().down == true && refLinks.getKeyManager().right == false && refLinks.getKeyManager().left == false) {
            collide_rectangle.x = 80;
            collide_rectangle.y = 0;
            collide_rectangle.width = 98;
            collide_rectangle.height = 256;
            g.drawImage(Assets.player_down, (int) (x - refLinks.getGameCamera().getxOffset()), (int) (y - refLinks.getGameCamera().getyOffset()), width, height, null);
            //Pentru testare: afisare pe ecran dreptunghi de coliziune
            //g.setColor(Color.red);
            //g.fillRect((int) (x + position_rectangle.x - refLinks.getGameCamera().getxOffset()), (int) (y + position_rectangle.y - refLinks.getGameCamera().getyOffset()), position_rectangle.width, position_rectangle.height);
            indexIMG = 2;
        }
        if(refLinks.getKeyManager().up == false && refLinks.getKeyManager().down == false && refLinks.getKeyManager().right == true && refLinks.getKeyManager().left == false) {
            collide_rectangle.x = 0;
            collide_rectangle.y = 80;
            collide_rectangle.width = 256;
            collide_rectangle.height = 98;
            g.drawImage(Assets.player_right, (int) (x - refLinks.getGameCamera().getxOffset()), (int) (y - refLinks.getGameCamera().getyOffset()), width, height, null);
            //Pentru testare: afisare pe ecran dreptunghi de coliziune
            //g.setColor(Color.red);
            //g.setColor(Color.red);
            //g.fillRect((int) (x + position_rectangle.x - refLinks.getGameCamera().getxOffset()), (int) (y + position_rectangle.y - refLinks.getGameCamera().getyOffset()), position_rectangle.width, position_rectangle.height);
            indexIMG = 3;
        }
        if(refLinks.getKeyManager().up == false && refLinks.getKeyManager().down == false && refLinks.getKeyManager().right == false && refLinks.getKeyManager().left == true) {
            collide_rectangle.x = 0;
            collide_rectangle.y = 80;
            collide_rectangle.width = 256;
            collide_rectangle.height = 98;
            g.drawImage(Assets.player_left, (int) (x - refLinks.getGameCamera().getxOffset()), (int) (y - refLinks.getGameCamera().getyOffset()), width, height, null);
            //Pentru testare: afisare pe ecran dreptunghi de coliziune
            //g.setColor(Color.red);
            //g.fillRect((int) (x + position_rectangle.x - refLinks.getGameCamera().getxOffset()), (int) (y + position_rectangle.y - refLinks.getGameCamera().getyOffset()), position_rectangle.width, position_rectangle.height);
            indexIMG = 4;
        }


        // Miscare pe diagonale
        if(refLinks.getKeyManager().up == true && refLinks.getKeyManager().down == false && refLinks.getKeyManager().right == true && refLinks.getKeyManager().left == false) {
            collide_rectangle.x = 180;
            collide_rectangle.y = 20;
            collide_rectangle.width = 60;
            collide_rectangle.height = 60;
            g.drawImage(Assets.player_rightUP, (int) (x - refLinks.getGameCamera().getxOffset()), (int) (y - refLinks.getGameCamera().getyOffset()), width, height, null);
            //Pentru testare: afisare pe ecran dreptunghi de coliziune
            //g.setColor(Color.red);
            //g.fillRect((int) (x + position_rectangle.x - refLinks.getGameCamera().getxOffset()), (int) (y + position_rectangle.y - refLinks.getGameCamera().getyOffset()), position_rectangle.width, position_rectangle.height);
            indexIMG = 5;
        }
        // diagonala: dreapta sus

        if(refLinks.getKeyManager().up == true && refLinks.getKeyManager().down == false && refLinks.getKeyManager().right == false && refLinks.getKeyManager().left == true) {
            collide_rectangle.x = 20;
            collide_rectangle.y = 20;
            collide_rectangle.width = 60;
            collide_rectangle.height = 60;
            g.drawImage(Assets.player_leftUP, (int) (x - refLinks.getGameCamera().getxOffset()), (int) (y - refLinks.getGameCamera().getyOffset()), width, height, null);
            //Pentru testare: afisare pe ecran dreptunghi de coliziune
            //g.setColor(Color.red);
            //g.fillRect((int) (x + position_rectangle.x - refLinks.getGameCamera().getxOffset()), (int) (y + position_rectangle.y - refLinks.getGameCamera().getyOffset()), position_rectangle.width, position_rectangle.height);
            indexIMG = 6;
        }
        // diagonala: stanga sus

        if(refLinks.getKeyManager().up == false && refLinks.getKeyManager().down == true && refLinks.getKeyManager().right == true && refLinks.getKeyManager().left == false) {
            collide_rectangle.x = 180;
            collide_rectangle.y = 180;
            collide_rectangle.width = 60;
            collide_rectangle.height = 60;
            g.drawImage(Assets.player_rightDOWN, (int) (x - refLinks.getGameCamera().getxOffset()), (int) (y - refLinks.getGameCamera().getyOffset()), width, height, null);
            //Pentru testare: afisare pe ecran dreptunghi de coliziune
            //g.setColor(Color.red);
            //g.fillRect((int) (x + position_rectangle.x - refLinks.getGameCamera().getxOffset()), (int) (y + position_rectangle.y - refLinks.getGameCamera().getyOffset()), position_rectangle.width, position_rectangle.height);
            int index = 7;
        }
        // diagonala: dreapta jos

        if(refLinks.getKeyManager().up == false && refLinks.getKeyManager().down == true && refLinks.getKeyManager().right == false && refLinks.getKeyManager().left == true) {
            collide_rectangle.x = 20;
            collide_rectangle.y = 180;
            collide_rectangle.width = 60;
            collide_rectangle.height = 60;
            g.drawImage(Assets.player_leftDOWN, (int) (x - refLinks.getGameCamera().getxOffset()), (int) (y - refLinks.getGameCamera().getyOffset()), width, height, null);
            //Pentru testare: afisare pe ecran dreptunghi de coliziune
            //g.setColor(Color.red);
            //g.fillRect((int) (x + collide_rectangle.x - refLinks.getGameCamera().getxOffset()), (int) (y + collide_rectangle.y - refLinks.getGameCamera().getyOffset()), collide_rectangle.width, collide_rectangle.height);
            indexIMG=8;
        }
        // diagonala: stanga jos

        // In cazul in care nu se va apasa nicio tasta, jucatorul va sta pe loc, jocul punand pe ecran aceasta imagine
        if ((refLinks.getKeyManager().up == false && refLinks.getKeyManager().down == false && refLinks.getKeyManager().right == false && refLinks.getKeyManager().left == false)
                || (refLinks.getKeyManager().up == true && refLinks.getKeyManager().down == true && refLinks.getKeyManager().right == true && refLinks.getKeyManager().left == false)
                || (refLinks.getKeyManager().up == true && refLinks.getKeyManager().down == true && refLinks.getKeyManager().right == false && refLinks.getKeyManager().left == true)
                || (refLinks.getKeyManager().up == true && refLinks.getKeyManager().down == false && refLinks.getKeyManager().right == true && refLinks.getKeyManager().left == true)
                || (refLinks.getKeyManager().up == false && refLinks.getKeyManager().down == true && refLinks.getKeyManager().right == true && refLinks.getKeyManager().left == true)
                || (refLinks.getKeyManager().up == true && refLinks.getKeyManager().down == true && refLinks.getKeyManager().right == true && refLinks.getKeyManager().left == true)
                || (refLinks.getKeyManager().up == true && refLinks.getKeyManager().down == true)
                || (refLinks.getKeyManager().right == true && refLinks.getKeyManager().left == true))
        {
            if (indexIMG == 1)
                g.drawImage(Assets.player_up, (int) (x - refLinks.getGameCamera().getxOffset()), (int) (y - refLinks.getGameCamera().getyOffset()), width, height, null);
            if (indexIMG == 2)
                g.drawImage(Assets.player_down, (int) (x - refLinks.getGameCamera().getxOffset()), (int) (y - refLinks.getGameCamera().getyOffset()), width, height, null);
            if (indexIMG == 3)
                g.drawImage(Assets.player_right, (int) (x - refLinks.getGameCamera().getxOffset()), (int) (y - refLinks.getGameCamera().getyOffset()), width, height, null);
            if (indexIMG == 4)
                g.drawImage(Assets.player_left, (int) (x - refLinks.getGameCamera().getxOffset()), (int) (y - refLinks.getGameCamera().getyOffset()), width, height, null);
            if (indexIMG == 5)
                g.drawImage(Assets.player_rightUP, (int) (x - refLinks.getGameCamera().getxOffset()), (int) (y - refLinks.getGameCamera().getyOffset()), width, height, null);
            if (indexIMG == 6)
                g.drawImage(Assets.player_leftUP, (int) (x - refLinks.getGameCamera().getxOffset()), (int) (y - refLinks.getGameCamera().getyOffset()), width, height, null);
            if (indexIMG == 7)
                g.drawImage(Assets.player_rightDOWN, (int) (x - refLinks.getGameCamera().getxOffset()), (int) (y - refLinks.getGameCamera().getyOffset()), width, height, null);
            if (indexIMG == 8)
                g.drawImage(Assets.player_leftDOWN, (int) (x - refLinks.getGameCamera().getxOffset()), (int) (y - refLinks.getGameCamera().getyOffset()), width, height, null);
        }
    }
}