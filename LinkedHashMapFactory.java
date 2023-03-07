public class LinkedHashMapFactory implements MapFactory  {
    public <K,V> Map<K,V> createMap(){
        return new LinkedHashMap<K,V>();
    }
}
