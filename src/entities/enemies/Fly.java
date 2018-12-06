package src.entities.enemies;

import greenfoot.GreenfootImage;
import src.Main;

/**
 * @author D. Hout
 */

public class Fly extends Enemy {

    private GreenfootImage fly1 = new GreenfootImage("Enemies\\flyFly1.png");
    private GreenfootImage fly2 = new GreenfootImage("Enemies\\flyFly2.png");
    private int imageState = 1;

    public Fly() {
        setImage(fly1);
        velocityX = 2;
        fly1.mirrorHorizontally();
        fly2.mirrorHorizontally();
    }

    @Override
    public void interact1() {
        Main.cachedWorld.hero.isAlive = false;
    }

    @Override
    public void act() {
        super.act();
        imageState++;
        if (imageState == 1) setImage(fly1);
        if (imageState == 4) setImage(fly2);
        if (imageState == 6) imageState = 0;

        if (Math.abs(getX() - spawnX) > 120) {
            velocityX *= -1;
            fly1.mirrorHorizontally();
            fly2.mirrorHorizontally();
        }
    }
}
