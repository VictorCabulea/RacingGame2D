package Game.tiles.concrete;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class concrete_kerb_red_downRight extends Tile {
    public concrete_kerb_red_downRight(int ID){
        super(Assets.concrete,ID);
    }

    @Override
    public boolean PitLane(){return true;}
}
