package Game.tiles.concrete;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class ConcretePitLane extends Tile {
    public ConcretePitLane(int ID){
        super(Assets.concretePitLane,ID);
    }

    @Override
    public boolean PitLane(){return true;}
}
