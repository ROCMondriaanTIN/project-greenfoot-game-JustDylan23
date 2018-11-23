package src;

import greenfoot.Actor;

/**
 * @author D. Hout
 *
 */

public class Overlay extends Actor {
    private OverlayObject heroIcon = new OverlayObject("hud_p1", 47, 47);
    private OverlayObject coinCount = new OverlayObject(Main.newTextImage("x" + Main.coinCount, 60));

    public Overlay() {
        setImage("Overlay.png");
    }

    public void addButtons() {
        getWorld().addObject(heroIcon, 947, 33);
        getWorld().addObject(coinCount, 746, 33);
    }

    public void updateHeroState(int heroState) {
        heroIcon.setOverlayObjectImage("hud_p" + heroState);
    }

    public void updateCoinCount() {
        coinCount.setImage(Main.newTextImage("x" + Main.coinCount, 60));
    }
}
