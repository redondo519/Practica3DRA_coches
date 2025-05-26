package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
   Redondo Alonso David
 */

public class ConexionBD {

    private static Connection conexion;
    private static final String URL = "jdbc:mysql://localhost:3306/finalcoches";
    private static final String USUARIO = "root";
    private static final String PASSWORD = ""; //Modificar

    public static Connection getConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        }
        return conexion;
    }

}


