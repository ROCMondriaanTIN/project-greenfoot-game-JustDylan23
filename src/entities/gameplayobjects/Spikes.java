package src.entities.gameplayobjects;

import src.Main;
import src.TileEngine;

/**
 * @author D. Hout
 */

public class Spikes extends GamePlayObject {

    private boolean hasStarted;

    public Spikes() {
        super();
        setImage("Items\\spikes.png");
    }

    @Override
    public void interact1() {
        if (!hasStarted) {
            getImage().scale(TileEngine.TILE_WIDTH, getImage().getHeight());
        }
        hasStarted = true;
        Main.cachedWorld.hero.isAlive = false;
    }
}
