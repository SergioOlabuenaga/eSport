package Views.Update;
import Controlador.Main;
import Modelo.Equipo;
import Modelo.Jugador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

public class ModificarJugador {
    public JPanel jModificarJugador;
    private JLabel jlTitulo;
    private JLabel jlNombre;
    private JButton bAceptar;
    private JButton bSalir;
    private JComboBox cbNickname;
    private JComboBox cbEquipo;
    private JTextField tfNombre;
    private JTextField tfSueldo;
    private JTextField tfTlf;
    private JTextField tfRol;

    public ModificarJugador(){
        ArrayList<Jugador> Jugador = Main.verNombreJugadores();
        for (Jugador jug : Jugador) {
            cbNickname.addItem(jug);
        }

        ArrayList<Equipo> Equipo = Main.verNombreEquipos();
        for (Equipo equ : Equipo) {
            cbEquipo.addItem(equ);
        }
/**
 * Al darle al boton aceptar actualiza el jugador.
 */
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.actializarJugadores(cbNickname.getSelectedItem(),tfNombre.getText(),tfSueldo.getText(),tfRol.getText(),
                        tfTlf.getText(),cbEquipo.getSelectedItem());
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
         * Llenar los datos del jugador tras seleccionarlo en la combo box.
         */
        cbNickname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNombre.setText(Main.infoJugadores(cbNickname.getSelectedItem()).getNombre());
                tfTlf.setText(Main.infoJugadores(cbNickname.getSelectedItem()).getTelefono());
                tfSueldo.setText(String.valueOf(Main.infoJugadores(cbNickname.getSelectedItem()).getSueldo()));
                tfRol.setText(Main.infoJugadores(cbNickname.getSelectedItem()).getRol());
            }
        });
    }

}
