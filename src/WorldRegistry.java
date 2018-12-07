package src;

import src.worlds.Level1;
import src.worlds.Level2;
import src.worlds.Level3;
import src.worlds.LevelSelecting;

/**
 * @author D. Hout
 */

public class WorldRegistry {
    public void loadLevel(int i) {
        Main.LEVEL = i;
        switch (i) {
            case 0:
                Main.cachedWorld = LevelSelecting.getInstance();
                break;
            case 1:
                Main.cachedWorld = new Level1();
                break;
            case 2:
                Main.cachedWorld = new Level2();
                break;
            case 3:
                Main.cachedWorld = new Level3();
                break;
            default:
                System.out.println("resorted to default world");
                Main.cachedWorld = new Level1();
                break;
        }
        Main.cachedWorld.loadWorld();
    }
}
