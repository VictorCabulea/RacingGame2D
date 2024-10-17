package Game.tiles.concrete;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class Concrete extends Tile {
    public Concrete(int ID){
        super(Assets.concrete,ID);
    }

    @Override
    public boolean PitLane(){return true;}
}
