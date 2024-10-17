package Game.physics;

import java.awt.*;

public class EngineWear {

    private double engineWear;

    public EngineWear(double engineWear){
        this.engineWear=engineWear;
    }

    public double getEngineWear() {
        return engineWear;
    }

    public void setEngineWear(double engineWear) {
        this.engineWear = engineWear;
    }

    public double increaseWear(int collision){
        if(collision==1){
            if(this.engineWear<100)
                this.engineWear=this.engineWear+4;
        }else if(collision==0){
            if(this.engineWear<100)
                this.engineWear=this.engineWear+0.004;
        }

        return this.engineWear;
    }

    public void render(Graphics g){
        if(engineWear<100)
            g.drawString("Engine Wear: "+ (int)engineWear+" %", 1120,600);
        if(engineWear>=100)
            g.drawString("Engine Wear: 100 %", 1120,600);
    }
}
