package Modelo;

public class Asistente extends Persona{
    private String dercipcion_funcion;

    public Asistente() {
    }

    public Asistente(String nombre, String telefono, String dercipcion_funcion) {
        super(nombre, telefono);
        this.dercipcion_funcion = dercipcion_funcion;
    }

    public String getDercipcion_funcion() {
        return dercipcion_funcion;
    }

    public void setDercipcion_funcion(String dercipcion_funcion) {
        this.dercipcion_funcion = dercipcion_funcion;
    }

    @Override
    public String toString() {
        return "Datos del Asistente: \n" +
                "dercipcion_funcion: " + dercipcion_funcion + '\n';
    }
}
