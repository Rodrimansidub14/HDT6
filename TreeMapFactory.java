import java.util.Map;

public class TreeMapFactory implements MapFactory {
    public <K,V> Map<K,V> createMap(){
        return new TreeMap<K,V>();
    }
}
