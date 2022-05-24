/**
 * @author: Equipo4
 * @version: 1
 */
package Modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Asistente {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ASISTENTE")
    private int idAsistente;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic
    @Column(name = "DESCRIPCION_FUNCION")
    private String descripcionFuncion;

    /**
     * Conseguir la id del asistente
     * @return idAsistente: Id del asistente que se devuelve.
     */
    public int getIdAsistente() {
        return idAsistente;
    }

    /**
     * Asignar un id de asistente.
     * @param idAsistente: Id del asistenque se se asigna.
     */
    public void setIdAsistente(int idAsistente) {
        this.idAsistente = idAsistente;
    }
    /**
     * Conseguir el nombre del asistente
     * @return nombre: Nombre del asistente que se devuelve.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asignar un nombre de asistente.
     * @param nombre: Nombre del asistenque se se asigna.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Conseguir el telefono del asistente
     * @return telefono: Telefono del asistente que se devuelve.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Asignar un telefono de asistente.
     * @param telefono: Telefono del asistentr que se asigna.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Conseguir la decripcion del asistente.
     * @return descripcionFuncion: Descripcion de funciones del asistente que se devuelve.
     */
    public String getDescripcionFuncion() {
        return descripcionFuncion;
    }

    /**
     * Asignar una descripcion del asistente.
     * @param descripcionFuncion: Telefono del asistente que se asigna.
     */
    public void setDescripcionFuncion(String descripcionFuncion) {
        this.descripcionFuncion = descripcionFuncion;
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
        Asistente asistente = (Asistente) o;
        return idAsistente == asistente.idAsistente && Objects.equals(nombre, asistente.nombre) && Objects.equals(telefono, asistente.telefono) && Objects.equals(descripcionFuncion, asistente.descripcionFuncion);
    }

    /**
     * Mira si el objeto tiene los atributos rellenados.
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(idAsistente, nombre, telefono, descripcionFuncion);
    }

    /**
     * Metodo para obtener el nombre como un string.
     * @return nombre: Devuelve el nombre
     */
    @Override
    public String toString() {
        return nombre;
    }
}
