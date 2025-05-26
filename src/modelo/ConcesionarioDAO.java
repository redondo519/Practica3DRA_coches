package modelo;

import java.sql.*;
import java.util.ArrayList;

/*
   Redondo Alonso David
 */

public class ConcesionarioDAO {

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
}
