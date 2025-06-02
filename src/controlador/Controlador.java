package controlador;

import modelo.ConcesionarioDAO;
import modelo.Pedido;
import vista.Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
   Redondo Alonso David
 */

public class Controlador {
    //Atributos
    private Vista vista;

    //Constructor (se le pasa la vista)
    public Controlador(Vista vista) {
        this.vista = vista;
        inicializarComboBoxes();    //metodo que carga los datos en todos los comboboxes.
        configurarEventos();        //metodo que prepara todos los eventos de la GUI: botones y list

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

        //Deshabilitar boton Dar de Baja
        vista.setBotonBajaEnabled(false);

        //HACER PEDIDO
        vista.getBotonPedido().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Costruimos objeto de Pedido con los datos seleccionados en los comboboxes
                String modelo = vista.getComboModelo().getSelectedItem().toString();
                String motor = vista.getComboMotor().getSelectedItem().toString();
                String color = vista.getComboColor().getSelectedItem().toString();
                int ruedas = (int) vista.getComboRuedas().getSelectedItem();
                int pilotoAutomatico;
                if ((boolean) vista.getComboPiloto().getSelectedItem()) {
                    pilotoAutomatico = 1;
                } else {
                    pilotoAutomatico = 0;
                }
                //Preguntar si desea realizar el pedido
                int respuesta = vista.muestraMensaje("¿Desea hacer un pedido con los datos seleccionados?");
                if (respuesta == JOptionPane.YES_OPTION) {
                    //El usuario aceptó | guardamos objeto en base de datos con el formato correcto
                    try {
                        ConcesionarioDAO.guardarPedido(new Pedido(modelo, motor, color, ruedas, pilotoAutomatico));
                    } catch (SQLException ex) {
                        vista.muestraAlerta("Error al guardar pedido");
                    }
                }
            }
        });
        //VISUALIZAR PEDIDOS
        vista.getBotonVisualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lammar a ConcesionarioDAO | traer datos
                try {
                    List<String> pedidos = ConcesionarioDAO.verPedidos();
                    vista.rellenarJlist(pedidos);
                    //Activo boton baja pedidos | si no esta vacío
                    vista.getBotonBaja().setEnabled(!pedidos.isEmpty());
                } catch (SQLException ex) {
                    vista.muestraAlerta("Error al visualizar los pedidos");
                }

            }
        });
        //BAJA PEDIDO
        vista.getBotonBaja().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Compruebo si hay elementos en el jlist
                int indice = vista.getIndicePedidoSeleccionado();
                if (indice == -1){
                    vista.muestraAlerta("No hay pedido seleccionado");
                    return;
                }

                ////Obtengo el valor seleccionado (pedido completo)
                String pedido = vista.getValorPedidoSeleccionado();

                //Divido el pedido en partes segun camposBD
                String[] partes = pedido.split(",");
                //En la primera parte (id: 1) me quedo solo con los numeros.
                String idSeleccionado = partes[0].replaceAll("\\D+", "");
                int idSelect = Integer.parseInt(idSeleccionado);
                //Pregunto por confirmacion para dar de baja
                int respuesta = vista.muestraMensaje("Desea dar de baja el pedido con indice " + idSelect);
                if (respuesta == JOptionPane.YES_OPTION) {
                    //El usuario aceptó | borramos la seleccion de la BD

                    //Llamamos a ConcesionarioDAO y eliminamos el pedido con id = idSeleccionado
                    try {
                        ConcesionarioDAO.borrarPedido(idSelect); //borrar pedido
                        // Actualizar Jlist tras borrar pedido
                        List<String> pedidos = ConcesionarioDAO.verPedidos();
                        vista.rellenarJlist(pedidos);
                        vista.setBotonBajaEnabled(!pedidos.isEmpty());
                    } catch (SQLException ex) {
                        vista.muestraAlerta("Error al borrar pedido");
                    }

                }
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
