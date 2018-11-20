package src;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WorldRegistry {

    private Map<Integer, AbstractWorld> levels = new HashMap();

    public void registerLevel(int index, AbstractWorld abstractWorld) {
        levels.put(index, abstractWorld);
    }

    public AbstractWorld getLevel(int index) {
        return levels.get(index);
    }

    public int size() {
        return levels.size();
    }

    public final Iterable<AbstractWorld> values() {
        return Collections.unmodifiableCollection(levels.values());
    }
}
