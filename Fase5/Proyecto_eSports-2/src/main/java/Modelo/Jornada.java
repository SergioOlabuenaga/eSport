/**
 * @author: Equipo4
 * @version: 1
 */
package Modelo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Jornada {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_JORNADA")
    private int idJornada;
    @Basic
    @Column(name = "FECHA")
    private Date fecha;

    /**
     * Obtener la id de la jornada.
     * @return idJornada: identificador de la jornada a devolver.
     */
    public int getIdJornada() {
        return idJornada;
    }

    /**
     * Asigna una id a la jornada
     * @param idJornada: id de la jornada a asignar.
     */
    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    /**
     * Obtener la fecha de la jornada.
     * @return fecha: devulve la fecha de la jornada.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Asignar una fecha para la jornada.
     * @param fecha: fecha de la jornada a asignar.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        Jornada jornada = (Jornada) o;
        return idJornada == jornada.idJornada && Objects.equals(fecha, jornada.fecha);
    }
    /**
     * Mira si el objeto tiene los atributos rellenados.
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(idJornada, fecha);
    }
}
