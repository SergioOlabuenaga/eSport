/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Read;

import Controlador.Main;

import javax.swing.*;

public class VerEntrenador {
    public JPanel jVerEntrenador;
    private JLabel jlEntrenador;
    private JTextArea taEntrenadores;

    /**
     * Metodo para llamar a insertar los enetrenadores.
     */
    public VerEntrenador(){
        taEntrenadores.setText(Main.consultarEntrenadores());
    }

}
