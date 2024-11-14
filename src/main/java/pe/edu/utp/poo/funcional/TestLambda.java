package pe.edu.utp.poo.funcional;

import java.util.List;

public class TestLambda {
	
	public static void main(String[] args) {
		List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6);

		// Filtrar números pares y mostrarlos en consola
		numeros.stream().filter(n -> n % 2 == 0) // Lambda para filtrar pares
				.forEach(n -> System.out.println(n)); // Lambda para imprimir cada número
	}
}
