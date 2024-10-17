package Game.states;

import Game.RefLinks;
import Game.graphics.Assets;
import Game.utils.UI.ClickListener;
import Game.utils.UI.UiImageButton;
import Game.utils.UI.UiManager;

import java.awt.*;

public class WinningState extends State{

    public WinningState(RefLinks refLinks){
        super(refLinks);
    }

    @Override
    public void update() {
        if(refLinks.getMouseInput().isLeftPressed()==true)
            System.exit(0);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(180,50,255));
        g.fillRect(0,0,1536,768);

        g.setColor(Color.black);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));

        g.drawString("CONGRATULATION!",100,100);
        g.drawString("You are now eligible to drive in Formula 1!",100,150);

        g.drawImage(Assets.PirelliTyres[0], 130,480,null);
        g.drawImage(Assets.PirelliTyres[1], 480,480,null);

        g.drawImage(Assets.PirelliTyres[2], 830,480,null);
        g.drawImage(Assets.PirelliTyres[3], 1180,480,null);

        g.drawImage(Assets.F1logo,800,-20,null);
        g.drawImage(Assets.player,350,150,null);
        g.drawImage(Assets.trophy,700, 200,null);
    }
}
