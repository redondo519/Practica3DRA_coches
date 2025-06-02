package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
   Redondo Alonso David
 */

public class ConcesionarioDAO {

    //obtener de la BD las opciones para modelo
    public static ArrayList<String> getModelos() throws SQLException {
        Connection con = ConexionBD.getConexion();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select modelo from opcionesmodelo");
        ArrayList<String> modelos = new ArrayList<>();
        while (rs.next()) {
            modelos.add(rs.getString(1));
        }
        return modelos;
    }


    //obtener de la BD las opciones para motor
    public static ArrayList<String> getMotores() throws SQLException {

        Connection con = ConexionBD.getConexion();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select motor from opcionesmotor");
        ArrayList<String> motores = new ArrayList<>();
        while (rs.next()) {
            motores.add(rs.getString(1));
        }
        return motores;

    }

    //obtener de la BD las opciones para color
    public static ArrayList<String> getColores() throws SQLException {
        Connection con = ConexionBD.getConexion();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select color from opcionescolor");
        ArrayList<String> colores = new ArrayList<>();
        while (rs.next()) {
            colores.add(rs.getString(1));
        }
        return colores;
    }

    //obtener de la BD las opciones para ruedas
    public static ArrayList<Integer> getRuedas() throws SQLException {
        Connection con = ConexionBD.getConexion();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select ruedas from opcionesruedas");
        ArrayList<Integer> ruedas = new ArrayList<>();
        while (rs.next()) {
            ruedas.add(rs.getInt(1));
        }
        return ruedas;
    }

    //obtener de la BD las opciones para pilotoAutomatico
    public static ArrayList<Boolean> getPiloto() throws SQLException {
        Connection con = ConexionBD.getConexion();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT pilotoAutomatico FROM opcionespilotoautomatico");
        ArrayList<Boolean> pilotos = new ArrayList<>();
        while (rs.next()) {
            pilotos.add(rs.getBoolean(1));
        }
        return pilotos;
    }

    //Insertar pedido en BD
    public static void guardarPedido(Pedido pedido) throws SQLException {
        Connection con = ConexionBD.getConexion();
        Statement st = con.createStatement();
        PreparedStatement ps = con.prepareStatement("INSERT INTO pedidos (modelo,motor,color,ruedas,pilotoAutomatico) VALUES (?,?,?,?,?)");
        ps.setString(1, pedido.getModelo());
        ps.setString(2, pedido.getMotor());
        ps.setString(3, pedido.getColor());
        ps.setInt(4, pedido.getRuedas());
        ps.setInt(5, pedido.getPilotoAutomatico());
        ps.executeUpdate();
        ps.close();
    }

    //Mostrar los pedidos de la BD
    public static List<String> verPedidos() throws SQLException {
        List<String> pedidos = new ArrayList<>();
        Connection con = ConexionBD.getConexion();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM pedidos");
        while (rs.next()) {
            String p = rs.getString(1) + "," + rs.getString(2) +
                    "," + rs.getString(3) + "," + rs.getString(4) + "," +
                    rs.getString(5) + "," + rs.getString(6
            );
            pedidos.add(p);
        }
        if (pedidos.isEmpty()) {
            pedidos.add("No hay pedidos a visualizar");
        }
        return pedidos;
    }

    //Borrar pedido de la BD
    public static void borrarPedido(int idSelect) throws SQLException {
        Connection con = ConexionBD.getConexion();
        Statement st = con.createStatement();
        PreparedStatement ps = con.prepareStatement("DELETE FROM pedidos WHERE id = ?");
        ps.setInt(1, idSelect);
        ps.executeUpdate();
        ps.close();
    }
}
