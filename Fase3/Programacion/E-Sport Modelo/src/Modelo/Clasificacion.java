package Modelo;

import java.util.ArrayList;

public class Clasificacion {
    private int temporada;

    private ArrayList<Equipo> listaEquipos;

    public Clasificacion() {
    }

    public Clasificacion(int temporada, ArrayList<Equipo> listaEquipos) {
        this.temporada = temporada;
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

    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    @Override
    public String toString() {
        return "Datos de la clasificacion: \n" +
                "Temporada: " + temporada  +"\n" +
                "Lista Equipos: " + listaEquipos;
    }
}
