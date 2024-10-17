package Game.sessionRegulations.flags;

import java.awt.*;

public class YellowFlag {

    public YellowFlag(){};

    public void render(Graphics g){
        g.setColor(Color.yellow);
        g.drawString("-------------", 400, 30);
        g.drawString("|YELLOW FLAG|", 400, 50);
        g.drawString("-------------", 400, 65);
    }
}
