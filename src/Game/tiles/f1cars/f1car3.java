package Game.tiles.f1cars;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class f1car3 extends Tile {
    public f1car3(int ID){
        super(Assets.f1car3,ID);
    }

    @Override
    public boolean isNotDrivable(){
        return true;
    }
}
