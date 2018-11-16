import greenfoot.*;

/**
 * @author R. Springer
 * @contributor D. v/d Hout
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;

    private double walkSpeed;
    private double jumpSpeed;
    private double sizeMultiplier = 1;

    private int heroState = 1;
    private boolean isOnGround;
    private boolean isStandingStill;
    private boolean isWalking;
    private double walkState = 0;
    private boolean direction = true;

    private double invert(double x) {
        return x * -1;
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
            sizeMultiplier = 1;
        } else if (heroState == 2) {
            walkSpeed = 8;
            jumpSpeed = -15.5;
            sizeMultiplier = 1.3;
        } else if (heroState == 3) {
            walkSpeed = 6;
            jumpSpeed = -10;
            sizeMultiplier = 0.7;
        } else throw new IllegalArgumentException("Invalid heroState\nheroState must be 1, 2 or 3");
        this.heroState = heroState;
    }

    @Override
    public void act() {
        if (Greenfoot.isKeyDown("escape")) System.exit(0);

        handleMovement();
        handleHeroStats();
        handleWorldInteraction();
        handlePhysics();
        handleAnimation();

        /**
         * @Reminder: remove this shit
         */
        if (Greenfoot.mouseClicked(this)) {
            heroState++;
            if (heroState > 3) {
                heroState = 1;
            }
            setHeroState(heroState);
        }
    }

    private void handlePhysics() {
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
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

    private void handleWorldInteraction() {
        enemyCollisionHandler();
        waterCollisionHandler();
        ladderInteractionHandler();
    }

    /**
     * @implSpec Animation handling is handled here.
     */
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
            setTextureWithDirection("p" + heroState + "_walk\\" + (int) Math.ceil(walkState), 61, 82);
            if (walkState == 11) walkState = 0;
        } else walkState = 0;
    }

    /**
     * @implSpec Movement handling is handled here.
     */

    private void jumpingHandler() {
        if (isOnGround && velocityY == 0) {
            if (Greenfoot.isKeyDown("space")) {
                System.out.println(velocityY);
                System.out.println(isOnGround);
                velocityY = jumpSpeed;
                isOnGround = false;
            }
        }
    }

    private void horizontalMovementHandler() {
        if (Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("d")) return;
        if (Greenfoot.isKeyDown("a")) velocityX = invert(walkSpeed);
        if (Greenfoot.isKeyDown("d")) velocityX = walkSpeed;
    }

    /**
     * @implSpec Stats handling is handled here.
     */

    private void updateOnGroundStats() {
        int width = getImage().getWidth() / 2;

        if (velocityY > 0) {
            isOnGround = false;
            return;
        }

        Boolean successRate = false;

        for (Tile tile : getObjectsAtOffset(0, getImage().getHeight() / 2 + 1, Tile.class)) {
            if (tile.isSolid) successRate = true;
        }
        if (!successRate) {
            for (Tile tile : getObjectsAtOffset(width - 3, getImage().getHeight() / 2 + 1, Tile.class)) {
                if (tile.isSolid) successRate = true;
            }
            if (!successRate) {
                for (Tile tile : getObjectsAtOffset((int) invert(width) + 3, getImage().getHeight() / 2 + 1, Tile.class)) {
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

    /**
     * @implSpec Animation handling is handled here.
     */

    private void enemyCollisionHandler() {
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                return;
            }
        }
    }

    private void waterCollisionHandler() {
        for (Tile tile : getIntersectingObjects(Tile.class)) {
            if (tile.type.contains("liquid")) {
                getWorld().removeObject(this);
                return;
            }
        }
    }

    private void ladderInteractionHandler() {
        if (Greenfoot.isKeyDown("shift")) {
            if (Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("s")) return;
            for (Tile tile : getObjectsAtOffset(0, -5, Tile.class)) {
                if (tile.type.contains("ladder")) {
                    velocityY = 1;
                    setTexture("p" + heroState + "_back");
                    if (Greenfoot.isKeyDown("w")) {
                        if (tile.type.equals("ladderTop")) velocityY = -10;
                        if (tile.type.equals("ladderMid")) velocityY = -4;
                    }
                }
            }
        }
    }

    /**
     * @implSpec Setter/Getter methods are located here.
     */

    private void setTexture(String texture) {
        setImage("Player\\" + texture + ".png");
        getImage().scale((int) Math.round(56 * sizeMultiplier), (int) Math.round(77 * sizeMultiplier));
    }

    private void setTexture(String texture, int width, int height) {
        setImage("Player\\" + texture + ".png");
        getImage().scale((int) Math.round(width * sizeMultiplier), (int) Math.round(height * sizeMultiplier));
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
