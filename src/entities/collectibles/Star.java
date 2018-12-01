package src.entities.collectibles;

import greenfoot.Greenfoot;
import src.Hero;
import src.LevelStatistics;
import src.Main;

public class Star extends Collectible {
    public Star() {
        this.setImage("Items\\star.png");
    }

    public void act() {
        super.act();
        if (Main.debug) return;
        if (getObjectsAtOffset(0, 0, Hero.class).size() != 0) {
            LevelStatistics.getInstance().addStar();
            getWorld().removeObject(this);
            Greenfoot.playSound("star.wav");
        }
    }
}
