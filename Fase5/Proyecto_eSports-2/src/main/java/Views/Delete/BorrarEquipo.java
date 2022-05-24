/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Delete;

import Controlador.Main;
import Modelo.Equipo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BorrarEquipo {
    public JPanel jEliminarEquipo;
    private JLabel lTitulo;
    private JPanel jContenido;
    private JPanel jBotones;
    private JButton bAceptar;
    private JButton bSalir;
    private JComboBox cbEquipo;
    private JLabel jlEquipo;

    public BorrarEquipo() {
        //Lista de equipos
        ArrayList<Equipo> Equipo = Main.verNombreEquipos();
        for (Equipo equ : Equipo) {
            cbEquipo.addItem(equ);
        }
        /**
         * A la hora de ejecutar el boton aceptar se borra un equipo con los datos obtenidos de la ventana.
         */
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.borrarEquipo((Equipo) cbEquipo.getSelectedItem());
                Main.cerrarVentana();
                Main.ventanaEliminarEquipo();
            }
        });
        /**
         * A la hora de ejecutar el boton aceptar se borra un equipo con los datos obtenidos de la ventana.
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
