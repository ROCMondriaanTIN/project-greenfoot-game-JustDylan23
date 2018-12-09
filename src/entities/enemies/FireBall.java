package src.entities.enemies;

import src.Main;
import src.PauseScreen;
import src.entities.Entity;

/**
 * @author D. Hout
 */

public class FireBall extends Entity {

    public FireBall() {
        setImage("Items\\fireball.png");
    }

    @Override
    public void interact1() {
        Main.cachedWorld.hero.isAlive = false;
    }

    @Override
    public void act() {
        super.act();
        if (PauseScreen.isActive) return;
        turn(10);
    }
}
