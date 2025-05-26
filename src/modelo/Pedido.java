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

    //Constructor sin id para agregar pedido a BD
    public Pedido(String modelo, String motor, String color, int ruedas, boolean pilotoAutomatico) {
        this.modelo = modelo;
        this.motor = motor;
        this.color = color;
        this.ruedas = ruedas;
        this.pilotoAutomatico = pilotoAutomatico;
    }
}
