package Game.tiles.grass;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class GrassCutTheCorner extends Tile {

    public GrassCutTheCorner(int ID){
        super(Assets.grassCutTheCorner,ID);
    }

    @Override
    public boolean OutOfTrackLimits() {
        return true;
    }

    @Override
    public boolean CutTheCorner(){return true;}
}
