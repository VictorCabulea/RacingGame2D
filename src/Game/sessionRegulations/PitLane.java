package Game.sessionRegulations;

import Game.RefLinks;
import Game.entities.creatures.Player;
import Game.parameters.LapInfos;

import java.awt.*;

public class PitLane {

    private RefLinks refLinks;
    private Player player;
    private LapInfos lapInfos;

    private int var1;
    private int var2;

    public PitLane(RefLinks refLinks, Player player, LapInfos lapInfos){
        this.refLinks=refLinks;
        this.player=player;
        this.lapInfos=lapInfos;

        var1=0;
        var2=0;
    }

    public void inThePitLane(){
        var1=player.getIsInsidePitLane();
        // daca var1 are valoarea 1, inseamna ca jucatorul se afla pe linia boxelor

        var2=player.getIsInThePitBox();
        // daca var2 are valoarea 1, inseamna ca jucatorul se afla pe in casuta de pit-stop, iar pit-stopul se va realiza

        if(var1==1) {
            if (refLinks.getKeyManager().PitLaneConstantSpeed == true)// jucatorul este pe linia boxelor si respecta limita de viteza, apasand tasta P
                if (player.getFullSpeedObject().getSpeed() > 6)// Pentru a mentine viteza sub 60 Km/h atunci cand jucatorul va apasa tasta P
                    player.getFullSpeedObject().setSpeed(player.getFullSpeedObject().getSpeed() - 0.8);
            if (refLinks.getKeyManager().PitLaneConstantSpeed == false)// jucatorul este pe linia boxelor si nu apasa tasta P pentru a mentine viteza constanta
                if (player.getFullSpeedObject().getSpeed() > 6) {// nu respecta limita de viteza
                    lapInfos.SpeedingInThePitLaneTimePenalty();
            }
        }

        if(var2==1){
            player.getFullDamageObject().setDamage(0);
            player.getFullEngineWearObject().setEngineWear(0);
            player.getFullTyresDegradationObject().setTyresDegradation(0);
            player.getFullGearBoxObject().setGearBoxWear(0);

            var2=0;
        }
    }

    public void render(Graphics g){
        if(var1==1 && player.getFullSpeedObject().getSpeed()>6)
        {
            g.setColor(Color.red);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));

            g.drawString("---------------------", 280, 80);
            g.drawString("|Speeding in the Pit Lane!|", 280,100);
            g.drawString("---------------------", 280, 120);
        }

        var1=0;
    }
}
