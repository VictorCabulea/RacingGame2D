package Game.tiles.gravel;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class GravelCutTheCorner extends Tile {

    public GravelCutTheCorner(int ID){
        super(Assets.gravelCutTheCorner,ID);
    }

    @Override
    public boolean OutOfTrackLimits() {
        return true;
    }

    @Override
    public boolean CutTheCorner(){return true;}

}
