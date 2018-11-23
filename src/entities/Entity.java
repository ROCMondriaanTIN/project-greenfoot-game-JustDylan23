package src.entities;

import greenfoot.Greenfoot;
import greenfoot.MouseInfo;
import src.AbstractWorld;
import src.Mover;

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
        if (Greenfoot.mouseDragged(this)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX() + worldInstance.camera.getX(), mouse.getY() + worldInstance.camera.getY());
        }
    }
}
