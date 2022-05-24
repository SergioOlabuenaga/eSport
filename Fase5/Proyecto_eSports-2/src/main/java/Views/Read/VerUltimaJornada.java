package Views.Read;

import Controlador.Main;
import javax.swing.*;

public class VerUltimaJornada {
    public JPanel jVerUltimaJornada;
    private JTextArea taUltimaJornada;
    private JLabel lTitulo;

    public VerUltimaJornada() {
        taUltimaJornada.setText(Main.consultarUltimaJornada());
    }
}