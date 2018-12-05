package src;

import src.worlds.Level1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author D. Hout
 *
 */

public class WorldRegistry {

    private Map<Integer, AbstractWorld> levels = new HashMap<>();

    public void registerLevel(int index, AbstractWorld abstractWorld) {
        levels.put(index, abstractWorld);
    }

    public AbstractWorld getLevel(int index) {
        levels.putIfAbsent(index, Level1.getInstance());
        return levels.get(index);
    }
}
