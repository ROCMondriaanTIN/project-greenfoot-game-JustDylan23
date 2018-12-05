package src.entities.collectibles;

import greenfoot.Greenfoot;
import src.LevelStatistics;

/**
 * @author D. Hout
 */

public class Star extends Collectible {

    private int id;

    public Star() {
        this.setImage("Items\\star.png");
    }

    public Star(int id) {
        this();
        this.id = id;
    }


    @Override
    public void interact1() {
        LevelStatistics.getInstance().addStar();
        getWorld().removeObject(this);
        Greenfoot.playSound("star.wav");

        if (id != 0) {
            LevelStatistics.getInstance().ownedStars.put(id, true);
        }
    }
}
