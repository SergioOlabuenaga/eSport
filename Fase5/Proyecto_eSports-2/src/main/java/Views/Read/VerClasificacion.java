package Views.Read;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerClasificacion {
    public JPanel jVerClasificacion;
    private JTextArea tfVerClasificacion;
    private JLabel lTitulo;
    private JButton bSalir;


    public VerClasificacion(){
        tfVerClasificacion.setText(Main.consultarClasificacion());
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Main.tipoUsuario.toLowerCase().equals("u")) {
                    Main.cerrarVentana();
                    Main.ventanaUsuario();
                } else {
                    Main.cerrarVentana();
                    Main.ventanaAdministrador();
                }
            }
        });
    }

}
