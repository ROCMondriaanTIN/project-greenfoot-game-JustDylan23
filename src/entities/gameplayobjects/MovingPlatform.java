package src.entities.gameplayobjects;

import greenfoot.Greenfoot;
import src.Hero;
import src.Main;
import src.PauseScreen;

public class MovingPlatform extends GamePlayObject {

    private long time;
    private long starTime;
    private boolean isInteracting;
    private int blocksUpwards = 3;

    public MovingPlatform() {
        setImage("Enemies\\flyingPlatform.png");
        velocityY = -2;
    }

    public MovingPlatform(int i) {
        this();
        blocksUpwards = Math.abs(i);
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
            } hero.velocityY = velocityY;
            hero.applyVelocity();
        }
    }

    @Override
    public void act() {
        if (PauseScreen.isActive) return;
        if (System.currentTimeMillis() - time > 100) isInteracting = false;
        super.act();
        if (getY() - spawnY < 60 * blocksUpwards * -1 - 30) {
            velocityY *= -1;
        } else if (getY() - spawnY >= -10) {
            velocityY *= -1;
            setLocation(getX(), getY() - 2);
        }
    }
}
