package Modelo;

import java.util.ArrayList;

public class Equipo {
    private String nombreE;
    private int año_creacion;
    private String nacionalidad;

    private ArrayList<Jugador> listaJugadores;
    private Entrenador entrenadorE;
    private Dueño dueñoE;
    private Asistente asistenteE;


    public Equipo() {
    }

    public Equipo(String nombreE, int año_creacion, String nacionalidad, ArrayList<Jugador> listaJugadores,
                  Entrenador entrenadorE, Dueño dueñoE, Asistente asistenteE) {
        this.nombreE = nombreE;
        this.año_creacion = año_creacion;
        this.nacionalidad = nacionalidad;
        this.listaJugadores = listaJugadores;
        this.entrenadorE = entrenadorE;
        this.dueñoE = dueñoE;
        this.asistenteE = asistenteE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public int getAño_creacion() {
        return año_creacion;
    }

    public void setAño_creacion(int año_creacion) {
        this.año_creacion = año_creacion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public Entrenador getEntrenadorE() {
        return entrenadorE;
    }

    public void setEntrenadorE(Entrenador entrenadorE) {
        this.entrenadorE = entrenadorE;
    }

    public Dueño getDueñoE() {
        return dueñoE;
    }

    public void setDueñoE(Dueño dueñoE) {
        this.dueñoE = dueñoE;
    }

    public Asistente getAsistenteE() {
        return asistenteE;
    }

    public void setAsistenteE(Asistente asistenteE) {
        this.asistenteE = asistenteE;
    }

    // Funcion del controlador
    public void ResultadoLocal(){}
    public void  ResultadoVissitante(){}


    @Override
    public String toString() {
        return "Datos del equipo: \n" +
                "Nombre Equipo: " + nombreE + '\n' +
                "Año_creacion: " + año_creacion + '\n' +
                "Nacionalidad: " + nacionalidad + '\n' +
                "Lista Jugadores: " + listaJugadores  + '\n'+
                "Entrenador Equipo: " + entrenadorE  + '\n'+
                "Dueño Equipo: " + dueñoE + '\n' +
                "Asistente Equipo: " + asistenteE;
    }
}
