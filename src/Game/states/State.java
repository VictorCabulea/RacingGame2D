package Game.states;

import Game.RefLinks;
import Game.utils.UI.UiManager;

import java.awt.*;

public abstract class State {


    /////STATE MANAGER CLASS
    private static State CurrentState=null;

    public static void setState(State state){
        CurrentState=state;
    }

    public static State getCurrentState() {
        return CurrentState;
    }

    //class

    protected RefLinks refLinks;

    public State(RefLinks refLinks){
        this.refLinks = refLinks;
    }

    public abstract void update();

    public abstract void render(Graphics g);

}
