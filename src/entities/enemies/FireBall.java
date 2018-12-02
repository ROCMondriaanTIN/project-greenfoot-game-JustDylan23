package src.entities.enemies;

import src.Hero;
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
    public void act() {
        super.act();
        applyVelocity();
        turn(30);
        if (Main.debug) return;
        if (getObjectsAtOffset(0, 0, Hero.class).size() != 0) {
            Main.worldInstance.hero.isAlive = false;
        }
    }
}
