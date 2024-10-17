package Game;

import Game.utils.UI.UiManager;

import java.awt.event.*;

public class MouseInput implements MouseListener, MouseMotionListener {

    private boolean leftPressed,rightPressed;
    private int mouseX,mouseY;
    private UiManager uiManager;

    public MouseInput(){

    }

    public void setUiManager(UiManager uiManager) {
        this.uiManager = uiManager;
    }

    public boolean isLeftPressed(){
        return leftPressed;
    }

    public boolean isRightPressed(){
        return rightPressed;
    }

    public int getMouseX(){
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // apelata cand un buton al mouse-ului a fost apasat pe o alta componenta (un buton de pe ecran)
        if(e.getButton()==MouseEvent.BUTTON1)
            leftPressed = true;
        else if(e.getButton()==MouseEvent.BUTTON3)
            rightPressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // apelata cand un buton al mouse-ului a fost ridicat de pe o alta componenta (un buton de pe ecran)
        if(e.getButton()==MouseEvent.BUTTON1)
            leftPressed = false;
        else if(e.getButton()==MouseEvent.BUTTON3)
            rightPressed = false;

        if(uiManager != null){
            uiManager.onMouseRelease(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();

        if(uiManager != null){
            uiManager.onMouseMove(e);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // apelata cand cursorul paraseste suprafata unui obiect de pe ecran

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // apelata cand cursorul a intrat pe suprafata unui obiect de pe ecran
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // apelata atunci cand un buton de pe mouse a fost apasat si ridicat (click)
    }

}
