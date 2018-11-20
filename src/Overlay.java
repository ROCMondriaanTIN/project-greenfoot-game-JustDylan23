package src;

import greenfoot.Actor;

public class Overlay extends Actor {
    private int heroState;
    private Hero heroInstance;
    private Worlds worldsInstance;
    private OverlayObject heroIcon = new OverlayObject("hud_p1", 47, 47);
    private OverlayObject coinCount = new OverlayObject(Main.newTextImage("x" + Main.coinCount, 60));

    public Overlay(Hero heroInstance, Worlds worldsInstance) {
        this.heroInstance = heroInstance;
        this.worldsInstance = worldsInstance;
        setImage("Overlay.png");

        worldsInstance.addObject(heroIcon, 947, 33);
        worldsInstance.addObject(coinCount, 746, 33);
    }

    public void updateHeroState(int heroState) {
        this.heroState = heroState;
        heroIcon.setOverlayObjectImage("hud_p" + heroState);
    }

    public void addCoin() {
        Main.coinCount++;
        coinCount.setImage(Main.newTextImage("x" + Main.coinCount, 60));
    }

    public void addCoin(int amount) {
        Main.coinCount += amount - 1;
        addCoin();
    }
}
