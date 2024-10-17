package Game.tiles.concrete;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class Concrete60 extends Tile {
    public Concrete60(int ID){
        super(Assets.concrete60,ID);
    }

    @Override
    public boolean PitLane(){return true;}
}
