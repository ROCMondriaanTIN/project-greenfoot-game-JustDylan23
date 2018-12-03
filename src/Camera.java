package src;

import greenfoot.*;

/**
 * @author R. Springer
 */
public class Camera extends Actor {

    private static int SPEED = 10;
    private int width;
    private int height;
    private int maxX;
    private int maxY;
    private final TileEngine tileEngine;
    private double cameraDrag;
    private double dirX;
    private double dirY;
    private boolean follow;
    private Mover followActor;

    public Camera(TileEngine tileEngine) {
        width = TileEngine.SCREEN_WIDTH;
        height = TileEngine.SCREEN_HEIGHT;
        setLocation(0, 0);
        maxX = TileEngine.MAP_WIDTH * TileEngine.TILE_WIDTH - width;
        maxY = TileEngine.MAP_HEIGHT * TileEngine.TILE_HEIGHT - height;
        this.tileEngine = tileEngine;
        cameraDrag = 0.9;
        setImage(new GreenfootImage(1, 1));
    }

    public Camera(TileEngine tileEngine, int speed) {
        this(tileEngine);
        SPEED = speed;
    }

    private int calculate(int number, int maxNumber) {
        return Math.max(0, Math.min(number, maxNumber));
    }

    void follow(Mover mover) {
        follow = true;
        mover.setCamera(this);
        followActor = mover;
    }

    @Override
    public void act() {
        dirX *= (Math.abs(dirX) > 0.1) ? cameraDrag : 0;
        dirY *= (Math.abs(dirY) > 0.1) ? cameraDrag : 0;

        int x;
        int y;

        if (Main.debug) {
            if (Greenfoot.isKeyDown("e")) {
                follow = !follow;
            }
        }

        if (follow) {
            int halfWidth = width / 2;
            int halfHeight = height / 2;

            followActor.screenX = halfWidth;
            followActor.screenY = halfHeight;

            x = followActor.getX() - halfWidth;
            y = followActor.getY() - halfHeight;

            x = calculate(x, maxX);
            y = calculate(y, maxY);

            setLocation(x, y);

            if (followActor.getX() < halfWidth || followActor.getX() > maxX + halfWidth) {

                followActor.screenX = followActor.getX() - getX();
            }

            if (followActor.getY() < halfHeight || followActor.getY() > maxY + halfHeight) {
                followActor.screenY = followActor.getY() - getY();
            }
        } else {
            if (Greenfoot.isKeyDown("UP")) {
                dirY = -1;
            } else if (Greenfoot.isKeyDown("DOWN")) {
                dirY = 1;
            }
            if (Greenfoot.isKeyDown("LEFT")) {
                dirX = -1;
            } else if (Greenfoot.isKeyDown("RIGHT")) {
                dirX = 1;
            }
            move(dirX, dirY);
        }

        updateView();
    }

    /**
     * This method can be used to move the camera around the world. Make sure
     * you don't move when you are following.
     *
     * @param dirX The direction x
     * @param dirY The direction y
     */
    public void move(double dirX, double dirY) {
        int x = getX();
        int y = getY();

        x += dirX * SPEED;
        y += dirY * SPEED;

        x = calculate(x, maxX);
        y = calculate(y, maxY);
        setLocation(x, y);
    }

    /**
     * This method will update the Tiles from the engine to match the view. Also
     * it will update all the Movers classes in the wolrd. So objects move
     * around with the camera. If an Actor class is added it will not move
     * around with the camera. It has to be a class that is the Mover or a
     * extend of the Mover class.
     */
    public void updateView() {
        int startCol = (int) Math.floor((double) getY() / (double) TileEngine.TILE_HEIGHT);
        int endCol = startCol + (height / TileEngine.TILE_HEIGHT);
        int startRow = (int) Math.floor((double) getX() / (double) TileEngine.TILE_WIDTH);
        int endRow = startRow + (width / TileEngine.TILE_WIDTH);
        int offsetX = -getX() + startCol * TileEngine.TILE_WIDTH;
        int offsetY = -getY() + startRow * TileEngine.TILE_HEIGHT;

        Tile currentTile;
        int x;
        int y;
        for (y = 0; y < TileEngine.MAP_HEIGHT; y++) {
            for (x = 0; x < TileEngine.MAP_WIDTH; x++) {
                currentTile = tileEngine.getTileAt(x, y);
                if (currentTile == null) {
                    continue;
                }

                int xPos = ((x - startCol) * TileEngine.TILE_WIDTH + offsetX) + (TileEngine.TILE_WIDTH / 2);
                int yPos = ((y - startRow) * TileEngine.TILE_HEIGHT + offsetY) + (TileEngine.TILE_HEIGHT / 2);
                currentTile.setLocation(xPos, yPos);
            }
        }

        if (!follow) {
            followActor.screenX = followActor.getX() - getX();
            followActor.screenY = followActor.getY() - getY();
        }

        for (Mover actor : getWorld().getObjects(Mover.class)) {
            if (actor == followActor) {
                continue;
            }
            actor.screenX = actor.getX() - getX();
            actor.screenY = actor.getY() - getY();
        }
    }
}
