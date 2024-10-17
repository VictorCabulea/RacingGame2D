package Game.physics;

import java.awt.*;

public class GearBox {

    private int gear;
    private double gearBoxWear;

    public GearBox(int gear, double gearBoxWear){
        this.gear=gear;
        this.gearBoxWear=gearBoxWear;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear, double gearBoxWear) {
        this.gear = gear;
        this.gearBoxWear=gearBoxWear;
    }

    public void setPlayerGear(double speed) {
        if(speed<=0)
            this.gear=0;
        if(speed>0 && speed<2)
            this.gear=1;
        if(speed>2 && speed<5)
            this.gear=2;
        if(speed>5 && speed<8)
            this.gear=3;
        if(speed>8 && speed<12)
            this.gear=4;
        if(speed>12 && speed<16)
            this.gear=5;
        if(speed>16 && speed<21)
            this.gear=6;
        if(speed>21 && speed<26)
            this.gear=7;
        if(speed>26 && speed<=32)
            this.gear=8;
    }

    public double getGearBoxWear() {
        return gearBoxWear;
    }

    public void setGearBoxWear(double gearBoxWear) {
        this.gearBoxWear = gearBoxWear;
    }

    public double increaseWear(int collision){
        if (collision == 1) {
            if (this.gearBoxWear < 100)
                this.gearBoxWear = this.gearBoxWear + 4;
        }else if(collision==0){
            if (this.gearBoxWear < 100)
                this.gearBoxWear = this.gearBoxWear + 0.006;
        }
        return this.gearBoxWear;
    }

    public void render(Graphics g){
        g.drawString("Gear: "+ gear, 30,600);
        g.drawString("Gearbox Wear: "+ (int)gearBoxWear+" %", 1120,550);
    }
}
