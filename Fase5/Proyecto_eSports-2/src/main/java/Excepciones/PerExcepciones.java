package Excepciones;

public class PerExcepciones extends Exception {
    private int tipo;

    /**
     * Obtener el numero de tipo de error.
     * @param tipo: el tipo de error a devolver.
     */
    public PerExcepciones(int tipo) {
        this.tipo = tipo;
    }

    /**
     * Dependiendo del tipo de error te saldra un texto u otro.
     * @return : vacio
     */
    public String getMessage() {

        switch (tipo) {

            case 1:
                return "Ningun campo puede estar vacío";
            //break;
            case 2:
                return "Formato código no válido";
            //break;
            case 3:
                return "Error con el Rol";
            //break;
            case 4:
                return "Error al introducir el nombre";
            //break;

            case 5:
                return "Error al introducir el nickname";
            //break;
            case 6:
                return "Error con el telefono";
            case 7:
                return "Error con el sueldo";
            case 8:
                return "Error con el Rol";

            default:
                return "";

        }
    }
}

