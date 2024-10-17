package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean up,down,left,right,DRS,KERS,PitLaneConstantSpeed,nextLevel;

    public KeyManager(){
        keys=new boolean[256];
    }

    public void update(){
        up=keys[KeyEvent.VK_W];
        down=keys[KeyEvent.VK_S];
        left=keys[KeyEvent.VK_A];
        right=keys[KeyEvent.VK_D];

        DRS=keys[KeyEvent.VK_L];// La apasarea tastei L, viteza va creste, datorita deschiderii DRS-ului, flapsul mobil de pe aripa din spate a masinii
        KERS=keys[KeyEvent.VK_K];// La apasarea tastei K, viteza va creste ca urmare a utilizarii energiei din bateria KERS a masinii
        PitLaneConstantSpeed=keys[KeyEvent.VK_P];// La apasarea tastei P, viteza va fi mentinuta la maxim 80 km/h, pentru a respecta limita de viteza impusa pe linia boxelor
        // Tastele vor trebui apasate pe toata durata in care se doreste utilizarea DRS-ului, KERS-ului, respectiv a limitatorului de viteza pe linia boxelor

        nextLevel=keys[KeyEvent.VK_N];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;

    }
}
