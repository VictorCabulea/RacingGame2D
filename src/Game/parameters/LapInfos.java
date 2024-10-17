package Game.parameters;

import Game.RefLinks;
import Game.entities.creatures.Player;
import Game.physics.Time;
import Game.tiles.Tile;

import java.awt.*;

public class LapInfos {

    private RefLinks refLinks;
    private Player player;

    private Time time;

    public LapInfos(RefLinks refLinks, Player player){
        this.refLinks=refLinks;
        this.player=player;
        this.time=new Time();
    }

    public boolean CrossedTheFinishLineTime(int x, int y) {
        return refLinks.getWorld().getTile(x, y).FinishLane();
    }

    public void SpeedingInThePitLaneTimePenalty(){
        time.TimePenalty();
    }

    public void CuttingTheCornerTimePenalty(){
        time.TimePenalty();
    }

    public void update(int x, int y){
        time.update();

        int tempx = (int) (x + player.getxMove() + player.getXPositionRectangle() + player.getWidthPositionRectangle()) / Tile.TILEWIDTH;

        if(CrossedTheFinishLineTime(tempx, (int) (y + player.getYPositionRectangle()) / Tile.TILEHEIGHT) == true && CrossedTheFinishLineTime(tempx, (int) (y + player.getYPositionRectangle() + player.getHeightPositionRectangle()) / Tile.TILEHEIGHT) == true && refLinks.getKeyManager().right==true){
            time.setTime_final();
            time.setTime_current();
            time.setTime_init();
            player.getFullKERSObject().setCurrent_KERS_Level(6);
        }
    }

    public void render(Graphics g){
        time.render(g);

        if(time.getLapCount()<=5)
            g.drawString("Lap "+ time.getLapCount() +"/ 5",30,50);
        else
            g.drawString("Lap 5/ 5",30,50);
    }

    public int Winning(){
        int var=0;
        if(time.getWinVariable()==1) {
            time.setWinVariable(0);
            var=1;
        }
        return var;
    }

    public void AfterWinning(){
        time.setLapCount(0);
        time.setTIME_TO_BEAT(90000);
        time.setTotal_time(0);
    }
}
