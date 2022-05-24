/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Read;

import Controlador.Main;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerUsuario {
    private JLabel lTitulo;
    public JPanel jVerUsuarios;
    private JTextArea taVerUsuarios;
    private JButton bSalir;
    private JPanel jFoto;
    private JLabel lFoto;


    public VerUsuario() {
        /**
         * Metodo para llamar a insertar los usuarios.
         */
        taVerUsuarios.setText(Main.consultarUsuarios());
/**
 * Metodo para volver a la ventana del administrador.
 */
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.cerrarVentana();
                Main.ventanaAdministrador();
            }
        });
    }
}
