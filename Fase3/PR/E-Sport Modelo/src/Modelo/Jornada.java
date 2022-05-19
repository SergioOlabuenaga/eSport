package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class Jornada {
    private Date fecha;

    private ArrayList<Partido> listaPartidos;

    public Jornada() {
    }

    public Jornada(Date fecha, ArrayList<Partido> listaPartidos) {
        this.fecha = fecha;
        this.listaPartidos = listaPartidos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Partido> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(ArrayList<Partido> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }

    @Override
    public String toString() {
        return "Datos de la jornada: \n" +
                "Fecha: " + fecha +"\n" +
                "Lista Partidos: " + listaPartidos;
    }
}