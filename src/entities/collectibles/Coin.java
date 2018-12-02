package src.entities.collectibles;

import greenfoot.Greenfoot;
import src.LevelStatistics;

/**
 * @author D. Hout
 */

public class Coin extends Collectible {
    public Coin() {
        super();
        this.setImage("Items\\coinGold.png");
    }

    @Override
    public void interact1() {
        LevelStatistics.getInstance().addCoin();
        Greenfoot.playSound("coin.wav");
        getWorld().removeObject(this);
    }
}

