package src.entities.enemies;

import greenfoot.GreenfootImage;
import src.Hero;
import src.Main;
import src.Tile;

import java.util.List;

public class Slime extends Enemy {
    private GreenfootImage walk1 = new GreenfootImage("Enemies\\slimeWalk1.png");

    private boolean isOnGround;
    private long time = System.currentTimeMillis();
    private boolean isFacingRight = true;

    public Slime() {
        setImage(walk1);
        Main.worldInstance.ce.addCollidingMover(this);
        walk1.mirrorHorizontally();
        velocityX = 3;
    }

    private void updateGroundStats() {
        isOnGround = false;
        for (Tile tile : getObjectsAtOffset(0, getImage().getHeight() / 2 + 1, Tile.class)) {
            if (tile.isSolid) isOnGround = true;
            break;
        }
    }

    @Override
    public void act() {
        super.act();
        velocityY = 2;
        applyVelocity();
        updateGroundStats();

        int dx = getImage().getWidth() / 2;
        int dy = getImage().getHeight() / 2 + 1;
        boolean turnAround = false;
        for (int i = -1; i <= 1; i += 2) {
            List<Tile> tiles = getObjectsAtOffset(dx * i + 5 * i, dy, Tile.class);
            System.out.println(tiles.size());
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
            }
        }

        if (isFacingRight) {
            velocityX = 3;
        } else velocityX = -3;

        if (Main.debug) return;
        if (!getIntersectingObjects(Hero.class).isEmpty()) {
            Main.worldInstance.hero.isAlive = false;
        }
    }
}
