package src.worlds;

import greenfoot.Greenfoot;
import src.*;

import java.util.ArrayList;

public class LevelSelecting extends AbstractWorld {

    private static LevelSelecting instance = new LevelSelecting();

    private ArrayList<ClickableObject> levels = new ArrayList<>();
    private OverlayObject starCount = new OverlayObject(Main.newTextImage("x" + LevelStatistics.getInstance().stars, 60));

    private int unlockedLevels;

    private boolean hasExecuted;

    private Location[] locations = {new Location(218, 260), new Location( 479, 232),
            new Location(776, 325), new Location(566, 455), new Location(225, 540),
            new Location(435, 684), new Location(780, 677)};

    LevelSelecting() {
        super(null, null);
        setBackground("levelSelecting.png");
        addObject(starCount,100, 750);
        updateUnlockedLevels();

    }

    public void updateUnlockedLevels() {
        int amountOfUnlockableLevels = (LevelStatistics.getInstance().stars / 2) + 1;
        for (int i = unlockedLevels; i < amountOfUnlockableLevels; i++) {
            unlockedLevels++;
            ClickableObject object = new ClickableObject("levelHitbox.png", this);
            object.getImage().scale(160, 160);
            object.action = "level" + unlockedLevels;
            levels.add(object);
            addObject(object, locations[unlockedLevels - 1].x, locations[unlockedLevels - 1].y);
        }
    }

    public static LevelSelecting getInstance() {
        return instance;
    }

    @Override
    public void loadWorld() {
        Greenfoot.setWorld(instance);
    }

    public void updateStars() {
        starCount.setImage(Main.newTextImage("x" + LevelStatistics.getInstance().stars, 60));
    }

    @Override
    public void reset() {
        instance = new LevelSelecting();
        Greenfoot.setWorld(instance);
    }

    @Override
    public void act() {
        super.act();
        if (!hasExecuted) {
            if (Greenfoot.isKeyDown("0")) {
                for (ClickableObject object : levels) {
                    System.out.println("loc: " + object.getX() + " " +  object.getY());
                }
                hasExecuted = true;
            }
        }
    }
}
