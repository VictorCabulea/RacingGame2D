package Game.states;

import Game.RefLinks;
import Game.entities.creatures.Player;
import Game.parameters.LapInfos;
import Game.parameters.Parameters;
import Game.physics.Speed;
import Game.sessionRegulations.PitLane;
import Game.sessionRegulations.Rules;
import Game.utils.UI.UiManager;
import Game.worlds.World;

import java.awt.*;

public class GameState extends State{

    private World world;

    private LapInfos lapInfos;
    private Parameters parameters;
    private Rules rules;
    private Speed speed;
    private PitLane pitLane;

    private double x;
    private double y;

    private int Level;

    public GameState(RefLinks refLinks){
        super(refLinks);
        world=new World(refLinks,"res/worlds/world1.txt");
        refLinks.setWorld(world);

        lapInfos=new LapInfos(refLinks,world.getEntityManager().getPlayer());
        parameters=new Parameters(world.getEntityManager().getPlayer(),lapInfos);
        rules=new Rules(world.getEntityManager().getPlayer(),lapInfos);
        speed=world.getEntityManager().getPlayer().getFullSpeedObject();
        pitLane=new PitLane(refLinks,world.getEntityManager().getPlayer(),lapInfos);

        Level=1;
    }

    @Override
    public void update() {
        world.update();

        parameters.update((int)x,(int)y);
        pitLane.inThePitLane();
        rules.update();

        x=world.getEntityManager().getPlayer().getX();
        y=world.getEntityManager().getPlayer().getY();

        if(lapInfos.Winning()==1 && refLinks.getKeyManager().nextLevel==true){
            Level++;

            if(Level==2)
                world.loadWorld("res/worlds/world2.txt");

            if(Level==3)
                State.setState(refLinks.getGame().winningState);

            lapInfos.AfterWinning();
            world.getEntityManager().getPlayer().AfterWinning();
        }
    }

    @Override
    public void render(Graphics g) {
        world.render(g);

        parameters.render(g);
        pitLane.render(g);
        rules.render(g);
    }
}
