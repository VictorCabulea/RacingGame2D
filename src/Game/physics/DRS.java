package Game.physics;

import Game.RefLinks;

import java.awt.*;

public class DRS {

    private RefLinks refLinks;

    public DRS(RefLinks refLinks){
        this.refLinks=refLinks;
    }

    public boolean DRSactivated(){
        return refLinks.getKeyManager().DRS;
    }

    public void render(Graphics g){
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        if(refLinks.getKeyManager().DRS==true) {
            g.setColor(Color.green);
            g.drawString("DRS", 900, 50);
        }else{
            g.setColor(Color.yellow);
            g.drawString("DRS", 900, 50);
        }
    }
}
