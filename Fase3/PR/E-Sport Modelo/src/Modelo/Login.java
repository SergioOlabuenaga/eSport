package Modelo;

import java.util.ArrayList;

public class Login {
    private String Usuario;
    private String pass;
    private char tipo;

    private Usuario usuario;
    private Administrador admin;

    public Login() {
    }

    public Login(String usuario, String pass, char tipo, Modelo.Usuario usuario1, Administrador admin) {
        Usuario = usuario;
        this.pass = pass;
        this.tipo = tipo;
        this.usuario = usuario1;
        this.admin = admin;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(Modelo.Usuario usuario) {
        this.usuario = usuario;
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }


    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
}
