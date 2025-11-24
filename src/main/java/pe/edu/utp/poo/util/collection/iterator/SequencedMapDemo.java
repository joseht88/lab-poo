package pe.edu.utp.poo.util.collection.iterator;

import java.util.*;

public class SequencedMapDemo {
    public static void main(String[] args) {
        // Se crea un mapa secuencial (ordenado) usando LinkedHashMap
        SequencedMap<Integer, String> map = new LinkedHashMap<>();

        // Se agregan pares clave-valor al mapa
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        // Se imprime la primera entrada del mapa (según orden de inserción)
        System.out.println("First Entry: " + map.firstEntry()); // 1=Apple

        // Se imprime la última entrada del mapa
        System.out.println("Last Entry: " + map.lastEntry());   // 3=Cherry

        // Se imprime el mapa en orden invertido
        System.out.println("Reversed Map:");
        map.reversed().forEach((k, v) -> System.out.println(k + " => " + v));
        // Salida: 3 => Cherry, 2 => Banana, 1 => Apple
    }
}
