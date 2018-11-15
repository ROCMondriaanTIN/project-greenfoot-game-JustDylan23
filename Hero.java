
import greenfoot.*;

/**
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;

    //hero stats
    private int heroState = 1;
    private boolean isOnGround;
    private boolean isStandingStill;
    private boolean isWalking;
    private double walkState = 0;
    private boolean direction = true;

    private double posToNeg(double x) {
        return x - x * 2;
    }

    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setTexture("p" + heroState + "_front");
    }

    @Override
    public void act() {
        handleAnimation();
        handleMovement();
        handleHeroStats();

        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                break;
            }
        }
    }

    private void handleAnimation() {
        handleAmbientAnimation();
        handleWalingAnimation();
        handleInAirAnimation();
    }

    private void handleMovement() {
        horizontalMovementHandler();
        jumpingHandler();
    }

    private void handleHeroStats() {
        updateOnGroundStats();
        updateIsWalking();
        updateDirection();
        updateIsStandingStill();
    }

    private void handleInAirAnimation() {
        if (velocityY < 0 && !isOnGround) {
            setTextureWithDirection("p" + heroState + "_jump");
        }
    }

    private void handleAmbientAnimation() {
        if (isStandingStill) {
            setTexture("p" + heroState + "_front");
        }
    }

    private void handleWalingAnimation() {
        if (isWalking) {
            walkState += 0.25;
            setTextureWithDirection("p" + heroState + "_walk\\p" + heroState + "_walk" + (int) Math.ceil(walkState));
            if (walkState == 11) walkState = 0;
        } else walkState = 0;
    }

    private void jumpingHandler() {
        if (isOnGround) {
            if (Greenfoot.isKeyDown("space")) {
                velocityY = -12.5;
            }
        }
    }

    private void horizontalMovementHandler() {
        if (Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("d")) return;
        if (Greenfoot.isKeyDown("a")) velocityX = posToNeg(6);
        if (Greenfoot.isKeyDown("d")) velocityX = 6;
    }

    private void updateOnGroundStats() {
        int width = getImage().getWidth() / 2;

        Boolean successRate = false;

        for (Tile tile : getObjectsAtOffset(0, getImage().getHeight() / 2 + 1, Tile.class)) {
            if (tile.isSolid) successRate = true;
        }
        if (!successRate) {
            for (Tile tile : getObjectsAtOffset(width - 3, getImage().getHeight() / 2 + 1, Tile.class)) {
                if (tile.isSolid) successRate = true;
            }
            if (!successRate) {
                for (Tile tile : getObjectsAtOffset((int) posToNeg(width) + 3, getImage().getHeight() / 2 + 1, Tile.class)) {
                    if (tile.isSolid) successRate = true;
                }
            }
        }

        for (Tile tile : getObjectsAtOffset(0, getImage().getHeight() / 2 + 1, Tile.class)) {
            if (tile.isSolid) successRate = true;
            break;
        }
        isOnGround = successRate;
    }

    private void updateIsWalking() {
        if (Math.abs(velocityX) > 0.5 && isOnGround) {
            isWalking = true;
        } else isWalking = false;
    }

    private void updateDirection() {
        if (velocityX > 0) {
            if (!direction) {
                direction = true;
                getImage().mirrorHorizontally();
            }
        }
        if (velocityX < 0) {
            if (direction) {
                direction = false;
                getImage().mirrorHorizontally();
            }
        }
    }

    private void updateIsStandingStill() {
        if (Math.abs(velocityX) < 0.4 && isOnGround) {
            isStandingStill = true;
        } else isStandingStill = false;
    }

    private void setTexture(String texture) {
        setImage("Player\\" + texture + ".png");
        getImage().scale(60, 81);
    }

    private void setTextureWithDirection(String texture) {
        setImage("Player\\" + texture + ".png");
        getImage().scale(60, 81);
        if (!direction) getImage().mirrorHorizontally();

    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
