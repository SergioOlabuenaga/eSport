package Views.Create;

import Controlador.Main;
import Excepciones.PerExcepciones;
import Modelo.Login;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearUsuario {
    public JPanel jCrearUsuario;
    private JLabel lTitulo;
    private JTextField tfNombre;
    private JButton bCrear;
    private JButton bSalir;
    private JLabel lNombre;
    private JLabel lContraseña;
    private JPasswordField tfContraseña;
    private JPanel jDatos;
    private JPanel jBotones;


    public CrearUsuario() {
        bCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfNombre.getText().isEmpty()||tfContraseña.getText().isEmpty()){
                    try {
                        throw new PerExcepciones(1);
                    } catch (PerExcepciones ex) {
                       JOptionPane.showMessageDialog(null,ex.getMessage());
                       tfContraseña.setText("");
                       tfNombre.setText("");
                    }

                }else {
                    Main.generarUsuario(tfNombre.getText(), tfContraseña.getText());
                }
            }
        });
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.cerrarVentana();
                Main.ventanaAdministrador();
            }
        });
    }
}
