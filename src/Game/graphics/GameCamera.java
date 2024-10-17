package Game.graphics;

import Game.RefLinks;
import Game.entities.Entity;
import Game.tiles.Tile;

public class GameCamera {

    private RefLinks refLinks;
    private double xOffset; // diferenta pe axa Ox fata de pozitia initiala
    private double yOffset; // diferenta pe axa Oy fata de pozitia initiala

    public GameCamera(RefLinks refLinks, double xOffset, double yOffset){
        this.refLinks = refLinks;
        this.xOffset=xOffset;
        this.yOffset=yOffset;
    }

    public void checkLimtsOfTheWorld(){
        if(xOffset<0){
            xOffset=0;
        }else if(xOffset> refLinks.getWorld().getWidth()* Tile.TILEWIDTH- refLinks.getWidth()){
            // Verifica daca xOffset este mai mare decat latimea lumii - latimea ferestrei
            xOffset= refLinks.getWorld().getWidth()* Tile.TILEWIDTH- refLinks.getWidth();
        }
        if(yOffset<0){
            yOffset=0;
        }else if(yOffset> refLinks.getWorld().getHeight()*Tile.TILEHEIGHT- refLinks.getHeight()){
            yOffset= refLinks.getWorld().getHeight()*Tile.TILEHEIGHT- refLinks.getHeight();;
        }
    }

    public void centeredOnTheEntity(Entity e){
        xOffset=e.getX() - refLinks.getWidth()/2+e.getWidth()/2;// impartire la 2 pentru a fixa jucatorul la mijlocul ecranului
        yOffset=e.getY() - refLinks.getHeight()/2+e.getHeight()/2;
        checkLimtsOfTheWorld();
    }

    public void move(double xAmount,double yAmount){
        xOffset=xOffset+xAmount;
        yOffset=yOffset+yAmount;
        checkLimtsOfTheWorld();
    }

    public double getxOffset() {
        return xOffset;
    }

    public void setxOffset(double xOffset) {
        this.xOffset = xOffset;
    }

    public double getyOffset() {
        return yOffset;
    }

    public void setyOffset(double yOffset) {
        this.yOffset = yOffset;
    }
}
