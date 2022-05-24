/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Delete;

import Controlador.Main;
import Modelo.Dueno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BorrarDueño {
    public JPanel jBorrarDueño;
    private JLabel jlTitulo;
    private JPanel jBotones;
    private JPanel jContenido;
    private JLabel jlNombre;
    private JButton bAceptar;
    private JButton bSalir;
    private JComboBox cbDueno;

    public BorrarDueño(){
        //Lista de dueños
        ArrayList<Dueno> Dueno = Main.verNombreDuenos();
        for (Dueno due : Dueno) {
            cbDueno.addItem(due);
        }
/**
 * A la hora de ejecutar el boton aceptar se borra un duenño con los datos obtenidos de la ventana.
 */
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.borrarDueño(cbDueno.getSelectedItem());
                Main.cerrarVentana();
                Main.ventanaEliminarDueño();
            }
        });
        /**
         * A la hora de ejecutar el boton salir vuelve a loa ventana del administrador.
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
