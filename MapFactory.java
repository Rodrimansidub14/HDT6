import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapFactory {
    public <K,V> Map<K, V> createHashMap(){
        return new HashMap<K,V>();
    }

   public <K, V> Map<K,V> createLinkedHashMap() { 
    return new LinkedHashMap<K,V>();
    }
    
    public <K,V> Map<K,V> createTreeMap() {
        return new TreeMap<K,V>();
}
}
