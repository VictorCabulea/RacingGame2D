package Game.tiles.concrete;

import Game.graphics.Assets;
import Game.tiles.Tile;

public class ConcreteFinishLine extends Tile {

    public ConcreteFinishLine(int ID){
        super(Assets.concreteGrid,ID);
    }

    @Override
    public boolean FinishLane(){return true;}

    @Override
    public boolean PitLane(){return true;}
}
