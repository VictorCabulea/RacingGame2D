package Game.tiles.concrete;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class ConcretePitLaneExit extends Tile {
    public ConcretePitLaneExit(int ID){
        super(Assets.concretePitLaneExit,ID);
    }

    @Override
    public boolean PitLane(){return true;}
}
