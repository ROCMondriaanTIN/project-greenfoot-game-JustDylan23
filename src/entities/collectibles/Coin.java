package src.entities.collectibles;

import greenfoot.Greenfoot;
import src.Hero;
import src.Main;
import src.Overlay;

public class Coin extends Collectible {
    public Coin() {
        super();
        this.setImage("Items\\coinGold.png");
    }

    @Override
    public void act() {
        super.act();
        if (getObjectsAtOffset(0, 0, Hero.class).size() != 0) {
            Main.addCoin(1);
            Greenfoot.playSound("coin.wav");
            getWorld().removeObject(this);
        }
    }
}

