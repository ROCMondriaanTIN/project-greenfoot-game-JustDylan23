package src;

import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * @author D. Hout
 *
 */

import java.util.ArrayList;

public class PauseScreen extends Actor {

    private long time = System.currentTimeMillis();
    private AbstractWorld abstractWorldInstance;
    public static boolean isActive;
    private ArrayList<ClickableObject> buttons = new ArrayList<>();

    public PauseScreen(AbstractWorld abstractWorldInstance) {
        this.abstractWorldInstance = abstractWorldInstance;
        getImage().clear();
    }

    @Override
    public void act() {
        Long t = System.currentTimeMillis();
        if ((t - time) > 400) {
            if (Greenfoot.isKeyDown("escape")) {
                time = t;
                Greenfoot.playSound("pause.wav");
                if (!isActive) {
                    setImage("pauseScreen.png");
                    addButtons();
                    abstractWorldInstance.setPO(1);
                } else {
                    getImage().clear();
                    removeButtons();
                    abstractWorldInstance.setPO(2);
                }
                isActive = !isActive;
            }
        }
    }

    public void addButtons() {
        ClickableObject continue_ = new ClickableObject("continue.png", this);
        abstractWorldInstance.addObject(continue_, 323 ,228);
        buttons.add(continue_);

        ClickableObject select = new ClickableObject("selectLevel.png", this);
        abstractWorldInstance.addObject(select, 323 ,348);
        buttons.add(select);

        ClickableObject reset = new ClickableObject("reset.png", this);
        abstractWorldInstance.addObject(reset, 323, 468);
        buttons.add(reset);

        ClickableObject exit = new ClickableObject("exitGame.png", this);
        abstractWorldInstance.addObject(exit, 323 ,588);
        buttons.add(exit);
    }

    public void close() {
        getImage().clear();
        removeButtons();
        abstractWorldInstance.setPO(2);
        Greenfoot.playSound("pause.wav");
        isActive = false;
    }

    public void removeButtons() {
        for (ClickableObject button : buttons) {
            abstractWorldInstance.removeObject(button);
        }
    }
}
