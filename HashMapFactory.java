import java.util.Map;

public class HashMapFactory implements MapFactory{

    @Override
    public <K, V> Map<K, V> createMap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createMap'");
    }


   @override
    public <K,V> Map<K,V> createMap(){
        return new HashMao<K,V> ();
}
}
