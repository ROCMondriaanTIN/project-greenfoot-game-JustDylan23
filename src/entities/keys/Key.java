package src.entities.keys;

import greenfoot.Greenfoot;
import src.Main;
import src.Tile;
import src.TileType;
import src.entities.Entity;

/**
 * @author D. Hout
 */

public class Key extends Entity {

    private String color;

    Key(String color) {
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
                throw new IllegalArgumentException("Invalid color in the Key constructor");
        }
    }

    @Override
    public void interact1() {
        Main.cachedWorld.keyCount++;
        for (Tile tile : getWorld().getObjects(Tile.class)) {
            if (tile.getType().toString().contains(color.toUpperCase())) {
                tile.getImage().clear();
                tile.isSolid = false;
                Main.cachedWorld.overlay.addKey(this.color);
            }
            if (Main.cachedWorld.keyCount == 4) {
                if (tile.getType() == TileType.LOCK_X) {
                    tile.getImage().clear();
                    tile.isSolid = false;
                }
            }
        }
        getWorld().removeObject(this);
        if (Main.cachedWorld.keyCount != 4) {
            Greenfoot.playSound("key.wav");
        } else Greenfoot.playSound("key2.wav");
    }
}
