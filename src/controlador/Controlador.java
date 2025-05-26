package controlador;

import modelo.ConcesionarioDAO;
import vista.Vista;

import java.sql.SQLException;
import java.util.ArrayList;

/*
   Redondo Alonso David
 */

public class Controlador {
    private Vista vista;

    public Controlador(Vista vista) {
        this.vista = vista;
        inicializarComboBoxes();
        configurarEventos();

    }



    private void inicializarComboBoxes() {
        try{
            cargarModelo();
            cargarMotor();
            cargarColor();
            cargarRuedas();
            cargarPilotoAutomatico();

        } catch (SQLException e){
            vista.muestraAlerta("Error al cargar los datos iniciales");
        }
    }


    private void configurarEventos() {

    }

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
