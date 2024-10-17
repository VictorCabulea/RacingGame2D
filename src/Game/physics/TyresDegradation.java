package Game.physics;

import java.awt.*;

public class TyresDegradation {

    private double tyresDegradation;

    public TyresDegradation(double tyresDegradation){
        this.tyresDegradation=tyresDegradation;
    }

    public double getTyresDegradation() {
        return tyresDegradation;
    }

    public void setTyresDegradation(double tyresDegradation) {
        this.tyresDegradation = tyresDegradation;
    }

    public double increaseWear(int collision){
        if(collision==1) {
            if (this.tyresDegradation < 100)
                this.tyresDegradation = this.tyresDegradation + 3;
        }else if(collision==0){
            if (this.tyresDegradation < 100)
                this.tyresDegradation = this.tyresDegradation + 0.015;
        }
        return this.tyresDegradation;
    }

    public void render(Graphics g){
        if(tyresDegradation<100)
            g.drawString("Tyres Degradation: "+ (int)tyresDegradation+" %", 1120,650);
        if(tyresDegradation>=100)
            g.drawString("Tyres Degradation: %", 1120,650);
    }
}
