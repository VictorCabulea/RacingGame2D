package Game.entities;

import Game.RefLinks;
import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class Entity {

    protected RefLinks refLinks;

    protected double x;// coordonate pozitie pe ecran
    protected double y;// coordonate pozitie pe ecran
    // float pentru mai multa acuratete a pozitiei

    protected int width;// latimea personajului
    protected int height;// inaltimea personajului

    protected Rectangle collide_rectangle;
    protected Rectangle position_rectangle;

    public Entity(RefLinks refLinks, double x, double y, int width, int height){
        this.refLinks = refLinks;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        collide_rectangle = new Rectangle();
        position_rectangle = new Rectangle();
    }

    public abstract void update();

    public abstract void render(Graphics g);

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
