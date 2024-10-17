package Game.sessionRegulations.flags;

import java.awt.*;

public class RedFlag {

    public RedFlag(){};

    public void render(Graphics g){
        g.setColor(Color.red);
        g.drawString("---------", 400, 30);
        g.drawString("|RED FLAG|", 400, 50);
        g.drawString("---------", 400, 65);
    }
}