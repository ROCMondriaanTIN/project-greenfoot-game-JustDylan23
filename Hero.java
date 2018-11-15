
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    private int heroState = 1;

    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setHeroState("p" + heroState + "_front");
    }

    @Override
    public void act() {
        handleInput();
        
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

    public void handleInput() {
        if (Greenfoot.isKeyDown("w")) {
            velocityY = -12.5;
        }

        if (Greenfoot.isKeyDown("a")) {
            velocityX = -6;
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 6;
        }
    }

    private void setHeroState(String texture) {
        setImage("Player\\" + texture + ".png");
        getImage().scale(60, 81);
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
