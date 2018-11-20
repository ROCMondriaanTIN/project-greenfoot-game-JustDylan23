package src;

import greenfoot.*;
import src.worlds.Level1;

public class Main extends World {
    
    public static int coinCount;
    public static GreenfootSound backgroundSong = new GreenfootSound("music.wav");

    public static final WorldRegistry worldRegistry = new WorldRegistry();
    public static int LEVEL = 1;

    public Main() {
        super(1000, 800, 1, false);
        backgroundSong.setVolume(40);
        Greenfoot.start();
        setBackground("bg_menu.png");

        worldRegistry.registerLevel(1, new Level1());

        addObject(new ClickableObject("startGame.png"), 323 ,348);
        addObject(new ClickableObject("exitGame.png"), 323 ,548);
    }

    public static GreenfootImage newTextImage(String text, int size) {
        return new GreenfootImage(text, size, Color.WHITE, new Color(0, 0, 0, 0), Color.BLACK);
    }
}
