package Main;

import controlador.Controlador;
import vista.Vista;

/*
   Redondo Alonso David
 */
public class Main {
    public static void main(String[] args) {

        //Antes de ejecutar comprobar campo PASSWORD de ConexionBD



        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista);

    }
}
