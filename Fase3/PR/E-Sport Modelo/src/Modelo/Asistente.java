package Modelo;

public class Asistente extends Persona{
    private String dercipcionFuncion;

    public Asistente() {
    }

    public Asistente(String nombre, String telefono, String dercipcion_funcion) {
        super(nombre, telefono);
        this.dercipcionFuncion = dercipcion_funcion;
    }

    public String getDercipcionFuncion() {
        return dercipcionFuncion;
    }

    public void setDercipcionFuncion(String dercipcionFuncion) {
        this.dercipcionFuncion = dercipcionFuncion;
    }

    @Override
    public String toString() {
        return "Datos del Asistente: \n" +
                "dercipcion_funcion: " + dercipcionFuncion + '\n';
    }
}
