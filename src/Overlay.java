package src;

import greenfoot.Actor;

/**
 * @author D. Hout
 */

public class Overlay extends Actor {
    private OverlayObject heroIcon = new OverlayObject("hud_p1", 47, 47);
    private OverlayObject coinCount = new OverlayObject(Main.newTextImage("x" + Main.coinCount, 60));

    OverlayObject keyBlue = new OverlayObject("hud_keyBlue", 60, 60);
    OverlayObject keyGreen = new OverlayObject("hud_keyGreen", 60, 60);
    OverlayObject keyRed = new OverlayObject("hud_keyRed", 60, 60);
    OverlayObject keyYellow = new OverlayObject("hud_keyYellow", 60, 60);

    public Overlay() {
        setImage("Overlay.png");
    }

    public void addButtons() {
        getWorld().addObject(heroIcon, 947, 33);
        getWorld().addObject(coinCount, 746, 33);
    }

    public void addKey(String color) {
        switch (color) {
            case "Blue":
                this.getWorld().addObject(keyBlue, 30, 28);
                break;
            case "Green":
                this.getWorld().addObject(keyGreen, 90, 28);
                break;
            case "Red":
                this.getWorld().addObject(keyRed, 150, 28);
                break;
            case "Yellow":
                this.getWorld().addObject(keyYellow, 210, 28);
        }
    }

    public void updateHeroState(int heroState) {
        heroIcon.setOverlayObjectImage("hud_p" + heroState);
    }

    public void updateCoinCount() {
        coinCount.setImage(Main.newTextImage("x" + Main.coinCount, 60));
    }
}
