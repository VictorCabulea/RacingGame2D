package Game.tiles.grass;
import Game.graphics.Assets;
import Game.tiles.Tile;

public class GrassTile extends Tile {

    public GrassTile(int ID){
        super(Assets.grass,ID);
    }

    @Override
    public boolean OutOfTrackLimits() {
        return true;
    }
}
