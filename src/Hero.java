package src;

import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import src.entities.Entity;
import src.entities.gameplayobjects.MovingPlatform;

import java.util.List;

/**
 * @author D. Hout
 */

public class Hero extends Mover {
    private final double gravity;
    private final double acc;
    private final double drag;

    private double walkSpeed;
    public double jumpSpeed;
    private double sizeMultiplier = 1;

    public boolean isAlive = true;
    private int heroState;
    private boolean isOnGround;
    private boolean isStandingStill;
    private boolean isWalking;
    private double walkState = 0;
    private boolean direction = true;
    private boolean isClimbing = false;
    private boolean hitBlock = false;
    private long time;
    public boolean isOnMovingPlatform;

    private double invert(double x) {
        return x * -1;
    }

    public Hero(int heroState) {
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        this.heroState = heroState;
        setTexture(3);
        setHeroState(heroState);

    }

    public void setHeroState(int heroState) {
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
        Main.cachedWorld.overlay.updateHeroState(this.heroState);
    }

    @Override
    public void act() {
        if (PauseScreen.isActive) return;
        if (!isAlive) {
            getWorld().removeObject(this);
            Greenfoot.playSound("death.wav");
            LevelStatistics.getInstance().coins -= Main.cachedWorld.coinsGained;
            velocityX = 0;
            velocityY = 0;
            Main.cachedWorld.reset();
            return;
        }

        if (Main.debug) {
            if (Greenfoot.mouseClicked(this)) {
                int state = heroState;
                if (state >= 3) {
                    setHeroState(1);
                } else {
                    setHeroState(state + 1);
                }
            }
        }

        handleMovement();
        handleHeroStats();
        handleWorldInteraction();
        handlePhysics();
        handleAnimation();
    }

    private void handlePhysics() {
        if (!isOnMovingPlatform) {
            velocityY += acc;
        }
        velocityX *= drag;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        int xMin = getImage().getWidth() / 2;
        int xMax = TileEngine.MAP_WIDTH * TileEngine.TILE_WIDTH - xMin;
        if (getX() <= xMin) {
            setLocation(xMin, getY());
            velocityX = 0;
        } else if (getX() >= xMax) {
            setLocation(xMax, getY());
            velocityX = 0;
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

    private void handleWorldInteraction() {
        waterCollisionHandler();
        ladderInteractionHandler();
        checkHitBlock();
        entityInteraction();
        doorInteraction();
        movingPlatformInteraction();
    }

    /**
     * Animation handling is handled here.
     *
     * @author D. Hout
     */
    private void handleInAirAnimation() {
        if (isClimbing || isOnGround || Math.abs(velocityY) < 2) return;
        if (velocityY < 0) {
            setTextureWithDirection(5);
        } else if (velocityY > 0 && Math.abs(velocityX) > 0.3) {
            setTextureWithDirection(2);
        } else if (velocityY > 0 && Math.abs(velocityX) < 0.3) {
            setTextureWithDirection(3);
        }
    }

    private void handleAmbientAnimation() {
        if (isStandingStill) {
            setTextureWithDirection(3);
            isOnGround = true;
        }
    }

    private void handleWalingAnimation() {
        if (isWalking) {
            walkState += 0.25;
            setTextureWithDirection((int) Math.ceil(walkState + 6));
            if (walkState == 11) walkState = 0;
        } else walkState = 0;
    }

    /**
     * Movement handling is handled here.
     *
     * @author D. Hout
     */

    private void jumpingHandler() {
        if (Greenfoot.isKeyDown("space")) {
            long timeTemp = time;
            time = System.currentTimeMillis();
            if (System.currentTimeMillis() - timeTemp < 50) {
                return;
            }
        }
        if ((isOnGround) || isClimbing) {
            if (Greenfoot.isKeyDown("space")) {
                velocityY = jumpSpeed;
                isOnGround = false;
                isClimbing = false;
                hitBlock = false;
                isOnMovingPlatform = false;
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
        double factor = 1;
        if (isClimbing) factor = 0.5;
        if (Greenfoot.isKeyDown("a")) velocityX = invert(walkSpeed * factor);
        if (Greenfoot.isKeyDown("d")) velocityX = walkSpeed * factor;

    }

    /**
     * Stats handling is handled here.
     *
     * @author D. Hout
     */

    private void updateOnGroundStats() {
        if (isOnMovingPlatform) {
            isOnGround = true;
        } else if (velocityY != 0) {
            isOnGround = false;
        } else {
            int dx = getImage().getWidth() / 2;
            int dy = getImage().getHeight() / 2 + 1;
            start:
            for (int i = -1; i <= 1; i++) {
                for (Tile tile : getObjectsAtOffset((dx * i) - (3 * i), dy, Tile.class)) {
                    if (tile.isSolid) isOnGround = true;
                    break start;
                }
            }
        }
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

    private void waterCollisionHandler() {
        for (Tile tile : getObjectsAtOffset(0, 0, Tile.class)) {
            if (tile.type == TileType.LIQUID) {
                isAlive = false;
                return;
            }
        }
    }

    private void ladderInteractionHandler() {
        if (Greenfoot.isKeyDown("space") && Greenfoot.isKeyDown("w")) return;
        List<Tile> tiles = getObjectsAtOffset(0, getHeight() / 4, Tile.class);
        if (tiles.isEmpty()) {
            isClimbing = false;
        } else {
            for (Tile tile : tiles) {
                if (tile.type == TileType.LADDER) {
                    setTexture(0);
                    if (Greenfoot.isKeyDown("w")) {
                        isClimbing = true;
                        velocityY = -4.5;
                        Tile tileTop = ((Tile) getOneObjectAtOffset(0, 0, Tile.class));
                        if (tileTop == null) {
                            velocityY = -1;
                        } else if (tileTop.getType() != TileType.LADDER) {
                            velocityY = -1;
                        }
                    } else if (isClimbing) {
                        velocityY = 1;
                    }
                    break;
                } else {
                    isClimbing = false;
                }
            }
        }
    }

    private void checkHitBlock() {
        if (!hitBlock) {
            for (Tile tile : getObjectsAtOffset(0, getImage().getHeight() / 2 * -1 - 1, Tile.class)) {
                if (tile.isSolid) {
                    hitBlock = true;
                    if (tile.type == TileType.BREAKABLE_BLOCK) {
                        velocityY = 0;
                        Greenfoot.playSound("blockhit.wav");
                        tile.isSolid = false;
                        tile.getImage().clear();
                    } else if (tile.type == TileType.COIN_BOX) {
                        velocityY = 0;
                        Greenfoot.playSound("coin.wav");
                        tile.setTileImage("boxCoinAltDisabled");
                        tile.setType(TileType.BOX);
                        LevelStatistics.getInstance().addCoin();
                    } else if (tile.type == TileType.BOX) {
                        Greenfoot.playSound("bump.wav");
                    }
                    break;
                }
            }
        }
    }

    private void entityInteraction() {
        if (!Main.debug) {
            for (Entity entity : getObjectsAtOffset(0, 0, Entity.class)) {
                entity.interact1();
            }
            for (Entity entity : getIntersectingObjects(Entity.class)) {
                entity.interact2();
            }
        }
    }

    private void doorInteraction() {
        if (Greenfoot.isKeyDown("w")) {
            for (Tile tile : getObjectsAtOffset(0, 0, Tile.class)) {
                if (tile.getType() == TileType.DOOR_OPENED) {
                    Main.worldRegistry.loadLevel(0);
                }
            }
        }
    }

    private void movingPlatformInteraction() {
        List<MovingPlatform> m1 = getObjectsAtOffset(0, getHeight() / 2, MovingPlatform.class);
        isOnMovingPlatform = !m1.isEmpty();
        for (MovingPlatform entity : m1) {
            entity.interact3();
        }
    }

    /**
     * Setter/Getter methods are located here.
     *
     * @author D. Hout
     */

    private void setTexture(int number) {
        setImage(new GreenfootImage(HeroImages.getInstance().heroImages[heroState][number]));
        getImage().scale((int) Math.round(56 * sizeMultiplier), (int) Math.round(77 * sizeMultiplier));
    }

    private void setTextureWithDirection(int number) {
        setTexture(number);
        if (!direction) getImage().mirrorHorizontally();
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}