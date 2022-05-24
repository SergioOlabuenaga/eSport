/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Delete;

import Controlador.Main;
import Modelo.Equipo;
import Modelo.Jugador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BorrarJugador {
    public JPanel jBorrarJugador;
    private JLabel lTitulo;
    private JPanel jpContenido;
    private JPanel jpBotones;
    private JButton bAceptar;
    private JButton bSalir;
    private JLabel jlNombre;
    private JComboBox cbNickname;

    public BorrarJugador() {
        //Lita de jgadores
        ArrayList<Jugador> Jugador = Main.verNombreJugadores();
        for (Jugador jug : Jugador) {
            cbNickname.addItem(jug);
        }
        /**
         * A la hora de ejecutar el boton aceptar se borra un jugador con los datos obtenidos de la ventana.
         */
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.borrarJugador(cbNickname.getSelectedItem());
                Main.cerrarVentana();
                Main.ventanaEliminarJugador();
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