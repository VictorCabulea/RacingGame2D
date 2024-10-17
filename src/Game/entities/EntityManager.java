package Game.entities;

import Game.RefLinks;
import Game.entities.creatures.Player;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {

    private RefLinks refLinks;
    private Player player;

    private ArrayList<Entity> entities;

    public EntityManager(RefLinks refLinks,Player player){
        this.refLinks=refLinks;
        this.player=player;

        entities=new ArrayList<Entity>();
    }

    public void update(){
        for(int i=0;i<entities.size();i++){
            Entity e=entities.get(i);
            e.update();
        }
        player.update();
    }

    public void render(Graphics g) {
        for(Entity e : entities)
            e.render(g);
        player.render(g);
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    public RefLinks getRefLinks() {
        return refLinks;
    }

    public void setRefLinks(RefLinks refLinks) {
        this.refLinks = refLinks;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
