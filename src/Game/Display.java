package Game;

import javax.swing.*;
import java.awt.*;

public class Display {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width;
    private int height;

    public Display(String title,int width,int height){
        this.title=title;
        this.width=width;
        this.height=height;

        createDisplay();
    }

    public void createDisplay(){
        frame=new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Pentru inchiderea corecta a jocului
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);// Pentru a pune fereastra pe mijlocul ecranului la deschidere
        frame.setVisible(true);

        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();// Pentru a se vedea intreg canvas-ul

    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }
}
