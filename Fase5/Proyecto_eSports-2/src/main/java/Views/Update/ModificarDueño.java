package Views.Update;

import Controlador.Main;
import Modelo.Dueno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModificarDueño {
    public JPanel jModificarDueño;
    private JLabel jlTitulo;
    private JLabel jlNombre;
    private JPanel jpContenido;
    private JPanel jpBotones;
    private JButton bAceptar;
    private JButton bSalir;
    private JComboBox cbDueno;
    private JTextField tfTlf;
    private JTextField tfEmpresa;

    public ModificarDueño(){
        //Lista dueño.
        ArrayList<Dueno> Dueno = Main.verNombreDuenos();
        for (Dueno due : Dueno) {
            cbDueno.addItem(due);
        }
        /**
         * Al darle al boton aceptar actualiza el dueño y refresca la pantalla.
         */
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.actializarDueno(cbDueno.getSelectedItem(),tfTlf.getText(),tfEmpresa.getText());
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
         * Llenar los datos del dueño tras seleccionarlo en la combo box.
         */
        cbDueno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfTlf.setText(Main.infoDueno(cbDueno.getSelectedItem()).getTelefono());
                tfEmpresa.setText(Main.infoDueno(cbDueno.getSelectedItem()).getNombreEmpresa());
            }
        });
    }

}
