import greenfoot.*;

/**
 * @author D. Hout
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;

    private double walkSpeed;
    private double jumpSpeed;
    private double sizeMultiplier = 1;

    private boolean isAlive = true;
    private int heroState = 1;
    private boolean isOnGround;
    private boolean isStandingStill;
    private boolean isWalking;
    private double walkState = 0;
    private boolean direction = true;
    private boolean isClimbing = false;
    private boolean hitBlock = false;

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
        GreenfootSound song = new GreenfootSound("music.wav");
        song.play();
        song.setVolume(40);

    }

    private void setHeroState(int heroState) {
        if (this.heroState != heroState) Greenfoot.playSound("powerup.wav");
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
        if (!isAlive) {
            getWorld().removeObject(this);
            return;
        }

        handleMovement();
        handleHeroStats();
        handleWorldInteraction();
        handlePhysics();
        handleAnimation();

        /*
         * remove this shit
         */

        if (Greenfoot.mouseClicked(this)) {
            int state = heroState;
            if (state >= 3) {
                setHeroState(1);
            } else {
                setHeroState(state + 1);
            }
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
        checkHitBlock();
    }

    /**
     * Animation handling is handled here.
     *
     * @author D. Hout
     */
    private void handleInAirAnimation() {
        if (isClimbing) return;
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
     * Movement handling is handled here.
     *
     * @author D. Hout
     */

    private void jumpingHandler() {
        if ((isOnGround && velocityY == 0) || isClimbing) {
            if (Greenfoot.isKeyDown("space")) {
                velocityY = jumpSpeed;
                isOnGround = false;
                isClimbing = false;
                hitBlock = false;
                if (heroState == 3) {
                    Greenfoot.playSound("jump_mini.wav");
                } else {
                    Greenfoot.playSound("jump.wav");
                }
            }
        }
    }

    private void horizontalMovementHandler() {
        if (Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("d")) return;
        if (Greenfoot.isKeyDown("a")) velocityX = invert(walkSpeed);
        if (Greenfoot.isKeyDown("d")) velocityX = walkSpeed;
    }

    /**
     * Stats handling is handled here.
     *
     * @author D. Hout
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
     * Animation handling is handled here.
     *
     * @author D. Hout
     */

    private void enemyCollisionHandler() {
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                isAlive = false;
                return;
            }
        }
    }

    private void waterCollisionHandler() {
        for (Tile tile : getIntersectingObjects(Tile.class)) {
            if (tile.type.contains("liquid")) {
                isAlive = false;
                return;
            }
        }
    }

    private void ladderInteractionHandler() {
        if (Greenfoot.isKeyDown("space") && Greenfoot.isKeyDown("w")) return;
        for (Tile tile : getObjectsAtOffset(0, -5, Tile.class)) {
            if (tile.type.contains("ladder")) {
                if (Greenfoot.isKeyDown("w")) {
                    setTexture("p" + heroState + "_back");
                    velocityY = -4.5;
                    isClimbing = true;
                } else if (isClimbing) {
                    setTexture("p" + heroState + "_back");
                    velocityY = 1;
                }
                break;
            } else isClimbing = false;
        }
    }

    private void checkHitBlock() {
        if (!hitBlock) {
            for (Tile tile : getObjectsAtOffset(0, getImage().getHeight() / 2 * -1 -1, Tile.class)) {
                if (tile.isSolid) {
                    hitBlock = true;
                    if (tile.type.equals("boxEmpty")) {
                        Greenfoot.playSound("blockhit.wav");
                        tile.isSolid = false;
                        tile.getImage().clear();
                    } else if (tile.type.equals("boxCoin")) {
                        Greenfoot.playSound("coin.wav");
                        tile.setTileImage("boxCoinDisabled");
                    } else if (tile.type.contains("box")) {
                        Greenfoot.playSound("bump.wav");
                    }
                    break;
                }
            }
        }
    }

    /**
     * Setter/Getter methods are located here.
     *
     * @author D. Hout
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
