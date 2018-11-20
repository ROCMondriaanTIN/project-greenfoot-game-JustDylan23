package src;

import greenfoot.Actor;

public class Overlay extends Actor {
    private int heroState;
    private Hero heroInstance;
    private Worlds worldInstance;
    private OverlayObject heroIcon = new OverlayObject("hud_p1", 47, 47);

    private boolean pauseMenuIsOpen;

    public Overlay(Hero heroInstance, Worlds worldInstance) {
        this.heroInstance = heroInstance;
        this.worldInstance = worldInstance;
        setImage("Overlay.png");
    }

    public void updateHeroState(int heroState) {
        this.heroState = heroState;
    }

    @Override
    public void act() {

    }
}
