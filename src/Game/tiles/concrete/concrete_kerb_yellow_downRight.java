package Game.tiles.concrete;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class concrete_kerb_yellow_downRight extends Tile {
    public concrete_kerb_yellow_downRight(int ID){
        super(Assets.concrete_kerb_yellow_downRight,ID);
    }

    @Override
    public boolean PitLane(){return true;}
}
