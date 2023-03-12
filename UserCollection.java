
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class UserCollection {
    private final Map<String, Integer> collection;

    public UserCollection() {
        this.collection = new HashMap<>();
    }

    public void addCard(String name) {
        collection.merge(name, 1, Integer::sum);
    }

    public void removeCard(String name) {
        collection.computeIfPresent(name, (k, v) -> v > 1 ? v - 1 : null);
    }

    public int getCount(String name) {
        return collection.getOrDefault(name, 0);
    }

    public Map<String, Integer> getCollection() {
        return collection;
    }
}


