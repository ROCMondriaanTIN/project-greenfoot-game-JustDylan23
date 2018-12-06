package src.entities.gameplayobjects;

import greenfoot.Greenfoot;
import src.Hero;
import src.Main;

public class MovingPlatform extends GamePlayObject {

    private long time;
    private long starTime;
    private boolean isInteracting;

    public MovingPlatform() {
        setImage("Enemies\\flyingPlatform.png");
    }

    @Override
    public void interact2() {
        Hero hero = Main.cachedWorld.hero;

        int overlapY = (getY() - (hero.getY() + hero.getHeight() / 2 + 10));
        if (overlapY < 0 && overlapY > -15 && !Greenfoot.isKeyDown("s")) {

            long now = System.currentTimeMillis();
            if (!isInteracting) {
                starTime = now;
            }
            time = now;
            isInteracting = true;

            hero.setLocation(hero.getX() + (int) velocityX, hero.getY() + overlapY);
            hero.isOnMovingPlatform = true;
            if (Greenfoot.isKeyDown("space") && now - starTime > 200) {
                hero.velocityY = hero.jumpSpeed;
            } else hero.velocityY = velocityY;
        }
    }

    @Override
    public void act() {
        if (System.currentTimeMillis() - time > 100) isInteracting = false;
        super.act();
        double drag = 0.8;
        velocityX *= (Math.abs(velocityX) > 0.2) ? drag : 0;
        velocityY *= (Math.abs(velocityY) > 0.2) ? drag : 0;
        if (Greenfoot.isKeyDown("UP")) velocityY = -3;
        if (Greenfoot.isKeyDown("DOWN")) velocityY = 3;
        if (Greenfoot.isKeyDown("RIGHT")) velocityX = 3;
        if (Greenfoot.isKeyDown("LEFT")) velocityX = -3;
    }
}
