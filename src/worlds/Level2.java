package src.worlds;

import greenfoot.Greenfoot;
import src.AbstractWorld;

public class Level2 extends AbstractWorld {

    private static Level2 instance = new Level2();

    int[][] mapRaw;

    private Level2() {
        super(238, 1342);
        this.map = mapRaw;
        renderWorld();
    }

    public static Level2 getInstance() {
        return instance;
    }
    @Override
    public void loadWorld() {
        Greenfoot.setWorld(instance);
        setPO(2);
    }

    @Override
    public void reset() {
        instance = new Level2();
        Greenfoot.setWorld(instance);
    }
}
