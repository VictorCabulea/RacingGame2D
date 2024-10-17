package Game.tiles.concrete;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class concrete_kerb_yellow_upRight extends Tile {
    public concrete_kerb_yellow_upRight(int ID){
        super(Assets.concrete_kerb_yellow_upRight,ID);
    }

    @Override
    public boolean PitLane(){return true;}
}
