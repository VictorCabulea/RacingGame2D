package Game.states;

import Game.RefLinks;
import Game.graphics.Assets;
import Game.utils.UI.ClickListener;
import Game.utils.UI.UiImageButton;
import Game.utils.UI.UiManager;

import java.awt.*;

public class MenuState extends State {

    private UiManager uiManager;

    private long timeInit;
    private long now;
    private long time_delta;
    private int var;

    public MenuState(RefLinks refLinks){
        super(refLinks);
        uiManager=new UiManager(refLinks);
        refLinks.getMouseInput().setUiManager(uiManager);

        timeInit=System.currentTimeMillis();
        now=0;
        time_delta=0;
        var=0;

        uiManager.addObject(new UiImageButton(650, -10, 256, 128, Assets.StartButton, new ClickListener() {
            @Override
            public void onClick() {
                refLinks.getMouseInput().setUiManager(null);
                // pentru a opri aisarea butoanelor atunci cand se trece la gameState
                State.setState(refLinks.getGame().gameState);
            }
        }));

        uiManager.addObject(new UiImageButton(1250, 410, 256, 128, Assets.TemperateClimateButton, new ClickListener() {
            @Override
            public void onClick() {
                Assets.ClimateSelection=1;
                Assets.update();
            }
        }));

        uiManager.addObject(new UiImageButton(1250, 530, 256, 128, Assets.DesertClimateButton, new ClickListener() {
            @Override
            public void onClick() {
                Assets.ClimateSelection=2;
                Assets.update();
            }
        }));

        uiManager.addObject(new UiImageButton(900, 410, 256, 128, Assets.car1Button, new ClickListener() {
            @Override
            public void onClick() {
                Assets.CarSelection=1;
                Assets.update();
            }
        }));

        uiManager.addObject(new UiImageButton(900, 530, 256, 128, Assets.car2Button, new ClickListener() {
            @Override
            public void onClick() {
                Assets.CarSelection=2;
                Assets.update();
            }
        }));

        uiManager.addObject(new UiImageButton(900, 650, 256, 128, Assets.car3Button, new ClickListener() {
            @Override
            public void onClick() {
                Assets.CarSelection=3;
                Assets.update();
            }
        }));

        uiManager.addObject(new UiImageButton(950, -10, 256, 128, Assets.GuideButton, new ClickListener() {
            @Override
            public void onClick() {
                State.setState(refLinks.getGame().helpState);
            }
        }));

        uiManager.addObject(new UiImageButton(1250, -10, 256, 128, Assets.ExitButton, new ClickListener() {
            @Override
            public void onClick() {
                refLinks.getMouseInput().setUiManager(null);
                // pentru a opri aisarea butoanelor atunci cand se trece la gameState
                System.exit(0);
            }
        }));
    }

    @Override
    public void update() {
        uiManager.update();

        now=System.currentTimeMillis();
        time_delta=now-timeInit;
        if(time_delta>10000 && var<3){
            var++;
            timeInit=System.currentTimeMillis();
            time_delta=0;
        }
        if(var==3)
            var=0;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,1536,768);

        g.setColor(Color.orange);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        g.drawString("HELIO, THE FUTURE CHAMPION",30,230);

        g.drawImage(Assets.PirelliTyres[0], 900,120,null);
        g.drawImage(Assets.PirelliTyres[1], 820,170,null);

        g.drawImage(Assets.PirelliTyres[2], 1280,120,null);
        g.drawImage(Assets.PirelliTyres[3], 1200,170,null);

        g.drawImage(Assets.BackgroundImage[var], 0,0,null);
        g.drawImage(Assets.F1logo,100,-50,null);

        uiManager.render(g);

    }
}
