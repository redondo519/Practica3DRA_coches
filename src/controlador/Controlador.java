package controlador;

import modelo.ConcesionarioDAO;
import modelo.Pedido;
import vista.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

/*
   Redondo Alonso David
 */

public class Controlador {
    //Atributos
    private Vista vista;

    //Constructor (se le pasa la vista)
    public Controlador(Vista vista) {
        this.vista = vista;
        inicializarComboBoxes(); //metodo que carga los datos en todos los comboboxes.
        configurarEventos();    //metodo que prepara todos los eventos de la GUI: botones y list
    }


    //Cargar los datos en todos los comboboxes.
    private void inicializarComboBoxes() {
        try{
            cargarModelo();
            cargarMotor();
            cargarColor();
            cargarRuedas();
            cargarPilotoAutomatico();

        } catch (SQLException e){
            vista.muestraAlerta("Error al cargar los datos iniciales"); //Muestra la alerta mediante JOptionPane.showMessageDialog
        }
    }


    //Preparar botones y jlist.
    private void configurarEventos() {

        //HACER PEDIDO
        vista.getBotonPedido().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String modelo = vista.getComboModelo().getSelectedItem().toString();
                String motor = vista.getComboMotor().getSelectedItem().toString();
                String color = vista.getComboColor().getSelectedItem().toString();
                int ruedas = (int) vista.getComboRuedas().getSelectedItem();
                boolean pilotoAutomatico = (boolean) vista.getComboPiloto().getSelectedItem();

                //Costruimos objeto de Pedido con los datos seleccionados en los comboboxes
                Pedido pedido = new Pedido(modelo, motor, color, ruedas, pilotoAutomatico);
            }
        });

    }



    //Metodos que llamamos al inicializarComboboxes()
    private void cargarModelo() throws SQLException{
        ArrayList<String> modelos = ConcesionarioDAO.getModelos();
        vista.setComboModelo(modelos);
    }

    private void cargarMotor() throws SQLException{
        ArrayList<String> motores = ConcesionarioDAO.getMotores();
        vista.setComboMotor(motores);
    }

    private void cargarColor() throws SQLException {
        ArrayList<String> colores = ConcesionarioDAO.getColores();
        vista.setComboColor(colores);
    }

    private void cargarRuedas() throws SQLException {
        ArrayList<Integer> ruedas = ConcesionarioDAO.getRuedas();
        vista.setComboRuedas(ruedas);
    }

    private void cargarPilotoAutomatico() throws SQLException {
        ArrayList<Boolean> pilotos = ConcesionarioDAO.getPiloto();
        vista.setComboPiloto(pilotos);
    }




}
