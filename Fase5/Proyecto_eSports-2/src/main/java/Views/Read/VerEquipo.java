/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Read;

import Controlador.Main;

import javax.swing.*;

public class VerEquipo {
    public JPanel jVerEquipo;
    private JTextArea taEquipos;
    private JLabel jlEquipos;

    /**
     * Metodo para llamar a insertar los equipos
     */
    public VerEquipo() {
        taEquipos.setText(Main.consultarEquipos());
    }
}
