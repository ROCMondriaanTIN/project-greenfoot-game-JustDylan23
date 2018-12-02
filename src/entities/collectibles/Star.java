package src.entities.collectibles;

import greenfoot.Greenfoot;
import src.LevelStatistics;

/**
 * @author D. Hout
 */

public class Star extends Collectible {
    public Star() {
        this.setImage("Items\\star.png");
    }


    @Override
    public void interact1() {
        LevelStatistics.getInstance().addStar();
        getWorld().removeObject(this);
        Greenfoot.playSound("star.wav");
    }
}
