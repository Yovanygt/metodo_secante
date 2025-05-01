package bloc_notas.secante;

import java.util.ArrayList;
import java.util.List;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MetodoSecante {
    public static double evaluarFuncion(String funcion, double x) throws Exception {
        try {
            Expression expresion = new ExpressionBuilder(funcion)
                    .variable("x")
                    .build()
                    .setVariable("x", x);
            return expresion.evaluate();
        } catch (Exception e) {
            throw new Exception("Error al evaluar la función: " + e.getMessage());
        }
    }

    public List<Iteracion> calcular(double x0, double x1, double tolerancia, int maxIteraciones, String funcion) {
        List<Iteracion> iteraciones = new ArrayList<>();
        double x2, error;
        int iteracion = 1;

        try {
            while (iteracion <= maxIteraciones) {
                double fx0 = evaluarFuncion(funcion, x0);
                double fx1 = evaluarFuncion(funcion, x1);

                if (fx1 == fx0) {
                    throw new Exception("f(x_n) = f(x_{n-1}), división por cero en el método de la secante.");
                }

                x2 = x1 - fx1 * (x1 - x0) / (fx1 - fx0);
                error = Math.abs(x2 - x1);

                iteraciones.add(new Iteracion(iteracion, x0, x1, fx0, fx1, x2, error));

                x0 = x1;
                x1 = x2;

                if (error < tolerancia) {
                    break;
                }

                iteracion++;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error durante el cálculo: " + e.getMessage());
        }

        return iteraciones;
    }
}