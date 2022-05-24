/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Login;

import Controlador.Main;
import Modelo.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaPrincipal {
    public JPanel jPrincipal;
    private JLabel lTitulo;
    private JTextField tfNombre;
    private JTextField tfContraseña;
    private JLabel lNombre;
    private JLabel lContraseña;
    private JButton bAceptar;
    private JButton bSalir;
    private JPanel jContenido;
    private JPanel jBotones;
    private JPanel jImagen;
    private JLabel lImagen;

    public VistaPrincipal() {

        /**
         * Cuando le da al boton de aceptar, validada y genrena ventana administrador o ventana usuario
         */
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Validamos y una vez validado, genrena ventana administrador o ventana usuario */
                if (tfNombre.getText().isEmpty() || tfContraseña.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Error: Alguno de los campos está vacío." +
                            " Vuelva a intentarlo.");
                    tfNombre.setText("");
                    tfContraseña.setText("");
                }
                else {
                    Main.usuario = tfNombre.getText();
                    boolean error = Main.login(tfContraseña.getText());
                    if (!error) {
                        JOptionPane.showMessageDialog(null,"Error, usuario no encontrado");
                        tfNombre.setText("");
                        tfContraseña.setText("");
                    }
                }
            }
        });
        /**
         * Salir del programa
         */
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Finalizar programa */
                System.exit(0);
            }
        });
        /**
         *Validacion para poder logearte.
         */
        tfContraseña.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Validamos y una vez validado, genrena ventana administrador o ventana usuario */
                if (tfNombre.getText().isEmpty() || tfContraseña.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Error: Alguno de los campos está vacío." +
                            " Vuelva a intentarlo.");
                    tfNombre.setText("");
                    tfContraseña.setText("");
                }
                else {
                    Main.usuario = tfNombre.getText();
                    boolean error = Main.login(tfContraseña.getText());
                    if (!error) {
                        JOptionPane.showMessageDialog(null,"Error, usuario no encontrado");
                        tfNombre.setText("");
                        tfContraseña.setText("");
                    }
                }
            }
        });
    }
}
