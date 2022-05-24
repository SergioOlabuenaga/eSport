package Views.Read;

import Controlador.Main;

import javax.swing.*;

public class VerDueño {
    public JPanel jVerDueño;
    private JLabel jlTitulo;
    private JTextArea taVerDuenos;

    public VerDueño(){
        taVerDuenos.setText(Main.consultarDueno());
    }

}
