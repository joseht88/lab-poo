package pe.edu.utp.poo.funcional;

public class TestMain {
	
	public static void main(String[] args) {
		Calculadora calculadora = new Calculadora();

		// Expresión lambda para la suma
		Operacion suma = (a, b) -> a + b;
		int resultadoSuma = calculadora.calcular(5, 3, suma);
		System.out.println("Suma: " + resultadoSuma); // Salida: Suma: 8

		// Expresión lambda para la multiplicación
		Operacion multiplicacion = (a, b) -> a * b;
		int resultadoMultiplicacion = calculadora.calcular(5, 3, multiplicacion);
		System.out.println("Multiplicación: " + resultadoMultiplicacion); // Salida: Multiplicación: 15
	}
}
