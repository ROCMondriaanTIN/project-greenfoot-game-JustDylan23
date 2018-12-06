package src.entities.gameplayobjects;

import greenfoot.Greenfoot;
import src.Hero;
import src.Main;

public class MovingPlatform extends GamePlayObject {


    public MovingPlatform() {
        setImage("Enemies\\flyingPlatform.png");
    }

    @Override
    public void interact2() {
        Hero hero = Main.cachedWorld.hero;
        int overlapY = (getY() - (hero.getY() + hero.getHeight() / 2 + 10));
        if (overlapY < 0) {
            hero.setLocation(hero.getX(), hero.getY() + overlapY);
            hero.isOnMovingPlatform = true;
            if (Greenfoot.isKeyDown("space")) hero.velocityY = hero.jumpSpeed;
            else hero.velocityY = velocityY;
        }

    }
}
