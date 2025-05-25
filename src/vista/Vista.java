package vista;

import javax.swing.*;
import java.util.ArrayList;

public class Vista extends JFrame {
    private JLabel Titulo;
    private JPanel Panel1;
    private JLabel Modelo;
    private JComboBox comboModelo;
    private JButton botonVisualizar;
    private JLabel Motor;
    private JComboBox comboMotor;
    private JLabel Color;
    private JComboBox comboColor;
    private JLabel Ruedas;
    private JComboBox comboRuedas;
    private JLabel PilotoAutomatico;
    private JComboBox comboPiloto;
    private JButton botonPedido;
    private JButton botonSeleccionado;
    private JList jList;


    public Vista() {
        JFrame frame = new JFrame("Concesionario");
        frame.setContentPane(Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public JComboBox<String> getComboModelo() {
        return comboModelo;
    }

    public JComboBox<String> getComboMotor() {
        return comboMotor;
    }

    public JComboBox<String> getComboColor() {
        return comboColor;
    }

    public JComboBox<String> getComboRuedas() {
        return comboRuedas;
    }

    public JComboBox<String> getComboPiloto() {
        return comboPiloto;
    }



    public void setComboModelo(ArrayList<String> modelo) {
        comboModelo.removeAllItems(); // Limpia el combobox antes de llenarlo
        for (String s : modelo) {
            comboModelo.addItem(s);
        }
    }

    public void setComboMotor(ArrayList<String> motor) {
        comboMotor.removeAllItems();
        for (String s : motor) {
            comboMotor.addItem(s);
        }
    }


    public void setComboColor(ArrayList<String> color) {
        comboColor.removeAllItems();
        for (String s : color) {
            comboColor.addItem(s);
        }
    }
    public void setComboRuedas(ArrayList<Integer> ruedas) {
        comboRuedas.removeAllItems();
        for (Integer s : ruedas) {
            comboRuedas.addItem(s);
        }
    }

    public void setComboPiloto(boolean piloto) {
        comboPiloto.removeAllItems();
        comboPiloto.addItem("False");
        comboPiloto.addItem("True");
    }







    public void muestraAlerta(String alerta) {
        JOptionPane.showMessageDialog(
                Panel1,
                alerta,
                "Alerta",
                JOptionPane.WARNING_MESSAGE
        );
    }
}

