package pe.edu.utp.poo.funcional;

public class Calculadora {
	public int calcular(int a, int b, Operacion operacion) {
		return operacion.ejecutar(a, b);
	}
}
