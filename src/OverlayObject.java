package src;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

/**
 * @author D. Hout
 *
 */

public class OverlayObject extends Actor {
    OverlayObject (String image, int width, int height) {
        setImage("HUD\\" + image + ".png");
        getImage().scale(width, height);
    }

    public OverlayObject (GreenfootImage image) {
        setImage(image);
    }

    void setOverlayObjectImage(String Image) {
        this.setImage("HUD//" + Image + ".png");
    }
}
