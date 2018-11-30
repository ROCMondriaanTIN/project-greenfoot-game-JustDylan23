package src;

import greenfoot.Greenfoot;
import greenfoot.World;
import src.entities.Entity;
import src.entities.EntityFactory;
import src.entities.EntityType;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author D. Hout
 */

public abstract class AbstractWorld extends World {

    public CollisionEngine ce;
    private Integer x;
    private Integer y;
    public int[][] map;
    public ArrayList<Entity> entities = new ArrayList<>();
    private boolean isRendered;
    public Hero hero;
    public Camera camera;
    public Overlay overlay = new Overlay();
    public int coinsGained;
    public int keyCount;

    public AbstractWorld(Integer x, Integer y) {
        super(1000, 800, 1, false);
        this.x = x;
        this.y = y;
        setBackground("bg.png");
    }


    public void loadWorld() {
        renderWorld();
        Greenfoot.setWorld(this);
        Main.worldInstance = this;
        this.setPO(2);
        this.overlay.updateCoinCount();
    }

    public abstract void reset();

    private void renderWorld() {
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

    protected void addEntity(Entity entity, int x, int y) {
        addObject(entity, x, y);
        entity.spawnX = x;
        entity.spawnY = y;
        int length = entity.getClass().getPackage().getName().length();
        entity.constructor = "new " + entity.getClass().getName().substring(length + 1) + "()";
        entities.add(entity);
    }

    @Override
    public void act() {
        if (isRendered) ce.update();
        if (Greenfoot.isKeyDown("enter")) {
            String str = JOptionPane.showInputDialog("request:");

            if (str == null) return;

            if (str.equalsIgnoreCase("generate")) {
                for (Entity entity : entities) {
                    System.out.println("addEntity(" + entity.constructor + ", " + entity.spawnX + ", " + entity.spawnY + ");");
                }
            } else if (str.equalsIgnoreCase("debug")) {
                System.out.println("debug toggled");
                Main.debug = !Main.debug;
                System.out.println(Main.debug);
            } else {
                EntityType type = EntityType.fromString(str);
                if (type == null) {
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
