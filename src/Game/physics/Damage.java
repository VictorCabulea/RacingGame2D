package Game.physics;

import java.awt.*;

public class Damage {

    private int damage;

    public Damage(int damage){
        this.damage=damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int increaseDamage(){
        if(this.damage<100)
            this.damage=this.damage+4;
        return this.damage;
    }

    public void render(Graphics g){
        if(damage<100)
            g.drawString("Damage: "+ damage+" %", 1120,700);

        if(damage>=100)
            g.drawString("Damage: 100 %", 1120,700);

    }
}
