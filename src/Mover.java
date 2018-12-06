package src;

import greenfoot.*;

/**
 *
 * @author D. Hout
 */
public class Mover extends Actor {

    int screenX;
    int screenY;
    public double velocityX;
    public double velocityY;

    private int worldX;
    private int worldY;
    private boolean firstLocation = true;

    protected void applyVelocity() {
        if (Math.abs(velocityX) < 0.02) {
            velocityX = 0;
        }
        if (Math.abs(velocityY) < 0.02) {
            velocityY = 0;
        }
        setLocation((int) (getX() + .5 + velocityX), (int) (getY() + .5 + velocityY));
    }

    @Override
    public void setLocation(int x, int y) {
        if (firstLocation) {
            firstLocation = false;
            screenX = x;
            screenY = y;
        }
        super.setLocation(screenX, screenY);
        worldX = x;
        worldY = y;
    }

    @Override
    public int getX() {
        return worldX;
    }

    @Override
    public int getY() {
        return worldY;
    }

    private int getScreenX() {
        return screenX;
    }

    private int getScreenY() {
        return screenY;
    }

    @Override
    public String toString() {
        return "X: " + getX() + "\n"
                + "Y: " + getY() + "\n"
                + "screenX: " + getScreenX() + "\n"
                + "screenY: " + getScreenY() + "\n"
                + "velocityX: " + velocityX + "\n"
                + "velocityY: " + velocityY + "\n";
    }
}
