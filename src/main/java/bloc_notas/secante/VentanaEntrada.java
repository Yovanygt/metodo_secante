package bloc_notas.secante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEntrada {
    private JFrame frame;
    private JTextField txtFuncion, txtX0, txtX1, txtTolerancia, txtMaxIter;

    public VentanaEntrada() {
        frame = new JFrame("Método de la Secante - Ingreso de Datos");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(7, 2, 10, 10));

        frame.add(new JLabel("Función f(x):"));
        frame.add(new JLabel("Ej: x^2 + 3*x - 4, sin(x)"));

        frame.add(new JLabel("Ingrese f(x):"));
        txtFuncion = new JTextField("x^3 - x - 2");
        frame.add(txtFuncion);

        frame.add(new JLabel("Valor inicial x0:"));
        txtX0 = new JTextField("1");
        frame.add(txtX0);

        frame.add(new JLabel("Valor inicial x1:"));
        txtX1 = new JTextField("2");
        frame.add(txtX1);

        frame.add(new JLabel("Tolerancia:"));
        txtTolerancia = new JTextField("0.0001");
        frame.add(txtTolerancia);

        frame.add(new JLabel("Máximo de iteraciones:"));
        txtMaxIter = new JTextField();
        frame.add(txtMaxIter);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String funcion = txtFuncion.getText();
                    double x0 = Double.parseDouble(txtX0.getText());
                    double x1 = Double.parseDouble(txtX1.getText());
                    double tolerancia = Double.parseDouble(txtTolerancia.getText());
                    int maxIteraciones = Integer.parseInt(txtMaxIter.getText());

                    MetodoSecante metodo = new MetodoSecante();
                    java.util.List<Iteracion> iteraciones = metodo.calcular(x0, x1, tolerancia, maxIteraciones, funcion);
                    double raizAproximada = iteraciones.get(iteraciones.size() - 1).getXnp1();

                    new VentanaResultados(iteraciones, raizAproximada);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese valores numéricos válidos.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });
        frame.add(btnCalcular);

        frame.setVisible(true);
    }
}