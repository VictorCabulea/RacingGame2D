package Game.tiles.grass;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class GrassFinishLine extends Tile {

    public GrassFinishLine(int ID){
        super(Assets.grassFinishLine,ID);
    }

    @Override
    public boolean FinishLane(){return true;}
}
