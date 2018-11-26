package src.entities.gameplayobjects;

import src.Hero;
import src.Main;
import src.TileEngine;

public class Spikes extends GamePlayObject {

    public Spikes() {
        super();
        setImage("Items\\spikes.png");
        getImage().scale(TileEngine.TILE_WIDTH, getImage().getHeight());
    }

    @Override
    public void act() {
        super.act();
        if (Main.debug) return;
        if (!getIntersectingObjects(Hero.class).isEmpty()) {
            Main.worldInstance.hero.isAlive = false;
        }
    }
}
