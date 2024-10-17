package Game.utils.UI;

import Game.RefLinks;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UiManager {

    private RefLinks refLinks;
    private ArrayList<UiObject>objects;

    public UiManager(RefLinks refLinks){
        this.refLinks=refLinks;
        objects=new ArrayList<UiObject>();
    }

    public void update(){
        for(UiObject o : objects)
            o.update();
    }

    public void render(Graphics g){
        for(UiObject o : objects)
            o.render(g);
    }

    public void onMouseMove(MouseEvent e){
        for(UiObject o : objects)
            o.onMouseMove(e);
    }

    public void onMouseRelease(MouseEvent e){
        for(UiObject o : objects)
            o.onMouseRelease(e);
    }

    public void addObject(UiObject o){
        objects.add(o);
    }

    public void removeObject(UiObject o){
        objects.remove(o);
    }

    public ArrayList<UiObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UiObject> objects) {
        this.objects = objects;
    }

    public RefLinks getRefLinks() {
        return refLinks;
    }

    public void setRefLinks(RefLinks refLinks) {
        this.refLinks = refLinks;
    }
}
