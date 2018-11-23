package src.entities.collectibles;

import greenfoot.Greenfoot;
import src.Hero;
import src.Main;

public class Coin extends Collectible {
    public Coin() {
        super();
        this.setImage("Items\\coinGold.png");
    }

    @Override
    public void act() {
        super.act();
        if (Main.debug) return;
        if (getObjectsAtOffset(0, 0, Hero.class).size() != 0) {
            Main.addCoin();
            Greenfoot.playSound("coin.wav");
            getWorld().removeObject(this);
        }
    }
}

