package src;

import greenfoot.*;
/**
 *
 * @author R. Springer
 */
public class Worlds extends World {

    private CollisionEngine ce;
    private int x;
    private int y;
    public int[][] map;

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public Worlds(int x, int y) {
        super(1000, 800, 1, false);
        this.x = x;
        this.y = y;
        this.setBackground("bg.png");
    }

    public void initializeWorld() {
        TileEngine te = new TileEngine(this, 60, 60, map);
        Camera camera = new Camera(te);
        addObject(camera, 0, 0);
        Hero hero = new Hero(1);
        camera.follow(hero);
        addObject(hero, x, y);
        ce = new CollisionEngine(te, camera);
        ce.addCollidingMover(hero);
        Overlay overlay = new Overlay(hero, this);
        hero.setOverlayInstance(overlay);
        addObject(overlay, 500, 400);
        setPO(2);
        addObject(new PauseScreen(this), 500, 400);
    }

    public void setPO(int i) {
        switch (i) {
            case 1:
                setPaintOrder(ClickableObject.class, PauseScreen.class, Hero.class, Overlay.class, Tile.class);
                break;
            case 2:
                setPaintOrder(Hero.class, ClickableObject.class, PauseScreen.class, Overlay.class, Tile.class);
                break;
        }

    }

    @Override
    public void act() {
        ce.update();
    }
}
