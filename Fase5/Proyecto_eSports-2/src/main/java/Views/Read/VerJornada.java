/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Read;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerJornada {
    public JPanel jVerJornadas;
    private JTextArea taVerJornadas;
    private JLabel lTitulo;
    private JButton bSalir;

    public VerJornada(){
        /**
         * Metodo para llamar a insertar las jornadas
         */
        taVerJornadas.setText(Main.consultarJornadas());
        /**
         * Al usar el boton de salir dependiendo de si es usuario o administrador le devolvera a una pantalla u otra.
         */
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Main.tipoUsuario.toLowerCase().equals("u")) {
                    Main.cerrarVentana();
                    Main.ventanaUsuario();
                } else {
                    Main.cerrarVentana();
                    Main.ventanaAdministrador();}
            }
        });
    }

}
