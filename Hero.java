
import greenfoot.*;

/**
 * @author R. Springer
 * @contrubutor D. v/d Hout
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;

    //hero stats
    private double walkSpeed;
    private double jumpSpeed;

    private int heroState = 1;
    private boolean isOnGround;
    private boolean isStandingStill;
    private boolean isWalking;
    private double walkState = 0;
    private boolean direction = true;

    private double posToNeg(double x) {
        return x - x * 2;
    }

    public Hero(int heroState) {
        setHeroState(heroState);
        //Ve = Vb + a * t
        //physics
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setTexture("p" + heroState + "_front");

    }

    private void setHeroState(int heroState) {
        if (heroState == 1) {
            walkSpeed = 7;
            jumpSpeed = -12.5;
        } else if (heroState == 2) {
            walkSpeed = 8;
            jumpSpeed = -15.5;
        } else if (heroState == 3) {
            walkSpeed = 6;
            jumpSpeed = -10;
        } else throw new IllegalArgumentException("Invalid heroState\nheroState must be 1, 2 or 3");
        this.heroState = heroState;
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            System.out.println("you clicked your hero");
        }
        if (Greenfoot.isKeyDown("1")) setHeroState(1);
        if (Greenfoot.isKeyDown("2")) setHeroState(2);
        if (Greenfoot.isKeyDown("3")) setHeroState(3);
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
                return;
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
        } else if (velocityY > 0 && !isOnGround && Math.abs(velocityX) > 0.3) {
            setTextureWithDirection("p" + heroState + "_fall");
        } else if (velocityY > 0 && !isOnGround && Math.abs(velocityX) < 0.3) {
            setTextureWithDirection("p" + heroState + "_front");
        }
    }

    private void handleAmbientAnimation() {
        if (isStandingStill) {
            setTextureWithDirection("p" + heroState + "_front");
        }
    }

    private void handleWalingAnimation() {
        if (isWalking) {
            walkState += 0.25;
            setTextureWithDirection("p" + heroState + "_walk\\" + (int) Math.ceil(walkState), 65, 86);
            if (walkState == 11) walkState = 0;
        } else walkState = 0;
    }

    private void jumpingHandler() {
        if (isOnGround) {
            if (Greenfoot.isKeyDown("space")) {
                velocityY = jumpSpeed;
            }
        }
    }

    private void horizontalMovementHandler() {
        if (Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("d")) return;
        if (Greenfoot.isKeyDown("a")) velocityX = posToNeg(walkSpeed);
        if (Greenfoot.isKeyDown("d")) velocityX = walkSpeed;
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
        isWalking = (Math.abs(velocityX) > 0.6 && isOnGround);
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
        isStandingStill = (Math.abs(velocityX) < 0.4 && isOnGround);
    }

    private void setTexture(String texture) {
        setImage("Player\\" + texture + ".png");
        getImage().scale(60, 81);
    }

    private void setTexture(String texture, int width, int height) {
        setImage("Player\\" + texture + ".png");
        getImage().scale(width, height);
    }

    private void setTextureWithDirection(String texture) {
        setTexture(texture);
        if (!direction) getImage().mirrorHorizontally();
    }

    private void setTextureWithDirection(String texture, int width, int height) {
        setTexture(texture, width, height);
        if (!direction) getImage().mirrorHorizontally();
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
