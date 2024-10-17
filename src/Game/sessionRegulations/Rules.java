package Game.sessionRegulations;

import Game.entities.creatures.Player;
import Game.parameters.LapInfos;
import Game.sessionRegulations.flags.RedFlag;
import Game.sessionRegulations.flags.YellowFlag;

import java.awt.*;

public class Rules {

    private Player player;
    private LapInfos lapInfos;
    private YellowFlag yellowFlag;
    private RedFlag redFlag;

    private int var;

    public Rules(Player player, LapInfos lapInfos){
        this.player=player;
        this.lapInfos=lapInfos;
        yellowFlag=new YellowFlag();
        redFlag=new RedFlag();

        var=0;
    }

    public void update(){
        var=player.getHasCutTheCorner();
        if(var==1) {
            lapInfos.CuttingTheCornerTimePenalty();
        }
    }

    public void render(Graphics g){
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        if(player.getIsOutsideTrackLimits()==1 && player.getPlayerDamage()<100 && player.getPlayerTyresDegradation()<100 && player.getPlayerGearBoxWear()<100 && player.getPlayerEngineWear()<100)
            yellowFlag.render(g);

        if(player.getPlayerDamage()==100 || player.getPlayerTyresDegradation()==100 || player.getPlayerGearBoxWear()==100 || player.getPlayerEngineWear()==100) {
            redFlag.render(g);
        }

        if(var==1){
            g.setColor(Color.red);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));

            g.drawString("-----------------", 330, 80);
            g.drawString("|Cutting The Corner!|", 330,100);
            g.drawString("-----------------", 330, 120);

            var=0;
        }

    }
}
