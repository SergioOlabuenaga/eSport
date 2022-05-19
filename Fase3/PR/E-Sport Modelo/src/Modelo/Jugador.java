package Modelo;

public class Jugador extends Persona{
    private String nickname;
    private String rol;
    private int sueldo;

    public Jugador() {
    }

    public Jugador(String nombre, String telefono, String nickname, String rol, int sueldo) {
        super(nombre, telefono);
        this.nickname = nickname;
        this.rol = rol;
        this.sueldo = sueldo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Datos del jugador: \n"+
                "nickname: " + nickname + '\n' +
                "rol: " + rol + '\n' +
                "sueldo: " + sueldo +'\n';
    }
}
