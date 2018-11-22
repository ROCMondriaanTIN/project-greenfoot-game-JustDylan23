package src;

import greenfoot.*;
import src.entities.Entity;

import java.util.ArrayList;

/**
 * @author D. Hout
 *
 */

public abstract class AbstractWorld extends World {

    private CollisionEngine ce;
    private Integer x;
    private Integer y;
    public int[][] map;
    public ArrayList<Entity> entities = new ArrayList<>();
    private boolean includeHero;
    private boolean isRendered;

    private long debugTime = System.currentTimeMillis();

    public AbstractWorld(boolean includeHeroint, Integer x, Integer y) {
        super(1000, 800, 1, false);
        this.includeHero = true;
        this.x = x;
        this.y = y;
        setBackground("bg.png");
    }


    public abstract void loadWorld();
    public abstract void reset();

    /*public void loadWorld() {
        String className = this.getClass().getName();
        try {
            Class<?> myClass = Class.forName(className);
            Constructor<?> ctr = myClass.getConstructor();
            World world = (World) ctr.newInstance();
            if(world != null) {
                Greenfoot.setWorld(world);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }*/

    public void renderWorld() {
        TileEngine te = new TileEngine(this, 60, 60, map);
        Camera camera = new Camera(te);
        addObject(camera, 0, 0);

        Hero hero = new Hero(1, this);
        camera.follow(hero);
        addObject(hero, x, y);

        ce = new CollisionEngine(te, camera);
        ce.addCollidingMover(hero);

        Overlay overlay = new Overlay(hero, this);
        hero.setOverlayInstance(overlay);
        addObject(overlay, 500, 400);
        setPO(2);

        addObject(new PauseScreen(this), 500, 400);

        for (Entity entity : entities) {
            addObject(entity, entity.getX(), entity.getY());
        }
        isRendered = true;
    }

    public void setPO(int i) {
        switch (i) {
            case 1:
                setPaintOrder(ClickableObject.class, PauseScreen.class, Entity.class, Hero.class, OverlayObject.class, Overlay.class, Tile.class);
                break;
            case 2:
                setPaintOrder(Entity.class, Hero.class, ClickableObject.class, PauseScreen.class, OverlayObject.class, Overlay.class, Tile.class);
                break;
        }

    }

    @Override
    public void act() {
        if (isRendered) ce.update();
        if (System.currentTimeMillis() - debugTime > 1000) {
            debugTime = System.currentTimeMillis();
        }


    }
}
