/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Delete;

import Controlador.Main;
import Modelo.Entrenador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BorrarEntrenador {
    public JPanel jBorrarEntrenador;
    private JLabel jlTitulo;
    private JButton bAceptar;
    private JButton bSalir;
    private JPanel jBotones;
    private JPanel jContenido;
    private JLabel jlNombre;
    private JComboBox cbEntrenador;

    public BorrarEntrenador() {
        //Lista de entrenadores
        ArrayList<Entrenador> Entrenador = Main.verNombreEntrenadores();
        for (Entrenador entre : Entrenador) {
            cbEntrenador.addItem(entre);
        }
/**
 * A la hora de ejecutar el boton salir vuelve ala ventana del admistrador.
 */
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.cerrarVentana();
                Main.ventanaAdministrador();
            }
        });
        /**
         * A la hora de ejecutar el boton aceptar se borra un entrenador con los datos obtenidos de la ventana.
         */
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.borrarEntrenador(cbEntrenador.getSelectedItem());
                Main.cerrarVentana();
                Main.ventanaEliminarEntrenador();
            }
        });
    }
}
