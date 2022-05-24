/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Read;

import Controlador.Main;
import Modelo.Equipo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VerJugador {
    public JPanel jVerJugadores;
    private JLabel lTitulo;
    private JTextArea taDatosJugadores;
    private JComboBox<Equipo> cbEquipos;
    private JLabel lImagen;
    private JButton bSalir;
    private JPanel jDatos;
    private JPanel jImagen;
    private JPanel jBoton;
    private JPanel jTitulo;

    public VerJugador(){
        // taDatosJugadores.setText(Main.consultarJugadores());
        ArrayList<Equipo> Equipos = Main.verNombreEquipos();
        for (Equipo equipo : Equipos) {
            cbEquipos.addItem(equipo);
        }
/**
 * Metodo para meter los equipos en una combo box.
 */
        cbEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taDatosJugadores.setText("");
                taDatosJugadores.setText(Main.consultarJugadores((Equipo) cbEquipos.getSelectedItem()));
            }
        });
        /**
         * Metodo para volver a la ventana de administrador.
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
