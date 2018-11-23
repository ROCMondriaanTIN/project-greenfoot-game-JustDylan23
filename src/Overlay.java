package src;

import greenfoot.Actor;

/**
 * @author D. Hout
 *
 */

public class Overlay extends Actor {

    private final static Overlay instance = new Overlay();

    private int heroState;
    private OverlayObject heroIcon = new OverlayObject("hud_p1", 47, 47);
    private OverlayObject coinCount = new OverlayObject(Main.newTextImage("x" + Main.coinCount, 60));

    private Overlay() {
        setImage("Overlay.png");

        getWorld().addObject(heroIcon, 947, 33);
        getWorld().addObject(coinCount, 746, 33);
    }

    public static Overlay getInstance() {
        return instance;
    }

    public static void loadOverlay() {
        System.out.println("1");
        //getWorld().addObject(this, 500, 400);
    }
    public void updateHeroState(int heroState) {
        this.heroState = heroState;
        heroIcon.setOverlayObjectImage("hud_p" + heroState);
    }

    public void updateCoinCount() {
        Main.coinCount++;
        coinCount.setImage(Main.newTextImage("x" + Main.coinCount, 60));
    }
}
