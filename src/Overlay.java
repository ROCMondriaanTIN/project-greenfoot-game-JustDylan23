package src;

import greenfoot.Actor;

/**
 * @author D. Hout
 */

public class Overlay extends Actor {
    private OverlayObject heroIcon = new OverlayObject("hud_p1", 47, 47);
    private OverlayObject coinCount = new OverlayObject(Main.newTextImage("x" + LevelStatistics.getInstance().coins, 60));
    private int starCount;

    private OverlayObject keyBlue = new OverlayObject("hud_keyBlue", 60, 60);
    private OverlayObject keyGreen = new OverlayObject("hud_keyGreen", 60, 60);
    private OverlayObject keyRed = new OverlayObject("hud_keyRed", 60, 60);
    private OverlayObject keyYellow = new OverlayObject("hud_keyYellow", 60, 60);

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
                getWorld().addObject(keyBlue, 30, 772);
                break;
            case "Green":
                getWorld().addObject(keyGreen, 90, 772);
                break;
            case "Red":
                getWorld().addObject(keyRed, 150, 772);
                break;
            case "Yellow":
                getWorld().addObject(keyYellow, 210, 772);
        }
    }

    public void addStar() {
        starCount++;
        getWorld().addObject(new OverlayObject("star", 100, 100), 400 + 50 * starCount, 30);
    }

    public void updateHeroState(int heroState) {
        heroIcon.setOverlayObjectImage("hud_p" + heroState);
    }

    public void updateCoinCount() {
        coinCount.setImage(Main.newTextImage("x" + LevelStatistics.getInstance().coins, 60));
    }
}
