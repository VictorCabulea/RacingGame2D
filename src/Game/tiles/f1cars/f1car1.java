package Game.tiles.f1cars;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class f1car1 extends Tile {
    public f1car1(int ID){
        super(Assets.f1car1,ID);
    }

    @Override
    public boolean isNotDrivable(){
        return true;
    }
}
