/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Delete;

import Controlador.Main;
import Modelo.Asistente;
import Modelo.Equipo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BorrarAsistente {
    public JPanel jBorrarAsistente;
    private JButton bAceptar;
    private JButton bSalir;
    private JLabel jlTitulo;
    private JPanel jBotones;
    private JPanel jContenido;
    private JLabel jlNombre;
    private JComboBox cbAsistente;

    public BorrarAsistente() {
        //Lista de asistentes
        ArrayList<Asistente> Asistente = Main.verNombreAsistentes();
        for (Asistente asis : Asistente) {
            cbAsistente.addItem(asis);
        }
        /**
         * A la hora de ejecutar el boton aceptar se borra un asistente con los datos obtenidos de la ventana.
         */
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.borrarAsistente(cbAsistente.getSelectedItem());
                Main.cerrarVentana();
                Main.ventanaEliminarAsistente();
            }
        });
        /**
         * A la hora de ejecutar el boton salir vuelve a la ventana del admistrador.
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
