package Game;

import Game.graphics.Assets;
import Game.graphics.GameCamera;
import Game.states.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    private Display display;

    private int width;
    private int height;
    private String title;

    private boolean running = false;

    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //States
    public State gameState;
    public State menuState;
    public State helpState;
    public State winningState;

    //Input
    private KeyManager keyManager;
    private MouseInput mouseInput;

    // Camera
    private GameCamera gameCamera;

    // RefLinks
    private RefLinks refLinks;

    public Game(String title, int width,int height){
        this.width=width;
        this.height=height;
        this.title=title;

        keyManager=new KeyManager();
        mouseInput=new MouseInput();
    }

    private void init(){
        display=new Display(title,width,height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseInput);
        display.getFrame().addMouseMotionListener(mouseInput);
        display.getCanvas().addMouseListener(mouseInput);
        display.getCanvas().addMouseMotionListener(mouseInput);

        Assets.init();

        refLinks =new RefLinks(this);
        gameCamera=new GameCamera(refLinks,0,0);
        // pozitia 0,0 pentru a avea totul la pozita normala, fara vreun deplasament

        gameState=new GameState(refLinks);
        menuState=new MenuState(refLinks);
        helpState=new HelpState(refLinks);
        winningState=new WinningState(refLinks);

        State.setState(menuState);
    }

    private void update(){
        keyManager.update();
        if(State.getCurrentState()!= null){
            State.getCurrentState().update();
        }
    }

    private void render(){
        bs=display.getCanvas().getBufferStrategy();//BufferStrategy arata calculatorului cum trebuie sa desenze pe ecran

        if(bs==null){
            //creaza un BufferStrategy
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g=bs.getDrawGraphics();// Pentru a putea desena pe canvas
        g.clearRect(0,0,width,height);// Curata ecranul

        if(State.getCurrentState()!= null){
            State.getCurrentState().render(g);
        }

        bs.show();
        g.dispose();
    }

    @Override
    public void run() {

        init();

        int fps=60;// 60 frames per second / 60 FPS
        double timePerTick=1000000000/fps;//intervalul de timp la cere se va apela din nou metoda,in nanosecunde
        // astfel se va realiza update-ul obiectelor in asa fel incat sa se obtina 60 de FPS
        double delta=0;

        long now; // timpul curent, al executiei
        long lastTime=System.nanoTime();// timpul ultimei executii
        long timer=0;

        int ticks=0;

        while (running==true){
            now=System.nanoTime(); // valoarea in nanosecunde a momentului la care s-a executat metoda
            delta=delta+(now-lastTime)/timePerTick;
            timer=timer+(now-lastTime);
            // pregatire lastTime pentru urmatoarea executie
            // lastTime va lua valoarea lui now din actuala executie, pentru a avea valoarea in nanosecunde a ultimei executii, atunci cand metoda se va executa din nou
            lastTime=now;

            if(delta>=1) {
                // se actualizeaza pozitiile elementelor si se deseneaza acestea pe ecran
                update();
                render();
                // incrementare ticks
                ticks=ticks+1;
                // resetare delta
                delta=0;
            }

            if(timer>=1000000000){
                // A trecut o secunda
                // Se reseteaza parametrii
                ticks=0;
                timer=0;
            }
        }

        stop();

    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public MouseInput getMouseInput() {
        return mouseInput;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public synchronized void start(){
        //synchronized este folosit pentru a porni sau a opri un thread in mod direct

        if(running==true)
            return;
        running=true;
        thread=new Thread(this);
        thread.start();
    }

    public synchronized void  stop(){
        if(running==false)
            return;
        running=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
