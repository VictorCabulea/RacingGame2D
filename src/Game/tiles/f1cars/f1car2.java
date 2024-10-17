package Game.tiles.f1cars;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class f1car2 extends Tile {
    public f1car2(int ID){
        super(Assets.f1car2,ID);
    }

    @Override
    public boolean isNotDrivable(){
        return true;
    }
}
