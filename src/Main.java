package src;

import greenfoot.*;
import src.worlds.Level1;
import src.worlds.Level2;
import src.worlds.LevelSelecting;

/**
 * @author D. Hout
 *
 */

public class Main extends World {

    public static boolean debug = false;

    public static AbstractWorld cachedWorld;

    public static final WorldRegistry worldRegistry = new WorldRegistry();
    public static int LEVEL = 1;

    public Main() {
        super(1000, 800, 1, false);
        Greenfoot.start();
        setBackground("bg_menu.png");
        addObject(new ClickableObject("startGame.png"), 323 ,348);
        addObject(new ClickableObject("exitGame.png"), 323 ,548);

    }

    public static GreenfootImage newTextImage(String text, int size) {
        return new GreenfootImage(text, size, Color.WHITE, new Color(0, 0, 0, 0), Color.BLACK);
    }
}
