package src;

import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * @author D. Hout
 */

public class ClickableObject extends Actor {

    public String action;
    private PauseScreen pauseScreenInstance;
    private AbstractWorld abstractWorld;

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

    public ClickableObject(String image, AbstractWorld abstractWorld) {
        action = image.replace(".png", "");
        setImage(image);
        getImage().scale(553, 88);
        this.abstractWorld = abstractWorld;
    }

    @Override
    public void act() {
        //if (Greenfoot.mouseDragged(this)) {
        //    MouseInfo mouse = Greenfoot.getMouseInfo();
        //    setLocation(mouse.getX(), mouse.getY());
        //}

        if (Greenfoot.mouseClicked(this)) {
            switch (action) {
                case "startGame":
                    Main.worldRegistry.getLevel(0).loadWorld();
                    break;
                case "exitGame":
                    System.exit(0);
                    break;
                case "continue":
                    pauseScreenInstance.close();
                    break;
                case "reset":
                    pauseScreenInstance.close();
                    Main.worldRegistry.getLevel(Main.LEVEL).reset();
                    break;
                case "selectLevel":
                    getImage().clear();
                    pauseScreenInstance.removeButtons();
                    pauseScreenInstance.getImage().clear();
                    pauseScreenInstance.isActive = false;
                    Main.worldRegistry.getLevel(0).loadWorld();
                    break;
            }

            if (action.contains("level")) {
                Main.worldRegistry.getLevel(Integer.parseInt(action.substring(5))).loadWorld();
                Main.LEVEL = Integer.parseInt(action.substring(5));
            }

        }
    }
}
