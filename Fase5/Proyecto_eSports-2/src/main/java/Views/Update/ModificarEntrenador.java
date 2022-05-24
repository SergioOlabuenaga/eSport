package Views.Update;

import Controlador.Main;
import Modelo.Entrenador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModificarEntrenador {
    public JPanel jModificarEntrenador;
    private JLabel jlTitulo;
    private JButton bAceptar;
    private JButton bSalir;
    private JLabel jlNombre;
    private JPanel jContenido;
    private JPanel jBotones;
    private JComboBox cbEntrenador;
    private JTextField tfTelefono;
    private JTextField tfAños;
    private JComboBox cbEqipo;

    public ModificarEntrenador() {
        ArrayList<Entrenador> Entrenador = Main.verNombreEntrenadores();
        for (Entrenador entre : Entrenador) {
            cbEntrenador.addItem(entre);
        }
/**
 * Al darle al boton aceptar actualiza el entrenador y refresca la pantalla.
 */
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.actializarEntrenadores(cbEntrenador.getSelectedItem(),tfTelefono.getText(), Integer.parseInt(tfAños.getText()));
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
         * Llenar los datos del entrenador tras seleccionarlo en la combo box.
         */
        cbEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfTelefono.setText(Main.infoEntrenadores(cbEntrenador.getSelectedItem()).getTelefono());
                tfAños.setText(String.valueOf(Main.infoEntrenadores(cbEntrenador.getSelectedItem()).getAnosExp()));
            }
        });
    }
}
