package src.entities.enemies;

import src.Main;
import src.entities.Entity;

/**
 * @author D. Hout
 */

public class FireBall extends Entity {

    public FireBall() {
        System.out.println("new fireball has been created");
        setImage("Items\\fireball.png");
    }

    @Override
    public void interact1() {
        Main.cachedWorld.hero.isAlive = false;
    }

    @Override
    public void act() {
        super.act();
        turn(30);
    }
}
