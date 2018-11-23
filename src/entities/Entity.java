package src.entities;

import greenfoot.Greenfoot;
import greenfoot.MouseInfo;
import src.AbstractWorld;
import src.Main;
import src.Mover;
import src.TileEngine;

public class Entity extends Mover {

    private AbstractWorld worldInstance;
    public String constructor;

    public Entity() {
    }

    public void setWorldInstance(AbstractWorld worldInstance) {
        this.worldInstance = worldInstance;
    }

    @Override
    public void act() {
        super.act();
        velocityY = 0;
        velocityX = 0;
        applyVelocity();
        if (Main.debug) {
            if (Greenfoot.mouseDragged(this)) {
                MouseInfo mouse = Greenfoot.getMouseInfo();
                setLocation(mouse.getX() + worldInstance.camera.getX(), mouse.getY() + worldInstance.camera.getY());
            } if (Greenfoot.mouseDragEnded(this)) {
                int x = (int) Math.floor(getX() / (double) TileEngine.TILE_WIDTH);
                int y = (int) Math.floor(getY() / (double) TileEngine.TILE_HEIGHT);
                setLocation(x * TileEngine.TILE_WIDTH + TileEngine.TILE_WIDTH / 2,
                        y * TileEngine.TILE_HEIGHT + TileEngine.TILE_WIDTH / 2);
            }
        }
    }
}
