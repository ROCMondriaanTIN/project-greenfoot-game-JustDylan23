package src.entities.gameplayobjects;

import greenfoot.Greenfoot;
import src.Hero;
import src.Main;
import src.PauseScreen;

public class MovingPlatform extends GamePlayObject {

    private int blocksUpwards = 3;
    private long starTime;
    private long time;
    private boolean isInteracting;

    public MovingPlatform() {
        setImage("Enemies\\flyingPlatform.png");
        velocityY = -2;
    }

    public MovingPlatform(int i) {
        this();
        blocksUpwards = Math.abs(i);
        constructorValue = String.valueOf(i);
    }

    public void interact3() {
        Hero hero = Main.cachedWorld.hero;
        if (Greenfoot.isKeyDown("s") || (hero.velocityY < -1 && !isInteracting)) {
            hero.isOnMovingPlatform = false;
            return;
        }
        long now = System.currentTimeMillis();
        if (!isInteracting) {
            starTime = now;
        }
        isInteracting = true;
        time = now;
        int overlapY = (getY() - (hero.getY() + hero.getImage().getHeight() / 2) - getImage().getHeight() / 2);
        if (overlapY < -2) {
            hero.setLocation(hero.getX(), hero.getY() + overlapY);
            if (Greenfoot.isKeyDown("space") && now - starTime > 200) {
                hero.velocityY = hero.jumpSpeed;
            }
            hero.velocityY = velocityY;
        }
    }

    @Override
    public void act() {
        if (PauseScreen.isActive) return;
        super.act();
        if (System.currentTimeMillis() - time > 100) isInteracting = false;
        if (getY() - spawnY < 60 * blocksUpwards * -1 - 30) {
            velocityY *= -1;
        } else if (getY() - spawnY >= -10) {
            velocityY *= -1;
            setLocation(getX(), getY() - 2);
        }
    }
}
