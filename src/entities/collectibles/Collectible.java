package src.entities.collectibles;

import src.entities.Entity;

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
