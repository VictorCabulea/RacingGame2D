package Game.tiles.f1cars;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class f1car7 extends Tile {
    public f1car7(int ID){
        super(Assets.f1car7,ID);
    }

    @Override
    public boolean isNotDrivable(){
        return true;
    }
}
