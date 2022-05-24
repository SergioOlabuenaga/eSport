/**
 * @author: Equipo4
 * @version: 1
 */
package Modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Dueno {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_DUENO")
    private int idDueno;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic
    @Column(name = "NOMBRE_EMPRESA")
    private String nombreEmpresa;

    /**
     * Obtiene el id del dueño.
     * @return idDueno: id del dueño a devolver
     */
    public int getIdDueno() {
        return idDueno;
    }

    /**
     * Asignar una id a un dueño.
     * @param idDueno: id del dueño a asignar.
     */
    public void setIdDueno(int idDueno) {
        this.idDueno = idDueno;
    }

    /**
     * Obtener el nombre del dueño.
     * @return nombre: nombre de dueño a devolver.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asignar un nombre al dueño
     * @param nombre: nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtener el telefono del dueño.
     * @return telefono: devuelve el telefono del dueño.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Asignar un telefono a un dueño.
     * @param telefono: telefono a asignar a un dueño.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtener el nombre de la empresa del dueño.
     * @return nombreEmpresa: nombre de la empresa a devolver.
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * Asignar el nombre de la empresa de un dueño.
     * @param nombreEmpresa: nombre de la empresa a asignar.
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
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
        Dueno dueno = (Dueno) o;
        return idDueno == dueno.idDueno && Objects.equals(nombre, dueno.nombre) && Objects.equals(telefono, dueno.telefono) && Objects.equals(nombreEmpresa, dueno.nombreEmpresa);
    }
    /**
     * Mira si el objeto tiene los atributos rellenados.
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(idDueno, nombre, telefono, nombreEmpresa);
    }

    /**
     * Devuelve en un string el nombre del dueño.
     * @return nombre: nombre del dueño a devolver.
     */
    @Override
    public String toString() {
        return nombre;
    }
}
