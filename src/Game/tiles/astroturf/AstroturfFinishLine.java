package Game.tiles.astroturf;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class AstroturfFinishLine extends Tile {

    public AstroturfFinishLine(int ID){
        super(Assets.astroturfFinishLine,ID);
    }

    @Override
    public boolean FinishLane(){return true;}
}
