package src.entities.collectibles;

import src.entities.Entity;

/**
 * @author D. Hout
 */

public class Collectible extends Entity {
    Collectible() {
        super();
    }

    @Override
    public void act() {
        super.act();
        applyVelocity();
    }
}
