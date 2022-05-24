/**
 * @author: Equipo4
 * @version: 1
 */
package Modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Clasificacion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CLASIFICACION")
    private int idClasificacion;
    @Basic
    @Column(name = "ID_EQUIPO")
    private int idEquipo;
    @Basic
    @Column(name = "PUNTOS")
    private int puntos;
    @Basic
    @Column(name = "TEMPORADA")
    private int temporada;

    /**
     * Obtener la id de la clasificacion.
     * @return idClasificacion: Id de la calisficacion a devolver.
     */
    public int getIdClasificacion() {
        return idClasificacion;
    }

    /**
     * Asignar una id de clasificacion.
     * @param idClasificacion: id de clasificacion a poner.
     */
    public void setIdClasificacion(int idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    /**
     * Obtener el id del equipo.
     * @return idEquipo: id del equipo a obetner.
     */
    public int getIdEquipo() {
        return idEquipo;
    }

    /**
     * Asignar el id de equipo.
     * @param idEquipo: Id del equipo a introducir.
     */
    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    /**
     * obtener los puntos de un equipo.
     * @return puntos: los puntos a obtener.
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Asignar los punto de un equipo
     * @param puntos: puntos del equipo a introducir
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Obtener la temporada que se juega.
     * @return temporada: temporda a obtener.
     */
    public int getTemporada() {
        return temporada;
    }

    /**
     * Asignar la temporada en la que se juega.
     * @param temporada: Temporada que se asigna a la clasificacion.
     */
    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    /**
     *
     * @param o:
     * @return a
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clasificacion that = (Clasificacion) o;
        return idClasificacion == that.idClasificacion && Objects.equals(idEquipo, that.idEquipo) && Objects.equals(puntos, that.puntos) && Objects.equals(temporada, that.temporada);
    }

    /**
     * Mira si el objeto tiene los atributos rellenados.
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(idClasificacion, idEquipo, puntos, temporada);
    }
}
