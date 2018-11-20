package src;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import src.worlds.World1;

public class ClickableObject extends Actor {

    private String action;
    private PauseScreen pauseScreenInstance;

    public ClickableObject(String image) {
        action = image.replace(".png", "");
        setImage(image);
        getImage().scale(553, 88);
    }

    public ClickableObject(String image, PauseScreen pauseScreenInstance) {
        action = image.replace(".png", "");
        setImage(image);
        getImage().scale(553, 88);
        this.pauseScreenInstance = pauseScreenInstance;
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            switch (action) {
                case "startGame":
                    Greenfoot.setWorld(new World1());
                    break;
                case "exitGame":
                    System.exit(0);
                    break;
                case "continue":
                    pauseScreenInstance.close();
                    break;
                case "reset":
                    Greenfoot.setWorld(new World1());
            }

        }
    }
}
