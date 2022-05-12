package Modelo;

import java.sql.Time;

public class Partido {
    private Time hora;
    private int puntosLocal;
    private int puntosVisitante;

    private Equipo equipoLocal;
    private Equipo equipoVisitante;

    public Partido() {
    }

    public Partido(Time hora, int puntos_local, int puntos_visitante, Equipo equipo_local, Equipo equipo_visitante) {
        this.hora = hora;
        this.puntosLocal = puntos_local;
        this.puntosVisitante = puntos_visitante;
        this.equipoLocal = equipo_local;
        this.equipoVisitante = equipo_visitante;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(int puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public int getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(int puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    @Override
    public String toString() {
        return "Datos del partido: \n" +
                "Hora: " + hora +"\n" +
                "Puntos_local: " + puntosLocal +"\n"+
                "Puntos_visitante: " + puntosVisitante +"\n"+
                "Equipo_local: " + equipoLocal +"\n"+
                "Equipo_visitante: " + equipoVisitante +"\n";
    }
}
