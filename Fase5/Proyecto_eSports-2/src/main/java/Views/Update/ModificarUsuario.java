package Views.Update;

import Controlador.Main;
import Modelo.Jugador;
import Modelo.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModificarUsuario {
    public JPanel jModificarUsuario;
    private JLabel jlTitulo;
    private JButton bAceptar;
    private JButton bSalir;
    private JLabel jlNombre;
    private JPanel jContenido;
    private JPanel jBotones;
    private JComboBox cbUsuario;
    private JTextField tfContraseña;
    private JPasswordField tfNuevaContraseña;

    public ModificarUsuario() {
        ArrayList<Login> Usuario = Main.verNombreUsuarios();
        for (Login usu : Usuario) {
            cbUsuario.addItem(usu);
        }
/**
 * Al darle al boton aceptar actualiza el usuario.
 */
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.actializarUsuario(cbUsuario.getSelectedItem(),tfNuevaContraseña.getText());
            }
        });
        /**
         * Al darle al boton salir vuelve a la pantalla del administrador.
         */
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.cerrarVentana();
                Main.ventanaAdministrador();
            }
        });
        /**
         * Llenar los datos del usuario tras seleccionarlo en la combo box.
         */
        cbUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfContraseña.setText(Main.infoUsuario(cbUsuario.getSelectedItem()).getPass());
            }
        });
    }
}
