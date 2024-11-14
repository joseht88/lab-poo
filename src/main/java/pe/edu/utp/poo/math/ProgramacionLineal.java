package pe.edu.utp.poo.math;

import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.NonNegativeConstraint;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.PointValuePair;

import java.util.ArrayList;
import java.util.Collection;

public class ProgramacionLineal {
    public static void main(String[] args) {
        // Definir la función objetivo: Z = 3x + 4y
        LinearObjectiveFunction funcionObjetivo = new LinearObjectiveFunction(new double[]{3, 4}, 0);

        // Crear una colección para almacenar las restricciones
        Collection<LinearConstraint> restricciones = new ArrayList<>();
        
        // Agregar restricciones
        restricciones.add(new LinearConstraint(new double[]{1, 2}, Relationship.LEQ, 14));  // x + 2y <= 14
        restricciones.add(new LinearConstraint(new double[]{3, -1}, Relationship.GEQ, 0));   // 3x - y >= 0
        restricciones.add(new LinearConstraint(new double[]{1, -1}, Relationship.LEQ, 2));   // x - y <= 2

        // Crear el solucionador de optimización
        SimplexSolver solver = new SimplexSolver();

        try {
            // Resolver el problema de optimización
            PointValuePair solucion = solver.optimize(
                funcionObjetivo,
                new LinearConstraintSet(restricciones),
                new NonNegativeConstraint(true)  // x, y >= 0
            );

            // Obtener los valores de x y y de la solución
            double x = solucion.getPoint()[0];
            double y = solucion.getPoint()[1];
            double valorMaximo = solucion.getValue();

            // Mostrar resultados
            System.out.println("Solución:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            System.out.println("Valor máximo de Z = " + valorMaximo);

        } catch (Exception e) {
            System.out.println("No se encontró una solución factible: " + e.getMessage());
        }
    }
}

