package Game.physics;

import java.awt.*;

public class Speed {

    private double speed;

    private KERS kers;
    private DRS drs;

    public Speed(double speed,KERS kers,DRS drs){
        this.speed=speed;
        this.kers=kers;
        this.drs=drs;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double CollisionSpeed(){
        this.speed=-5;
        return this.speed;
    }

    public double IncreaseSpeed(){
        if(speed<10) {
            if ((kers.KERSactivated() == false || kers.getCurrent_KERS_Level()<=0) && drs.DRSactivated() == false)
                this.speed = this.speed + 0.05;
            else if ((kers.KERSactivated() == true && kers.getCurrent_KERS_Level()>0 && drs.DRSactivated() == false ) || (kers.KERSactivated() == false || kers.getCurrent_KERS_Level()<=0 && drs.DRSactivated() == true))
                this.speed = this.speed + 0.075;
            else if (kers.KERSactivated() == true && kers.getCurrent_KERS_Level()>0 && drs.DRSactivated() == true)
                this.speed = this.speed + 0.1;
        }
        else if(speed>=10&&speed<20){
            if ((kers.KERSactivated() == false || kers.getCurrent_KERS_Level()<=0) && drs.DRSactivated() == false)
                this.speed = this.speed + 0.04;
            else if ((kers.KERSactivated() == true && kers.getCurrent_KERS_Level()>0 && drs.DRSactivated() == false ) || (kers.KERSactivated() == false || kers.getCurrent_KERS_Level()<=0 && drs.DRSactivated() == true))
                this.speed = this.speed + 0.06;
            else if (kers.KERSactivated() == true && kers.getCurrent_KERS_Level()>0 && drs.DRSactivated() == true)
                this.speed = this.speed + 0.08;
        }
        else if(speed>=20&&speed<29){
            if ((kers.KERSactivated() == false || kers.getCurrent_KERS_Level()<=0) && drs.DRSactivated() == false)
                this.speed = this.speed + 0.03;
            else if ((kers.KERSactivated() == true && kers.getCurrent_KERS_Level()>0 && drs.DRSactivated() == false ) || (kers.KERSactivated() == false || kers.getCurrent_KERS_Level()<=0 && drs.DRSactivated() == true))
                this.speed = this.speed + 0.05;
            else if (kers.KERSactivated() == true && kers.getCurrent_KERS_Level()>0 && drs.DRSactivated() == true)
                this.speed = this.speed + 0.07;
        }
        else if(speed>=29&&speed<32){
            if ((kers.KERSactivated() == false || kers.getCurrent_KERS_Level()<=0) && drs.DRSactivated() == false)
                this.speed = 29;
            else if ((kers.KERSactivated() == true && kers.getCurrent_KERS_Level()>0 && drs.DRSactivated() == false ) || (kers.KERSactivated() == false || kers.getCurrent_KERS_Level()<=0 && drs.DRSactivated() == true))
                this.speed = this.speed + 0.015;
            else if (kers.KERSactivated() == true && kers.getCurrent_KERS_Level()>0 && drs.DRSactivated() == true)
                this.speed = this.speed + 0.03;
        }
        return this.speed;
    }

    public double DecreaseSpeed()  {
        if(this.speed>0)
            this.speed=this.speed-0.35;
        else if(this.speed<0)
            this.speed=this.speed+0.35;
        if(this.speed>0&&this.speed<1)
            this.speed=0;
        return this.speed;
    }

    public void render(Graphics g){

        if(speed>=0)
            g.drawString("Speed: "+ (int)(speed*10)+" Km/h", 30,650);
        else
            g.drawString("Speed: 0 Km/h", 30,650);
    }
}
