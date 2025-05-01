package bloc_notas.secante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaResultados {
    public VentanaResultados(List<Iteracion> iteraciones, double raizAproximada) {
        JFrame frame = new JFrame("Resultados del Método de la Secante");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        String[] columnas = {"Iteración", "x_{n-1}", "x_n", "f(x_{n-1})", "f(x_n)", "x_{n+1}", "Error"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modelo);

        for (Iteracion iter : iteraciones) {
            modelo.addRow(new Object[]{
                    iter.getNumero(),
                    String.format("%.4f", iter.getXnm1()),
                    String.format("%.4f", iter.getXn()),
                    String.format("%.4f", iter.getFxnm1()),
                    String.format("%.4f", iter.getFxn()),
                    String.format("%.4f", iter.getXnp1()),
                    String.format("%.4f", iter.getError())
            });
        }

        JScrollPane scrollPane = new JScrollPane(tabla);
        frame.add(scrollPane, BorderLayout.CENTER);

        JLabel lblRaiz = new JLabel("Raíz aproximada: " + String.format("%.4f", raizAproximada));
        frame.add(lblRaiz, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}