package Game.tiles.f1cars;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class f1car5 extends Tile {
    public f1car5(int ID){
        super(Assets.f1car5,ID);
    }

    @Override
    public boolean isNotDrivable(){
        return true;
    }
}
