package Game.states;

import Game.RefLinks;
import Game.graphics.Assets;
import Game.utils.UI.ClickListener;
import Game.utils.UI.UiImageButton;
import Game.utils.UI.UiManager;

import java.awt.*;

public class HelpState extends State{

    public HelpState(RefLinks refLinks) {
        super(refLinks);

    }

    @Override
    public void update() {
        if(refLinks.getKeyManager().nextLevel==true)
            State.setState(refLinks.getGame().menuState);
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0,0,1536,768);

        g.setColor(Color.orange);

        g.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        g.drawString("INSTRUCTIUNI",450,200);

        g.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        g.drawString("Pentru a ajunge in Formula 1, Helio trebuie sa treaca 2 teste. Ambele teste constau in acoperirea a 5 tururi, pe 2 circuite distincte.",100,300);
        g.drawString("Pentru a reusi sa castige locul in Formula 1, Helio trebuie sa bata timpii limita, 75 de secunde, respectiv 90 de secunde.",100,340);
        g.drawString("In cazul in care greseste si loveste masina sau are defectiuni la monopost, Helio poate intra pe linia boxelor, unde ii va fi reparata masina.",100,380);
        g.drawString("El trebuie sa fie atent sa nu depaseasca limita de viteza, iar acest lucru il va putea face apasand limitatorul de viteza, (tasta P).",100,420);
        g.drawString("In cazul in care depaseste limita de viteza pe linia boxelor, Helio va fi penalizat.",100,460);
        g.drawString("Pentru a-si spori viteza, Helio poate utiliza KERS-ul si DRS-ul",100,500);
        g.drawString("KERS-ul este o baterie reincarcabila cu energie (tasta K), iar DRS-ul este un sistem al aripii din spate a masinii (tasta L).",100,540);
        g.drawString("Helio trebuie sa fie atent si la limitele circuitului, depasirea acestora aducandu-i o penalizare, care va fi adaugata la timpul final obtiut.",100,580);
        g.drawString("In cazul in care Helio paraseste limitele circuitului, vor fi afisate steagurile galbene, iar in cazul in care masina este distrusa, vor fi afisate steagurile rosii.",100,620);
        g.drawString("In cazul in care Helio bate timpul limita, el poate trece la urmatorul nivel (tasta N).",100,660);

        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        g.drawString("Pentru a reveni la meniul principal, apasati tasta N.",100,730);

        g.drawImage(Assets.player,100,0,null);
    }
}
