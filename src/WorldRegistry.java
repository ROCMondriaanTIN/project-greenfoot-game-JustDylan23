package src;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WorldRegistry {

    private Map<Integer, Worlds> levels = new HashMap();

    public void registerLevel(int index, Worlds worlds) {
        levels.put(index, worlds);
    }

    public Worlds getLevel(int index) {
        return levels.get(index);
    }

    public int size() {
        return levels.size();
    }

    public final Iterable<Worlds> values() {
        return Collections.unmodifiableCollection(levels.values());
    }
}
