package pe.edu.utp.poo.funcional;

import java.util.function.Function;

public class TestMain2 {
	// Lambda que recibe un número y retorna su cuadrado
	static Function<Integer, Integer> cuadrado = x -> x * x;

	public static void main(String[] args) {
		// Uso de la lambda
		int resultado = cuadrado.apply(5); // resultado = 25
		System.out.println(resultado);
	}
}
