package Game.physics;

import java.awt.*;

public class Fuel {

    private double fuelQuantity;
    private int n;
    private String str;
    private String repeat;

    public Fuel(double fuelQuantity){
        this.fuelQuantity=fuelQuantity;
        n=(int)fuelQuantity;
        str="/";
        repeat=str.repeat(n);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double FuelConsumption(){
        this.fuelQuantity=this.fuelQuantity-0.002;
        n=(int)fuelQuantity;
        if(n<=0)
            repeat=str.repeat(0);
        else
            repeat=str.repeat(n);

        return fuelQuantity;
    }

    public void render(Graphics g){
        g.drawString("Fuel: "+ repeat + " Liters: " + (int)fuelQuantity, 30,700);

    }
}
