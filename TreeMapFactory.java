import java.util.Map;
import java.util.TreeMap;

public class TreeMapFactory implements MapFactory {
    public <K,V> Map<K,V> createMap(){
        return new TreeMap<K,V>();
    }
}
