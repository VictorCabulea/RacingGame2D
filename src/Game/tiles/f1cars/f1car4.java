package Game.tiles.f1cars;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class f1car4 extends Tile {
    public f1car4(int ID){
        super(Assets.f1car4,ID);
    }

    @Override
    public boolean isNotDrivable(){
        return true;
    }
}
