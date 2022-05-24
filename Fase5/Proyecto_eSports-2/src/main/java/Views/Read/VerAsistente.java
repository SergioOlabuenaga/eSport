/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Read;

import Controlador.Main;

import javax.swing.*;

public class VerAsistente {
    public JPanel jVerAsistente;
    private JLabel jlTitulo;
    private JTextArea taAsistentes;

    /**
     * Metodo para llamar a insertar los asistentes
     */
    public VerAsistente(){
        taAsistentes.setText(Main.consultarAsistente());}
}
