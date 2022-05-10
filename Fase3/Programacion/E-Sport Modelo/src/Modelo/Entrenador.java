package Modelo;

public class Entrenador extends Persona{
    private int años_exp;

    public Entrenador() {
    }

    public Entrenador(String nombre, String telefono, int años_exp) {
        super(nombre, telefono);
        this.años_exp = años_exp;
    }

    public int getAños_exp() {
        return años_exp;
    }

    public void setAños_exp(int años_exp) {
        this.años_exp = años_exp;
    }

    @Override
    public String toString() {
        return "Datos del entrenador: \n" +
                "años_exp: \n" + años_exp +
                '\n';
    }
}
