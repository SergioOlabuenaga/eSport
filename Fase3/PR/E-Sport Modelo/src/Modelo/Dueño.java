package Modelo;

public class Dueño extends Persona{
    private String nombre_empresa;

    public Dueño() {
    }

    public Dueño(String nombre, String telefono, String nombre_empresa) {
        super(nombre, telefono);
        this.nombre_empresa = nombre_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    @Override
    public String toString() {
        return "Datos del dueño: \n" +
                "nombre_empresa: \n" + nombre_empresa + '\n';
    }
}
