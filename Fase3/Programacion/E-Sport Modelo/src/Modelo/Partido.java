package Modelo;

import java.sql.Time;

public class Partido {
    private Time hora;
    private int puntos_local;
    private int puntos_visitante;

    private Equipo equipo_local;
    private Equipo equipo_visitante;

    public Partido() {
    }

    public Partido(Time hora, int puntos_local, int puntos_visitante, Equipo equipo_local, Equipo equipo_visitante) {
        this.hora = hora;
        this.puntos_local = puntos_local;
        this.puntos_visitante = puntos_visitante;
        this.equipo_local = equipo_local;
        this.equipo_visitante = equipo_visitante;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getPuntos_local() {
        return puntos_local;
    }

    public void setPuntos_local(int puntos_local) {
        this.puntos_local = puntos_local;
    }

    public int getPuntos_visitante() {
        return puntos_visitante;
    }

    public void setPuntos_visitante(int puntos_visitante) {
        this.puntos_visitante = puntos_visitante;
    }

    public Equipo getEquipo_local() {
        return equipo_local;
    }

    public void setEquipo_local(Equipo equipo_local) {
        this.equipo_local = equipo_local;
    }

    public Equipo getEquipo_visitante() {
        return equipo_visitante;
    }

    public void setEquipo_visitante(Equipo equipo_visitante) {
        this.equipo_visitante = equipo_visitante;
    }

    @Override
    public String toString() {
        return "Datos del partido: \n" +
                "Hora: " + hora +"\n" +
                "Puntos_local: " + puntos_local +"\n"+
                "Puntos_visitante: " + puntos_visitante+"\n"+
                "Equipo_local: " + equipo_local+"\n"+
                "Equipo_visitante: " + equipo_visitante+"\n";
    }
}
