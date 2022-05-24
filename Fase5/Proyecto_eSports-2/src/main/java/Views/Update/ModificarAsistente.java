package Views.Update;

import Controlador.Main;
import Modelo.Asistente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModificarAsistente {
    public JPanel jModificarAsistente;
    private JLabel jlTitulo;
    private JPanel jpContenido;
    private JLabel jlNombre;
    private JComboBox cbAsistente;
    private JTextField tfTelefono;
    private JButton bAceptar;
    private JButton bSalir;
    private JTextField tfDescripcion;

    public ModificarAsistente(){
        //Lista de los asistentes
        ArrayList<Asistente> Asistente = Main.verNombreAsistentes();
        for (Asistente asis : Asistente) {
            cbAsistente.addItem(asis);
        }


        /**
         * Al darle al boton aceptar actualiza el asistente y refresca la pantalla.
         */
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.actializarAsistente(cbAsistente.getSelectedItem(),tfTelefono.getText(),tfDescripcion.getText());
                Main.cerrarVentana();
                Main.ventanaModificarAsistente();
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
         * Llenar los datos del asisten tras seleccionarlo en la combo box.
         */
        cbAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfTelefono.setText(Main.infoAsistente(cbAsistente.getSelectedItem()).getTelefono());
                tfDescripcion.setText(Main.infoAsistente(cbAsistente.getSelectedItem()).getDescripcionFuncion());
            }
        });
    }

}
