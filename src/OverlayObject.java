package src;

import greenfoot.Actor;

public class OverlayObject extends Actor {
    public OverlayObject (String image, int width, int height) {
        setImage("HUD\\" + image + ".png");
        getImage().scale(width, height);
    }
}
