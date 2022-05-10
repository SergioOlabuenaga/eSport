package Modelo;

public class Usuario {
    private String nombre;

    public Usuario() {
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Funciones del controlador
    public void readJornada(){}
    public void readClasificacion(){}
}
