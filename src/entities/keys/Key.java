package src.entities.keys;

import src.Hero;
import src.Main;
import src.Tile;
import src.entities.Entity;

public class Key extends Entity {

    private String color;

    public Key(String color) {
        super();
        switch (color) {
            case "Blue":
            case "Green":
            case "Red":
            case "Yellow":
                setImage("Items\\key" + color + ".png");
                this.color = color;
                break;
            default:
                throw new IllegalArgumentException("Invailid color in the Key constructor");
        }
    }

    @Override
    public void act() {
        super.act();
        applyVelocity();
        if (Main.debug) return;
        if (!getIntersectingObjects(Hero.class).isEmpty()) {
            for (Tile tile : getWorld().getObjects(Tile.class)) {
                if (tile.getType().toString().contains(color.toUpperCase())) {
                    tile.getImage().clear();
                    tile.isSolid = false;
                    Main.worldInstance.overlay.addKey(this.color);
                }
            }
            getWorld().removeObject(this);
        }
    }
}
