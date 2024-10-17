package Game.tiles.concrete;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class ConcretePitBox extends Tile {
    public ConcretePitBox(int ID){
        super(Assets.concretePitBox,ID);
    }

    @Override
    public boolean PitLane(){return true;}

    @Override
    public boolean PitBox(){return true;}

}
