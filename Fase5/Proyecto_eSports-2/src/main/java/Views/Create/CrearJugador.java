/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Create;
import Controlador.Main;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Excepciones.*;
import Modelo.Equipo;

public class CrearJugador {
    public JPanel jJugador;
    private JLabel lTitulo;
    private JTextField tfEquipo;
    private JTextField tfNombre;
    private JTextField tfNickname;
    private JTextField tfSueldo;
    private JTextField tfTelefono;
    private JTextField tfRol;
    private JButton bCrear;
    private JButton bSalir;
    private JLabel lEquipo;
    private JLabel lNombre;
    private JLabel lNickname;
    private JLabel lSueldo;
    private JLabel lTelefono;
    private JLabel lRol;
    private JPanel jBotones;
    private JPanel jDatos;
    private JComboBox cbEquipo;

    public CrearJugador() {
        // Lista con los equipos que ya estan creados
        ArrayList<Equipo> Equipo = Main.verNombreEquipos();
        for (Equipo equ : Equipo) {
            cbEquipo.addItem(equ);
        }
        /**
         * A la hora de ejecutar el boton aceptar se crea un nuevo jugador con los datos obtenidos de la ventana.
         */
        bCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfNombre.getText().isEmpty()||tfNickname.getText().isEmpty()||tfSueldo.getText().isEmpty()||
                        tfTelefono.getText().isEmpty()||tfRol.getText().isEmpty()) {
                    try {
                        throw new PerExcepciones(1);
                    } catch (PerExcepciones ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        tfNombre.setText("");
                        tfNickname.setText("");
                        tfSueldo.setText("");
                        tfTelefono.setText("");
                        tfRol.setText("");
                    }
                }
                else {
                    Main.generarJugador(Main.obtenerIdEquipo((Equipo) cbEquipo.getSelectedItem()),tfNombre.getText(),
                            tfNickname.getText(), tfSueldo.getText(), tfTelefono.getText(),tfRol.getText());
                    tfNombre.setText("");
                    tfNickname.setText("");
                    tfSueldo.setText("");
                    tfTelefono.setText("");
                    tfRol.setText("");
                }
            }
        });
        /**
         * A la hora de ejecutar el boton salir vuelve a la ventana del admistrador.
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
