/**
 * @author: Equipo4
 * @version: 1
 */

package Views.Create;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrearAsistente {
    public JPanel jCrearAsistente;
    private JTextField tfNombre;
    private JTextField tfTelefono;
    private JTextField tfFuncion;
    private JLabel jTitulo;
    private JLabel jlNombre;
    private JLabel jlTelefono;
    private JLabel jlFuncion;
    private JPanel jContenido;
    private JButton bAceptar;
    private JButton bSalir;
    private JPanel jBotones;


    public CrearAsistente() {
        /**
         * A la hora de ejecutar el boton aceptar se crea un nuevo asistente con los datos obtenidos de la ventana.
         */
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Main.validarTelefono(tfTelefono.getText())) {
                Main.generarAsistente(tfNombre.getText(),tfTelefono.getText(),tfFuncion.getText());
                tfNombre.setText("");
                tfTelefono.setText("");
                tfFuncion.setText("");
                } else {
                    tfTelefono.setText("");
                }
            }
        });
        /**
         * A la hora de ejecutar el boton salir se cierra la ventana y vuelve a la pantalla dela dministrador.
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