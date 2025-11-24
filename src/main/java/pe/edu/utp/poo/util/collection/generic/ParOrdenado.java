package pe.edu.utp.poo.util.collection.generic;

public class ParOrdenado<K, V> implements Par<K, V> {

    private K key;
    private V value;

    public ParOrdenado(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }
}
