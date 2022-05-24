package Views.Update;

import Controlador.Main;
import Modelo.Asistente;
import Modelo.Dueno;
import Modelo.Entrenador;
import Modelo.Equipo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModificarEquipo {
    public JPanel jModificarEquipo;
    private JLabel jlTitulo;
    private JLabel jlNombre;
    private JButton bAceptar;
    private JButton bSalir;
    private JPanel jBotones;
    private JPanel jContenido;
    private JComboBox cbEquipo;
    private JTextField tfAno;
    private JTextField tfNacion;
    private JComboBox cbDueno;
    private JComboBox cbEntrenador;
    private JComboBox cbAsistente;
    private JLabel lAsistente;

    public ModificarEquipo(){

        ArrayList<Equipo> Equipo = Main.verNombreEquipos();
        for (Equipo equ : Equipo) {
            cbEquipo.addItem(equ);
        }

        ArrayList<Dueno> Dueno = Main.verNombreDuenos();
        for (Dueno due : Dueno) {
            cbDueno.addItem(due);
        }

        ArrayList<Asistente> Asistente = Main.verNombreAsistentes();
        for (Asistente asis : Asistente) {
            cbAsistente.addItem(asis);
        }

        ArrayList<Entrenador> Entrenador = Main.verNombreEntrenadores();
        for (Entrenador entre : Entrenador) {
            cbEntrenador.addItem(entre);
        }
        /**
         * Al darle al boton aceptar actualiza el equipio.
         */
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.actializarEquipos(cbEquipo.getSelectedItem(),tfAno.getText(),
                        tfNacion.getText(),cbDueno.getSelectedItem(),cbEntrenador.getSelectedItem(),cbAsistente.getSelectedItem());
            }
        });
        /**
         * Llenar los datos del equipo tras seleccionarlo en la combo box.
         */
        cbEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfAno.setText(String.valueOf(Main.infoEquipo(cbEquipo.getSelectedItem()).getAnoCreacion()));
                tfNacion.setText(Main.infoEquipo(cbEquipo.getSelectedItem()).getNacionalidad());
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
    }

}
