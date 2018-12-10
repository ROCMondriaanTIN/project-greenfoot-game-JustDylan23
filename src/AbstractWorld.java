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

public class AbstractWorld extends World {

    public CollisionEngine ce;
    public TileEngine te;
    private Integer x;
    private Integer y;
    protected int[][] map;
    public ArrayList<Entity> entities = new ArrayList<>();
    public Hero hero;
    public Camera camera;
    public Overlay overlay = new Overlay();
    int coinsGained;
    public int keyCount;
    private boolean isLoaded = false;

    public AbstractWorld(Integer x, Integer y) {
        super(1000, 800, 1, false);
        this.x = x;
        this.y = y;
        setBackground("bg.png");
        Greenfoot.setWorld(this);
    }


    public void reset() {
        Main.worldRegistry.loadLevel(Main.LEVEL);
    }

    public void loadWorld() {
        Main.cachedWorld = this;
        renderWorld();
        this.setPO(2);
        this.overlay.updateCoinCount();
    }

    protected void addEntity(Entity entity, int x, int y) {
        entity.spawnX = x;
        entity.spawnY = y;
        int length = entity.getClass().getPackage().getName().length();
        entity.constructor = "new " + entity.getClass().getName().substring(length + 1) + "()";
        entities.add(entity);
    }

    private void renderWorld() {
        te = new TileEngine(this, 60, 60, map);
        camera = new Camera(te);
        addObject(camera, x, y);

        hero = new Hero(1);
        camera.follow(hero);
        addObject(hero, x, y);

        ce = new CollisionEngine(te, camera);
        ce.addCollidingMover(hero);
        setPO(1);

        addObject(new PauseScreen(this), 500, 400);
        addObject(overlay, 500, 400);

        overlay.addButtons();

        for (Entity entity : entities) {
            addObject(entity, entity.spawnX, entity.spawnY);
        }

        isLoaded = true;
    }

    void setPO(int i) {
        switch (i) {
            case 1:
                setPaintOrder(ClickableObject.class, PauseScreen.class, Overlay.class, OverlayObject.class, Hero.class, Entity.class, Tile.class);
                break;
            case 2:
                setPaintOrder(ClickableObject.class, PauseScreen.class, Hero.class, Entity.class, Overlay.class, OverlayObject.class, Tile.class);
                break;
        }
    }

    @Override
    public void act() {
        if (!isLoaded) return;
        ce.update();
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
                addObject(entity, camera.getX() + 500, camera.getY() + 400);
                entity.spawnX = camera.getX() + 500;
                entity.spawnY = camera.getY() + 400;
                System.out.println("entity added");

            }

        }
    }
}
