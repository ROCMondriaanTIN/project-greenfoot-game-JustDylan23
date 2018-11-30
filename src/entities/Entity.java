package src.entities;

import greenfoot.Greenfoot;
import greenfoot.MouseInfo;

import src.Main;
import src.Mover;
import src.TileEngine;

public class Entity extends Mover {
    public String constructor;

    public int spawnX;
    public int spawnY;

    public Entity() {
    }

    @Override
    public void act() {
        super.act();
        if (Main.debug) {
            if (Greenfoot.mouseDragged(this)) {
                MouseInfo mouse = Greenfoot.getMouseInfo();
                setLocation(mouse.getX() + Main.worldInstance.camera.getX(), mouse.getY() + Main.worldInstance.camera.getY());
                spawnX = getX();
                spawnY = getY();
            } if (Greenfoot.mouseDragEnded(this)) {
                int x = (int) Math.floor(getX() / (double) TileEngine.TILE_WIDTH);
                int y = (int) Math.floor(getY() / (double) TileEngine.TILE_HEIGHT);
                setLocation(x * TileEngine.TILE_WIDTH + TileEngine.TILE_WIDTH / 2,
                        y * TileEngine.TILE_HEIGHT + TileEngine.TILE_WIDTH / 2);
            }
        }
    }
}
