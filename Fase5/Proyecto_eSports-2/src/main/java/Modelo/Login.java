/**
 * @author: Equipo4
 * @version: 1
 */
package Modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Login {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_LOGIN")
    private int idLogin;
    @Basic
    @Column(name = "USUARIO")
    private String usuario;
    @Basic
    @Column(name = "PASS")
    private String pass;
    @Basic
    @Column(name = "TIPO")
    private String tipo;

    /**
     * Obtener el usuario del login.
     * @return usuario a devolver.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Asignar un usuario al login
     * @param usuario: usuario a asignar.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtener la contraseña del usuario.
     * @return pass: contraseña a devolver.
     */
    public String getPass() {
        return pass;
    }

    /**
     * Asignar una contraseña al login.
     * @param pass: contraseña a asignar.
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Asignar el tipo de login que es (U usuario o A administrador).
     * @param tipo: tipo de login a asignar.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        Login login = (Login) o;
        return idLogin == login.idLogin && Objects.equals(usuario, login.usuario) && Objects.equals(pass, login.pass) && Objects.equals(tipo, login.tipo);
    }
    /**
     * Mira si el objeto tiene los atributos rellenados.
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(idLogin, usuario, pass, tipo);
    }

    /**
     * Devuelve un string del usuario.
     * @return usuario: usuario a devolver.
     */
    @Override
    public String toString() {
        return usuario;
    }
}
