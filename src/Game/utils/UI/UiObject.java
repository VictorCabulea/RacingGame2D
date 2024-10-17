package Game.utils.UI;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UiObject {

    protected double x;
    protected double y;
    protected int width;
    protected int height;

    protected Rectangle bounds;

    protected boolean hovering;

    public UiObject(double x,double y,int width,int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;

        bounds=new Rectangle((int)x,(int)y,width,height);
        // Dreptunghiul bounds va acoperi suprafata butonului, pentru a se putea verifica daca mouse-ul se afla pe suprafata sa

        hovering=false;
        // Daca utilizatorul va pune mouse-ul pe suprafata butonului, variabila va lua valoarea "true"
    }

    public abstract void update();

    public abstract void render(Graphics g);

    public abstract void onClick();
    // fiecare UiObject va putea sti daca utilizatorul va apasa pe el sau nu

    public void onMouseMove(MouseEvent e){
        if(bounds.contains(e.getX(),e.getY()))
            hovering=true;
        else
            hovering=false;
    }

    public void onMouseRelease(MouseEvent e){
        //verifica daca utilizatorul a apasat pe obiect/buton
        if(hovering==true)
            onClick();
    }

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

    public boolean isHovering() {
        return hovering;
    }

    public void setHovering(boolean hovering) {
        this.hovering = hovering;
    }
}
