/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Login;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaUsuario {
    public JPanel jVistaUsuario;
    private JLabel lTitulo;
    private JPanel jContenido;
    private JPanel jUltimaJornada;
    private JPanel jImagen;
    private JPanel jpVistaUsuario;
    private JMenu jmClasificacion;
    private JMenu jmJornadas;
    private JMenu jmUltimaJornada;
    private JMenu jmCuenta;
    private JMenuItem jmiCerrarSesion;
    private JMenuItem jmiClasificacion;
    private JMenuItem jmiJornadas;
    private JMenuItem jmiUltimaJornada;
    private JTextField tfJornadas;
    private JLabel lJornadas;
    private JPanel jClasificaciones;
    private JPanel jMenu;
    private JLabel jlBienvenida;

    public VistaUsuario() {
        jlBienvenida.setText("Bienvenido, " + Main.usuario);

        /**
         *  Metodo para llamar a generar la ventana de ver clasifiacion.
         */
        jmiClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Acción al hacer click en ver clasificación */
                Main.cerrarVentana();
                Main.ventanaVerClasificacion();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de ver clasificacion.
         */
        jmiJornadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Acción al hacer click en Jornadas */
                Main.cerrarVentana();
                Main.ventanaVerJornada();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de ver ultima jornada.
         */
        jmiUltimaJornada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Acción al hacer click en ver ultima jornada */
                Main.cerrarVentana();
                Main.ventanaVerUltimaJornada();
            }
        });
        /**
         * Metodo para volver al login.
         */
        jmiCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Acción al hacer click en cerrar sesión */
                Main.cerrarVentana();
                Main.ventanaPrincipal();
            }
        });
    }
}
