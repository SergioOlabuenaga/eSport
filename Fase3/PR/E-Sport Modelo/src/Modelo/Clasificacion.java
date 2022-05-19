package Modelo;

import java.util.ArrayList;

public class Clasificacion {
    private int temporada;
<<<<<<< HEAD:Fase3/Programacion/E-Sport Modelo/src/Modelo/Clasificacion.java
    
=======
    private int puntos;
>>>>>>> main:Fase3/PR/E-Sport Modelo/src/Modelo/Clasificacion.java

    private ArrayList<Equipo> listaEquipos;

    public Clasificacion() {
    }

    public Clasificacion(int temporada, int puntos, ArrayList<Equipo> listaEquipos) {
        this.temporada = temporada;
        this.puntos = puntos;
        this.listaEquipos = listaEquipos;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    @Override
    public String toString() {
        return "Datos de la clasificacion: \n" +
                "Temporada: " + temporada  +"\n" +
                "Lista Equipos: " + listaEquipos +"\n" +
                "Puntos: " +puntos ;
    }
}
