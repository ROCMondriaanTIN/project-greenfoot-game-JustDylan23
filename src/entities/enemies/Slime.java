package src.entities.enemies;

import greenfoot.GreenfootImage;
import src.Main;
import src.PauseScreen;
import src.Tile;

import java.util.List;

/**
 * @author D. Hout
 */

public class Slime extends Enemy {
    private GreenfootImage walk1 = new GreenfootImage("Enemies\\slimeWalk1.png");
    private GreenfootImage walk2 = new GreenfootImage("Enemies\\slimeWalk2.png");
    private int imageState = 1;

    private boolean isOnGround;
    private long time = System.currentTimeMillis();
    private boolean isFacingRight = true;

    public Slime() {
        setImage(walk1);
        canCollide = true;
        walk1.mirrorHorizontally();
        walk2.mirrorHorizontally();
    }

    private void updateGroundStats() {
        isOnGround = false;
        for (Tile tile : getObjectsAtOffset(0, getImage().getHeight() / 2 + 1, Tile.class)) {
            if (tile.isSolid) isOnGround = true;
            break;
        }
    }

    @Override
    public void interact2() {
        Main.worldInstance.hero.isAlive = false;
    }

    @Override
    public void act() {
        super.act();
        if (PauseScreen.isActive) return;
        velocityY = 2;
        applyVelocity();
        updateGroundStats();
        imageState++;
        if (imageState == 60) {
            setImage(walk2);
            imageState = 0;
        } else if (imageState == 30) {
            setImage(walk1);
        }

        int dx = getImage().getWidth() / 2;
        int dy = getImage().getHeight() / 2 + 1;
        boolean turnAround = false;
        for (int i = -1; i <= 1; i += 2) {
            List<Tile> tiles = getObjectsAtOffset(dx * i + 5 * i, dy, Tile.class);
            if (tiles.isEmpty()) {
                turnAround = true;
            }
        }

        if (turnAround && isOnGround) {
            long now = System.currentTimeMillis();
            if (now - time > 300) {
                isFacingRight = !isFacingRight;
                time = now;
                walk1.mirrorHorizontally();
                walk2.mirrorHorizontally();
            }
        }

        if (isFacingRight) {
            velocityX = 2;
        } else velocityX = -2;
    }
}
