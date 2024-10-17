package Game.tiles.concrete;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class concrete_kerb_red_downLeft extends Tile {
    public concrete_kerb_red_downLeft(int ID){
        super(Assets.concrete_kerb_red_downLeft,ID);
    }

    @Override
    public boolean PitLane(){return true;}
}
