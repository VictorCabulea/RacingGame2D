package Game.utils.UI;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UiImageButton extends UiObject{

    private BufferedImage[] images;
    private ClickListener click;

    public UiImageButton(double x, double y, int width, int height, BufferedImage[] images, ClickListener click) {
        super(x, y, width, height);
        this.images=images;
        this.click=click;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        if(hovering==true)
            g.drawImage(images[1],(int)x,(int)y,width,height,null);
        else
            g.drawImage(images[0],(int)x,(int)y,width,height,null);
    }

    @Override
    public void onClick() {
        click.onClick();
    }
}
