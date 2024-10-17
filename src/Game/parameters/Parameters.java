package Game.parameters;

import Game.RefLinks;
import Game.entities.creatures.Player;
import Game.physics.*;
import Game.sessionRegulations.Rules;

import java.awt.*;

public class Parameters {

    private RefLinks refLinks;
    private Player player;
    private LapInfos lapInfos;
    private Damage damage;
    private Speed speed;
    private GearBox gearBox;
    private TyresDegradation tyresDegradation;
    private EngineWear engineWear;
    private Fuel fuel;

    private DRS drs;
    private KERS kers;

    public Parameters(Player player,LapInfos lapInfos){
        this.player=player;
        this.lapInfos=lapInfos;
        this.damage=player.getFullDamageObject();
        this.speed=player.getFullSpeedObject();
        this.gearBox=player.getFullGearBoxObject();
        this.tyresDegradation= player.getFullTyresDegradationObject();
        this.engineWear= player.getFullEngineWearObject();
        this.fuel=player.getFullFuelObject();

        this.drs=player.getFullDRSObject();
        this.kers=player.getFullKERSObject();
    }

    public void update(int x,int y){
        lapInfos.update(x,y);
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 28));

        lapInfos.render(g);
        damage.render(g);
        speed.render(g);
        gearBox.render(g);
        tyresDegradation.render(g);
        engineWear.render(g);
        fuel.render(g);

        drs.render(g);
        kers.render(g);

        if(this.damage.getDamage()==100||this.tyresDegradation.getTyresDegradation()==100||this.gearBox.getGearBoxWear()==100||this.engineWear.getEngineWear()==100){
            g.setColor(Color.white);
            g.drawString("TERMINAL DAMAGE!", 100, 550);
        }

    }
}
