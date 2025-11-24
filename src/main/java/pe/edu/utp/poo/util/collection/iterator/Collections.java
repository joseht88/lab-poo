package pe.edu.utp.poo.util.collection.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collections {
    public static void main(String[] args) {

        ArrayList<String> lista = new ArrayList<>();
        lista.add("Pedro");
        lista.add("David");
        lista.add("Miguel");
        lista.add("Antonio");
        lista.add("Pedro");

        Iterator<String> it = lista.iterator();
        //it.hasNext comprueba si hay un elemento siguiente
        while (it.hasNext()) {
            //avanza por la colección
            System.out.println(it.next());
        }

        /* Este bucle recorre todos los elementos de una colección llamada lista,
        que debe ser una lista de objetos tipo String.
        String nombre: variable que representa cada elemento de la lista en cada iteración. */
        for (String nombre : lista) {
            //imprime la variable nombre
            System.out.println(nombre);
        }

        //it.hasNext comprueba si hay un elemento siguiente
        while (it.hasNext()) {
            //avanza por la coleccióny asigna el valor
            String nombre = it.next();
            //comprueba si el valor es igual a David
            if (nombre.equals("David")) {
                //elimina el elemento en it.next()
                it.remove();
            }
        }

        //1. Crear una colección
        List<String> nombres = new ArrayList<>();
        //2. Agregar elementos
        nombres.add("Ana");
        nombres.add("Luis");
        //3. Acceder a elementos
        String primero = nombres.get(0); // "Ana"
        //4. Recorrer la colección
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
        //5. Modificar elementos
        nombres.set(1, "Carlos"); // Reemplaza "Luis" por "Carlos"
        //6. Eliminar elementos
        nombres.remove("Ana"); // Elimina por valor
        nombres.remove(0);  // Elimina por índice
        //7. Busca elementos
        boolean existe = nombres.contains("Carlos"); // true
        //8 Obtener tamaño
        int tamaño = nombres.size(); // Número de elementos
        //9. Vaciar la colección
        nombres.clear();
        //10. Verificar si esta vacía
        boolean vacía = nombres.isEmpty();

    }
}
