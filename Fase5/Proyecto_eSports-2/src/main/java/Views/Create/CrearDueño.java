/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Create;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearDueño {
    private JLabel lTitulo;
    public JPanel jCrearDueño;
    private JTextField tfNombre;
    private JTextField tfTelefono;
    private JTextField tfEmpresa;
    private JLabel lNombre;
    private JLabel lTelefono;
    private JLabel lEmpresa;
    private JButton bCrear;
    private JButton bSalir;
    private JPanel jBotones;
    private JPanel jContenido;

    public CrearDueño() {
        /**
         * A la hora de ejecutar el boton aceptar se crea un nuevo dueño con los datos obtenidos de la ventana.
         */
        bCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.generarDueño(tfNombre.getText(),tfTelefono.getText(),tfEmpresa.getText());
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
