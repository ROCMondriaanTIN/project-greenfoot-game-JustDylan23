package src;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;
import src.worlds.LevelSelecting;

/**
 * @author D. Hout
 */

public class ClickableObject extends Actor {

    public String action;
    private PauseScreen pauseScreenInstance;

    private boolean isTriggered;

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
            if (action.contains("level") && !isTriggered) {
                if (Integer.parseInt(action.substring(5)) != 1) {
                    LevelSelecting.getInstance().levelsBought++;
                    LevelSelecting.getInstance().updateStars();
                    Greenfoot.playSound("buy.wav");
                    isTriggered = true;
                    return;
                }
            }
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
                    PauseScreen.isActive = false;
                    Main.worldRegistry.getLevel(0).loadWorld();
                    break;
            }

            if (action.contains("level")) {
                Main.worldRegistry.getLevel(Integer.parseInt(action.substring(5))).loadWorld();
                Greenfoot.playSound("enterLevel.wav");
            }

        }
    }
}
