package src.entities.collectibles;

import greenfoot.Greenfoot;
import src.LevelStatistics;

/**
 * @author D. Hout
 */

public class Star extends Collectible {

    private int id;
    private boolean removeOnLoad;

    public Star() {
        this.setImage("Items\\star.png");
    }

    public Star(int id) {
        this();
        this.id = id;
        constructorValue = String.valueOf(id);
        LevelStatistics.getInstance().ownedStars.putIfAbsent(id, false);
        if (LevelStatistics.getInstance().ownedStars.get(id)) {
            removeOnLoad = true;
        }
    }

    @Override
    public void act() {
        super.act();
        if (removeOnLoad) {
            getWorld().removeObject(this);
        }
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
