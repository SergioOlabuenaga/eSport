/**
 * @author: Equipo4
 * @version: 1
 */
package Modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Jugador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_JUGADOR")
    private int idJugador;
    @Basic
    @Column(name = "ID_EQUIPO")
    private int idEquipo;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "NICKNAME")
    private String nickname;
    @Basic
    @Column(name = "SUELDO")
    private int sueldo;
    @Basic
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic
    @Column(name = "ROL")
    private String rol;


    /**
     * Asignar una id para el jugador.
     * @param idJugador: id del jugador a asignar.
     */
    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    /**
     * Asignar id del equipo del jugador
     * @param idEquipo: id del equippo donde juega.
     */
    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    /**
     * Obtener el nombre del jugador.
     * @return nombre: nombre del jugador a devolver.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asignar el nombre de un jugador.
     * @param nombre: nombre del jugador a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Asignar una nicname al jugador.
     * @param nickname: nickname que usara el jugador.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Obtener el sueldo del jugador.
     * @return sueldo: sueldo del jugador a devolver.
     */
    public int getSueldo() {
        return sueldo;
    }

    /**
     * Asignar un suedo a un jugador.
     * @param sueldo: sueldo del jugador a asignar (encima del SMI)
     */
    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Obtener el telefono de un jugador.
     * @return telefono: telefono del jugador a devolver.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Asignar el telefono a un jugador.
     * @param telefono: telefono a asignar.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtener el rol de un jugador.
     * @return rol: devuelve el rol del jugador.
     */
    public String getRol() {
        return rol;
    }

    /**
     * Asignar el rol del jugador
     * @param rol: rol del jugador a asignar.
     */
    public void setRol(String rol) {
        this.rol = rol;
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
        Jugador jugador = (Jugador) o;
        return idJugador == jugador.idJugador && sueldo == jugador.sueldo && Objects.equals(idEquipo, jugador.idEquipo) && Objects.equals(nombre, jugador.nombre) && Objects.equals(nickname, jugador.nickname) && Objects.equals(telefono, jugador.telefono) && Objects.equals(rol, jugador.rol);
    }
    /**
     * Mira si el objeto tiene los atributos rellenados.
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(idJugador, idEquipo, nombre, nickname, sueldo, telefono, rol);
    }

    @Override
    public String toString() {
        return nickname;
    }
}
