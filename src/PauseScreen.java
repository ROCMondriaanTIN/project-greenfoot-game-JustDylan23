package src;

import greenfoot.Actor;
import greenfoot.Greenfoot;

import java.util.ArrayList;

public class PauseScreen extends Actor {

    private long time = System.currentTimeMillis();
    private Worlds worldsInstance;
    public static boolean isActive;
    private ArrayList<ClickableObject> buttons = new ArrayList<>();

    public PauseScreen(Worlds worldsInstance) {
        this.worldsInstance = worldsInstance;
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
                    worldsInstance.setPO(1);
                    Hero.song.pause();
                } else {
                    getImage().clear();
                    removeButtons();
                    worldsInstance.setPO(2);
                    Hero.song.play();
                }
                isActive = !isActive;
            }
        }
    }

    public void addButtons() {
        ClickableObject continue_ = new ClickableObject("continue.png", this);
        worldsInstance.addObject(continue_, 323 ,348);
        buttons.add(continue_);

        ClickableObject reset = new ClickableObject("reset.png", this);
        worldsInstance.addObject(reset, 323, 468);
        buttons.add(reset);

        ClickableObject exit = new ClickableObject("exitGame.png", this);
        worldsInstance.addObject(exit, 323 ,588);
        buttons.add(exit);
    }

    public void close() {
        getImage().clear();
        removeButtons();
        worldsInstance.setPO(2);
        Greenfoot.playSound("pause.wav");
        isActive = false;
    }

    public void removeButtons() {
        for (ClickableObject button : buttons) {
            worldsInstance.removeObject(button);
        }
    }
}
