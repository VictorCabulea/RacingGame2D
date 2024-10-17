package Game.worlds;

import java.awt.Graphics;

import Game.RefLinks;
import Game.entities.Entity;
import Game.entities.EntityManager;
import Game.entities.creatures.Player;
import Game.tiles.Tile;
import Game.utils.Utils;

public class World {

    private RefLinks refLinks;

    private int width;// latimea lumii (in tile-uri)
    private int height;// inaltimea lumii (in tile-uri).

    private int SpawnX;
    private int SpawnY;

    private int [][] tiles;

    private EntityManager entityManager;

    public World(RefLinks refLinks, String path){
        this.refLinks = refLinks;
        entityManager=new EntityManager(refLinks,new Player(refLinks,100,100));
        loadWorld(path);

        entityManager.getPlayer().setX(SpawnX);
        entityManager.getPlayer().setY(SpawnY);
    }


    public void update(){
        entityManager.update();
    }

    public void render(Graphics g){
        // se vor desena pe ecran doar tile-urile vizibile la un anumit moment, restul aparand pe ecran odata cu deplasarea jucatorului
        int xStart=(int)(Math.max(0, refLinks.getGameCamera().getxOffset()/Tile.TILEWIDTH));// limita din stanga a ecraului vizibil de catre utilizator
        // xStart va fi pozitia primului tile vizibil;
        // in cazul in care xStart va fi 0, atunci inseamna ca imaginea afisata pe ecran contine prima coloana de tile-uri din stanga
        int xEnd=(int)(Math.min(width,(refLinks.getGameCamera().getxOffset()+ refLinks.getWidth())/Tile.TILEWIDTH+1));// limita din dreapta a ecraului vizibil de catre utilizator
        int yStart=(int)(Math.max(0, refLinks.getGameCamera().getyOffset()/Tile.TILEHEIGHT));;// limita superioara a ecraului vizibil de catre utilizator
        int yEnd=(int)(Math.min(height,(refLinks.getGameCamera().getyOffset()+ refLinks.getHeight())/Tile.TILEHEIGHT+1));;// limita inferioara a ecraului vizibil de catre utilizator

        for(int y = yStart;y <yEnd;y++){
            for(int x = xStart;x < xEnd;x++){
                getTile(x, y).render(g, (int)(x * Tile.TILEWIDTH- refLinks.getGameCamera().getxOffset()), (int)(y * Tile.TILEHEIGHT- refLinks.getGameCamera().getyOffset()));
            }
        }

        entityManager.render(g);
    }

    public Tile getTile(int x, int y){
        // In cazul in care jucatorul paraseste harta, jocul va crea un tile cu iarba
        if(x<0||y<0||x>=width||y>=height)
            return Tile.grassTile;

        Tile t = Tile.tiles[tiles[x][y]];// apel vector tiles din clasa Tile
        // vectorul va avea ca index tile-ul de la indexul x,y din matricea tile[][]

        // In cazul in care nu se citeste nicun tile, jocul va crea un tile cu iarba
        if(t == null)
            return Tile.grassTile;
        return t;
    }

    public void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        // ia fiecare numar din fisierul hartii si il introduce intr-un string

        width = Utils.parseInt(tokens[0]);// ia prima valoare din fisierul in care este stocata harta. Ea va fi latimea hartii.
        height = Utils.parseInt(tokens[1]);// ia a doua valoare din fisierul in care este stocata harta. Ea va fi inaltimea hartii.

        SpawnX =Utils.parseInt(tokens[2]);// pozitia initiala pe axa X la care va fi pus jucatorul
        SpawnY = Utils.parseInt(tokens[3]);// pozitia initiala pe axa Y la care va fi pus jucatorul

        // Restul valorilor din fisierul care contine harta vor fi stocate in matricea tile[][]
        tiles = new int[width][height];
        for(int y = 0;y < height;y++){
            for(int x = 0;x < width;x++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
                //+2 din cauza ca primele 2 valori din fisier sunt latimea si lungimea hartii
            }
        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSpawnX() {
        return SpawnX;
    }

    public void setSpawnX(int spawnX) {
        SpawnX = spawnX;
    }

    public int getSpawnY() {
        return SpawnY;
    }

    public void setSpawnY(int spawnY) {
        SpawnY = spawnY;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}








