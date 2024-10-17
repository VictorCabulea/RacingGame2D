package Game.physics;

import Game.RefLinks;

import java.awt.*;

public class KERS {

    private RefLinks refLinks;
    private final double KERS_QUANTITY=5;
    private double Current_KERS_Level;
    private int n;

    private String str;
    private String repeat;

    public KERS(RefLinks refLinks){
        this.refLinks=refLinks;

        Current_KERS_Level=KERS_QUANTITY;
        n=(int)Current_KERS_Level;

        str="/";
        repeat=str.repeat(n);
    }

    public boolean KERSactivated(){
        return refLinks.getKeyManager().KERS;
    }

    public double KERSConsumption(){
        if(KERSactivated()==true) {
            this.Current_KERS_Level = this.Current_KERS_Level - 0.016;
        }
        n = (int) Current_KERS_Level;
        if (n <= 0)
            repeat = str.repeat(0);
        else
            repeat = str.repeat(n);

        return Current_KERS_Level;
    }

    public void render(Graphics g){
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        if(KERSactivated()==true && Current_KERS_Level>0) {
            g.setColor(Color.red);
            g.drawString("KERS "+ repeat, 700, 50);
        }else if(KERSactivated()==false && Current_KERS_Level>0){
            g.setColor(Color.yellow);
            g.drawString("KERS" + repeat, 700, 50);
        }else {
            g.setColor(Color.black);
            g.drawString("KERS" + repeat, 700, 50);
        }
    }

    public double getCurrent_KERS_Level() {
        return Current_KERS_Level;
    }

    public void setCurrent_KERS_Level(double current_KERS_Level) {
        Current_KERS_Level = current_KERS_Level;
    }
}
