package src;

import greenfoot.Actor;

public class Overlay extends Actor {
    private int heroState;
    private Hero heroInstance;
    private AbstractWorld abstractWorldInstance;
    private OverlayObject heroIcon = new OverlayObject("hud_p1", 47, 47);
    private OverlayObject coinCount = new OverlayObject(Main.newTextImage("x" + Main.coinCount, 60));

    public Overlay(Hero heroInstance, AbstractWorld abstractWorldInstance) {
        this.heroInstance = heroInstance;
        this.abstractWorldInstance = abstractWorldInstance;
        setImage("Overlay.png");

        abstractWorldInstance.addObject(heroIcon, 947, 33);
        abstractWorldInstance.addObject(coinCount, 746, 33);
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
