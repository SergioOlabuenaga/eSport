/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Create;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearEntrenador {
    public JPanel jCrearEntrenador;
    private JTextField tfNombre;
    private JTextField tfTelefono;
    private JTextField tfAños;
    private JLabel jTitulo;
    private JLabel jlNombre;
    private JLabel jlTelefono;
    private JLabel jlAños;
    private JPanel jContenido;
    private JButton bAceptar;
    private JButton bSalir;
    private JPanel jBotones;

    public CrearEntrenador() {
        /**
         * A la hora de ejecutar el boton aceptar se crea un nuevo entrenador con los datos obtenidos de la ventana.
         */
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.generarEntrenador(tfNombre.getText(),tfTelefono.getText(), Integer.parseInt(tfAños.getText()));
                tfNombre.setText("");
                tfTelefono.setText("");
                tfAños.setText("");
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