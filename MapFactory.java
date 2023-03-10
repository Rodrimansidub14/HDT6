import java.util.Map;

public interface MapFactory {
    public <K,V> Map<K, V> createMap();

}
