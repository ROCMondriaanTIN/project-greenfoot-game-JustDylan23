package src;

import greenfoot.*;
import src.entities.Entity;
import src.entities.EntityFactory;
import src.entities.EntityType;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author D. Hout
 */

public abstract class AbstractWorld extends World {

    private CollisionEngine ce;
    private Integer x;
    private Integer y;
    public int[][] map;
    public ArrayList<Entity> entities = new ArrayList<>();
    private boolean isRendered;
    public Hero hero;
    public Camera camera;
    public Overlay overlay = new Overlay();

    private long debugTime = System.currentTimeMillis();

    public AbstractWorld(Integer x, Integer y) {
        super(1000, 800, 1, false);
        this.x = x;
        this.y = y;
        setBackground("bg.png");
    }


    public abstract void loadWorld();

    public abstract void reset();

    public void renderWorld() {
        Main.worldInstance = this;
        TileEngine te = new TileEngine(this, 60, 60, map);
        camera = new Camera(te);
        addObject(camera, 0, 0);

        hero = new Hero(1);
        camera.follow(hero);
        addObject(hero, x, y);

        ce = new CollisionEngine(te, camera);
        ce.addCollidingMover(hero);
        setPO(2);

        addObject(new PauseScreen(this), 500, 400);
        addObject(overlay, 500, 400);

        for (Entity entity : entities) {
            addObject(entity, entity.getX(), entity.getY());
        }
        overlay.addButtons();
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

    public void addEntity(Entity entity, int x, int y) {
        addObject(entity, x, y);
        entities.add(entity);
    }

    @Override
    public void act() {
        if (isRendered) ce.update();
        if (Greenfoot.isKeyDown("enter")) {
            if (System.currentTimeMillis() - debugTime > 1000) {
                debugTime = System.currentTimeMillis();

                String str = JOptionPane.showInputDialog("request:");

                if (str.equalsIgnoreCase("generate")) {
                    for (Entity entity : entities) {
                        System.out.println("addEntity(EntityFactory.createEntity(EntityType." + entity.constructor + "), " + entity.getX() + ", " + entity.getY() + ");");
                    }
                    return;
                } else if (str.equalsIgnoreCase("debug")) {
                    System.out.println("debug toggled");
                    Main.debug = !Main.debug;
                    System.out.println(Main.debug);
                    return;
                }
                EntityType type;
                try {
                    type = EntityType.fromString(str);
                } catch (Exception e) {
                    System.out.println("failed, could not be added");
                    return;
                }
                Entity entity = EntityFactory.createEntity(type);
                entities.add(entity);
                addObject(entity, hero.getX(), hero.getY());
                System.out.println("entity added");
            }
        }
    }
}
