/**
 * @author: Equipo4
 * @version: 1
 */
package Modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Entrenador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ENTRENADOR")
    private int idEntrenador;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic
    @Column(name = "ANOS_EXP")
    private int anosExp;

    /**
     * Obtener el id del entrenador.
     * @return idEntrenador: Devuelve el id del entrenador.
     */
    public int getIdEntrenador() {
        return idEntrenador;
    }

    /**
     * Asignar un id a un entrenador.
     * @param idEntrenador: id del entrenador a asignar.
     */
    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }
    /**
     * Obtener el nombre del entrenador.
     * @return nombre: nombre de entrenador a devolver.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Asignar un nombre al entrenador.
     * @param nombre: nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtener el telefono del entrenador.
     * @return telefono: devuelve el telefono del entrenador.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Asignar un telefono al entrenador.
     * @param telefono: telefono a asignar.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtener los años de experiencia de un entrenador
     * @return anosExp: años de experiencia a devolver.
     */
    public int getAnosExp() {
        return anosExp;
    }

    /**
     * Asignar los años de experiencia de un entrenador.
     * @param anosExp: años de experiencia a asignar.
     */
    public void setAnosExp(int anosExp) {
        this.anosExp = anosExp;
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
        Entrenador that = (Entrenador) o;
        return idEntrenador == that.idEntrenador && Objects.equals(nombre, that.nombre) && Objects.equals(telefono, that.telefono) && Objects.equals(anosExp, that.anosExp);
    }
    /**
     * Mira si el objeto tiene los atributos rellenados.
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(idEntrenador, nombre, telefono, anosExp);
    }

    /**
     * Devuelve el nombre del entrenador en string.
     * @return nombre: devuelve el nombre del entrenador.
     */
    @Override
    public String toString() {
        return nombre;
    }
}
