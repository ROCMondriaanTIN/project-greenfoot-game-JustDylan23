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
    }

    public void interact3() {
        long now = System.currentTimeMillis();
        if (!isInteracting) {
            starTime = now;
        }
        isInteracting = true;
        time = now;

        Hero hero = Main.cachedWorld.hero;
        int overlapY = (getY() - (hero.getY() + hero.getImage().getHeight() / 2) - getImage().getHeight() / 2);
        if (overlapY < -2 && !Greenfoot.isKeyDown("s") && hero.velocityY >= 0) {
            hero.setLocation(hero.getX(), hero.getY() + overlapY);
            if (Greenfoot.isKeyDown("space") && now - starTime > 200) {
                hero.velocityY = hero.jumpSpeed;
            } else hero.velocityY = velocityY;
        }
    }

    @Override
    public void act() {
        super.act();
        if (PauseScreen.isActive) return;
        if (System.currentTimeMillis() - time > 100) isInteracting = false;
        if (getY() - spawnY < 60 * blocksUpwards * -1 - 30) {
            velocityY *= -1;
        } else if (getY() - spawnY >= -10) {
            velocityY *= -1;
            setLocation(getX(), getY() - 2);
        }
    }
}
