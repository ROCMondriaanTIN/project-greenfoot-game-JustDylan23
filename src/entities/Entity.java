package src.entities;

import greenfoot.Greenfoot;
import greenfoot.MouseInfo;

import src.Main;
import src.Mover;
import src.TileEngine;

/**
 * @author D. Hout
 */

public  class Entity extends Mover {
    public String constructor;

    public int spawnX;
    public int spawnY;
    public boolean canCollide;

    public Entity() {
    }

    public void interact1() {
    }
    public void interact2() {
    }

    @Override
    public void act() {
        super.act();
        applyVelocity();
        if (Main.debug) {
            if (Greenfoot.mouseDragged(this)) {
                MouseInfo mouse = Greenfoot.getMouseInfo();
                setLocation(mouse.getX() + Main.cachedWorld.camera.getX(), mouse.getY() + Main.cachedWorld.camera.getY());
            } if (Greenfoot.mouseDragEnded(this)) {
                int x = (int) Math.floor(getX() / (double) TileEngine.TILE_WIDTH);
                int y = (int) Math.floor(getY() / (double) TileEngine.TILE_HEIGHT);
                setLocation(x * TileEngine.TILE_WIDTH + TileEngine.TILE_WIDTH / 2,
                        y * TileEngine.TILE_HEIGHT + TileEngine.TILE_WIDTH / 2);

                spawnX = x * TileEngine.TILE_WIDTH + TileEngine.TILE_WIDTH / 2;
                spawnY = y * TileEngine.TILE_HEIGHT + TileEngine.TILE_WIDTH / 2;
            }
        }
    }
}
