/**
 * @author: Equipo4
 * @version: 1
 */
package Modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Equipo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_EQUIPO")
    private int idEquipo;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "ANO_CREACION")
    private int anoCreacion;
    @Basic
    @Column(name = "NACIONALIDAD")
    private String nacionalidad;
    @Basic
    @Column(name = "ID_DUENO")
    private int idDueno;
    @Basic
    @Column(name = "ID_ENTRENADOR")
    private int idEntrenador;
    @Basic
    @Column(name = "ID_ASISTENTE")
    private int idAsistente;




    /**
     * Obtener el id del equipo.
     * @return idEquipo: devuelve el id del equipo.
     */
    public int getIdEquipo(){return idEquipo;}
    /**
     * Asigna un id a un equipo.
     * @param idEquipo: id a asignar.
     */
    public void setIdEquipo(int idEquipo){this.idEquipo = idEquipo;}
    /**
     * Obtener el nombre del equipo.
     * @return nombre: devuelve el nombre del equipo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna un nombre a un equipo.
     * @param nombre: Nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtener el año de creacion del equipo.
     * @return anoCreacion: año de creacion a devolver.
     */
    public int getAnoCreacion() {
        return anoCreacion;
    }

    /**
     * Asignar en que año se creo el equipo.
     * @param anoCreacion: año de equipo a asignar.
     */
    public void setAnoCreacion(int anoCreacion) {
        this.anoCreacion = anoCreacion;
    }

    /**
     * Obtener la nacionalidad del equipo.
     * @return nacionalidad: nacionalidad a devolver.
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Asignar la nacionalidad de un equipo.
     * @param nacionalidad: nacinalidad a asignar.
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Asignar el id del dueño que lleva el equipo.
     * @param idDueno: id del dueño del equipo.
     */
    public void setIdDueno(int idDueno) {
        this.idDueno = idDueno;
    }

    /**
     * Asignar el id del entrenador que entrena el equipo.
     * @param idEntrenador: id del entrenador del equipo.
     */
    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    /**
     * Asignar la id de un posible asistente del equipo.
     * @param idAsistente: ide del asistente del equipo.
     */
    public void setIdAsistente(int idAsistente) {
        this.idAsistente = idAsistente;
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
        Equipo equipo = (Equipo) o;
        return idEquipo == equipo.idEquipo && anoCreacion == equipo.anoCreacion && idDueno == equipo.idDueno && idEntrenador == equipo.idEntrenador && Objects.equals(nombre, equipo.nombre) && Objects.equals(nacionalidad, equipo.nacionalidad) && Objects.equals(idAsistente, equipo.idAsistente);
    }
    /**
     * Mira si el objeto tiene los atributos rellenados.
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(idEquipo, nombre, anoCreacion, nacionalidad, idDueno, idEntrenador, idAsistente);
    }

    /**
     * Devolver un string del nombre del equipo.
     * @return nombre: nombre del equipo a devolver.
     */
    @Override
    public String toString() {
        return nombre;
    }
}
