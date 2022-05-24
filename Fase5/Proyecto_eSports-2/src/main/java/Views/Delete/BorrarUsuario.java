/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Delete;

import Controlador.Main;
import Modelo.Asistente;
import Modelo.Login;
import org.hibernate.annotations.common.util.impl.Log;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BorrarUsuario {
    public JPanel jEliminarUsuario;
    private JLabel lTitulo;
    private JTextField tfNombre;
    private JLabel lNombre;
    private JPanel jContenido;
    private JPanel jBotones;
    private JButton bAceptar;
    private JButton bSalir;
    private JComboBox cbUsuarios;

    public BorrarUsuario() {
        //Lista usuarios
        ArrayList<Login> Login = Main.verNombreUsuarios();
        for (Login logine : Login) {
            cbUsuarios.addItem(logine);
        }

        /**
        * A la hora de ejecutar el boton aceptar se borra un usuario con los datos obtenidos de la ventana.
         */
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.borrarUsuario(cbUsuarios.getSelectedItem());
                Main.cerrarVentana();
                Main.ventanaEliminarUsuario();
            }
        });
        /**
         * A la hora de ejecutar el boton salir vuelve a la ventana del administrador.
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
