/**
 * @author: Equipo4
 * @version: 1
 */
package Modelo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@IdClass(PartidoPK.class)
public class Partido {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PARTIDO")
    private int idPartido;
    @Basic
    @Column(name = "HORA")
    private Date hora;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_LOCAL")
    private short idLocal;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_VISITANTE")
    private short idVisitante;
    @Basic
    @Column(name = "PUNTOS_LOCAL")
    private Boolean puntosLocal;
    @Basic
    @Column(name = "PUNTOS_VISITANTE")
    private Boolean puntosVisitante;
    @Basic
    @Column(name = "ID_JORNADA")
    private short idJornada;

    /**
     * Obtener el id del partido.
     * @return idPartido: id del partido a devolver.
     */
    public int getIdPartido() {
        return idPartido;
    }

    /**
     * Asignar el id del partido.
     * @param idPartido: id del partido a asignar.
     */
    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    /**
     * Obtener la hora donde se juega el partido.
     * @return hora: la hora del aprtido a devolver.
     */
    public Date getHora() {
        return hora;
    }

    /**
     * Asignar la hora del partido.
     * @param hora: hora del partido a asignar.
     */
    public void setHora(Date hora) {
        this.hora = hora;
    }

    /**
     * Obtener el id del equipo local.
     * @return idLocal: el id del equipo local.
     */
    public short getIdLocal() {
        return idLocal;
    }

    /**
     *  Asignar el id del equipo local.
     * @param idLocal: Id del equipo local a asignar.
     */
    public void setIdLocal(short idLocal) {
        this.idLocal = idLocal;
    }
    /**
     * Obtener el id del equipo visitante.
     * @return idVisitante: el id del equipo visitante.
     */
    public short getIdVisitante() {
        return idVisitante;
    }
    /**
     *  Asignar el id del equipo visitante.
     * @param idVisitante: Id del equipo visitante a asignar.
     */
    public void setIdVisitante(short idVisitante) {
        this.idVisitante = idVisitante;
    }

    /**
     * Obtener los puntos del equipo local.
     * @return puntosLocal: los puntos del equipo local.
     */
    public Boolean getPuntosLocal() {
        return puntosLocal;
    }
    /**
     *  Asignar los puntos del equipo local.
     * @param puntosLocal: los puntos del equipo local a asignar.
     */
    public void setPuntosLocal(Boolean puntosLocal) {
        this.puntosLocal = puntosLocal;
    }
    /**
     * Obtener los puntos del equipo visitante.
     * @return puntosVisitante: los puntos del equipo visitante.
     */
    public Boolean getPuntosVisitante() {
        return puntosVisitante;
    }
    /**
     *  Asignar los puntos del equipo visitante.
     * @param puntosVisitante: los puntos del equipo visitante a asignar.
     */
    public void setPuntosVisitante(Boolean puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    /**
     * Obtener la id de la jornada.
     * @return idJornada: identificador de la jornada a devolver.
     */
    public short getIdJornada() {
        return idJornada;
    }
    /**
     * Asigna una id a la jornada
     * @param idJornada: id de la jornada a asignar.
     */
    public void setIdJornada(short idJornada) {
        this.idJornada = idJornada;
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
        Partido partido = (Partido) o;
        return idPartido == partido.idPartido && idLocal == partido.idLocal && idVisitante == partido.idVisitante && idJornada == partido.idJornada && Objects.equals(hora, partido.hora) && Objects.equals(puntosLocal, partido.puntosLocal) && Objects.equals(puntosVisitante, partido.puntosVisitante);
    }
    /**
     * Mira si el objeto tiene los atributos rellenados.
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(idPartido, hora, idLocal, idVisitante, puntosLocal, puntosVisitante, idJornada);
    }
}
