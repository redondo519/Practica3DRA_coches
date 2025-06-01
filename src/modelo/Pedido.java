package modelo;

/*
   Redondo Alonso David
 */


public class Pedido {   //Clase que guarda objetos para cada construccion de pedido mediante selecciones de combobox
    //Atributos del Pedido
    private int id;
    private String modelo;
    private String motor;
    private String color;
    private int ruedas;
    private boolean pilotoAutomatico;


    //Constructor con todos sus atributos
    public Pedido(int id, String modelo, String motor, String color, int ruedas, boolean pilotoAutomatico) {
        this.id = id;
        this.modelo = modelo;
        this.motor = motor;
        this.color = color;
        this.ruedas = ruedas;
        this.pilotoAutomatico = pilotoAutomatico;
    }

    //Constructor para agregar pedido a BD: Sin id, y pilotoAutomatico es un INT
    public Pedido(String modelo, String motor, String color, int ruedas, int pilotoAutomatico) {
        this.modelo = modelo;
        this.motor = motor;
        this.color = color;
        this.ruedas = ruedas;
        this.pilotoAutomatico = (pilotoAutomatico == 1);
    }

    //get


    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMotor() {
        return motor;
    }

    public String getColor() {
        return color;
    }

    public int getRuedas() {
        return ruedas;
    }

    public int getPilotoAutomatico() {
        if (pilotoAutomatico) {
            return 1;
        }else {
            return 0;
        }
    }
}
