package pe.edu.utp.poo.util.collection.iterator;

import java.util.LinkedList;
import java.util.SequencedCollection;

public class SequencedCollectionDemo {
    public static void main(String[] args) {
        // Se crea una colección secuencial de tipo String usando LinkedList
        SequencedCollection<String> nombres = new LinkedList<>();
        // Se agrega un elemento al inicio de la colección
        nombres.addFirst("Ana");
        // Se agrega un elemento al final de la colección
        nombres.addLast("Luis");
        // Se agrega otro elemento al final
        nombres.addLast("Carlos");

        // Se imprime el primer elemento de la colección
        System.out.println("Primero: " + nombres.getFirst()); // Ana
        // Se imprime el último elemento de la colección
        System.out.println("Último: " + nombres.getLast()); // Carlos
        // Se elimina el primer elemento ("Ana")
        nombres.removeFirst();

        // Se imprime la colección después de eliminar el primero
        System.out.println("Después de eliminar el primero:");
        for (String nombre : nombres) {
            System.out.println(nombre); // Luis, Carlos
        }

        // Se obtiene una vista invertida de la colección
        SequencedCollection<String> invertida = nombres.reversed();

        // Se imprime la colección invertida
        System.out.println("Colección invertida:");
        for (String nombre : invertida) {
            System.out.println(nombre); // Carlos, Luis
        }
    }
}
