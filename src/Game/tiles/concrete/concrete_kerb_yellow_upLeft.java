package Game.tiles.concrete;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class concrete_kerb_yellow_upLeft extends Tile {
    public concrete_kerb_yellow_upLeft(int ID){
        super(Assets.concrete_kerb_yellow_upLeft,ID);
    }

    @Override
    public boolean PitLane(){return true;}
}
