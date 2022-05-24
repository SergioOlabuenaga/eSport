/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Login;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaAdministrador {
    private JLabel lTitulo;
    private JMenu jmJornadas;
    private JMenuItem jmiGenerarJornada;
    private JMenu jmClasificacion;
    private JMenu jmDueño;
    private JMenu jmJugador;
    private JMenu jmEquipo;
    private JMenu jmUsuario;
    private JMenu jmCuenta;
    private JMenuItem jmiCerrarSesion;
    private JMenuItem jmiActualizarJornada;
    private JMenuItem jmiVerJornada;
    private JMenuItem jmiCrearDueño;
    private JMenuItem jmiModificarDueño;
    private JMenuItem jmiEliminarDueño;
    private JMenuItem jmiVerDueño;
    private JMenuItem jmiCrearJugador;
    private JMenuItem jmiModificarJugador;
    private JMenuItem jmiEliminarJugador;
    private JMenuItem jmiVerJugador;
    private JMenuItem jmiCrearEquipo;
    private JMenuItem jmiModificarEquipo;
    private JMenuItem jmiEliminarEquipo;
    private JMenuItem jmiVerEquipo;
    private JMenuItem jmiCrearUsuario;
    private JMenuItem jmiModificarUsuario;
    private JMenuItem jmiEliminarUsuario;
    private JMenuItem jmiVerUsuario;
    public JPanel jAdministrador;
    private JMenuItem jmiVerClasificacion;
    private JPanel jPrincipal;
    private JMenuBar jmbMenu;
    private JPanel jFoto;
    private JLabel jlBienvenida;
    private JMenu jmAsistente;
    private JMenuItem jmiCrearAsistente;
    private JMenuItem jmiModificarAsistente;
    private JMenuItem jmiEliminarAsistente;
    private JMenuItem jmiVerAsistente;
    private JMenu jmEntrenador;
    private JMenuItem jmiCrearEntrenador;
    private JMenuItem jmiModificarEntrenador;
    private JMenuItem jmiEliminarEntrenador;
    private JMenuItem jmiVerEntrenador;

    public VistaAdministrador() {

        jlBienvenida.setText("Bienvenido, " + Main.usuario);

        /**
         * Metodo para llamar a generar la ventana de ver clasificacion.
         */
        jmiVerClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en ver clasificación */
                Main.cerrarVentana();
                Main.ventanaVerClasificacion();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de  crear dueño
         */
        jmiCrearDueño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en ver crear dueño */
                Main.cerrarVentana();
                Main.ventanaCrearDueño();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de modificar el dueño
         */
        jmiModificarDueño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en ver modificar dueño */
                Main.cerrarVentana();
                Main.ventanaModificarDueño();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de  eliminar dueño
         */
        jmiEliminarDueño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en ver eliminar dueño */
                Main.cerrarVentana();
                Main.ventanaEliminarDueño();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de  ver dueño
         */
        jmiVerDueño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en ver dueño */
                Main.cerrarVentana();
                Main.ventanaVerDueno();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de  crear jugador
         */
        jmiCrearJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en crear jugador */
                Main.cerrarVentana();
                Main.ventanaCrearJugador();
            }
        });

        /**
         * Metodo para llamar a generar la ventana de  moificar jugador
         */
        jmiModificarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en modificar jugador */
                Main.cerrarVentana();
                Main.ventanaModificarJugador();
            }
        });

        /**
         * Metodo para llamar a generar la ventana de  eliminar jugador
         */
        jmiEliminarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en eliminar jugador */
                Main.cerrarVentana();
                Main.ventanaEliminarJugador();
            }
        });

        /**
         * Metodo para llamar a generar la ventana de  ver jugador
         */
        jmiVerJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en ver jugador */
                Main.cerrarVentana();
                Main.ventanaVerJugadores();
            }
        });

        /**
         * Metodo para llamar a generar la ventana de  crear equipo
         */
        jmiCrearEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en crear equipo */
                Main.cerrarVentana();
                Main.ventanaCrearEquipo();
            }
        });

        /**
         * Metodo para llamar a generar la ventana de  modificar equipo
         */
        jmiModificarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en modificar equipo */
                Main.cerrarVentana();
                Main.ventanaModificarEquipo();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de  eliminar equipo
         */
        jmiEliminarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en eliminar equipo */
                Main.cerrarVentana();
                Main.ventanaEliminarEquipo();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de  ver equipo
         */
        jmiVerEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en ver equipo */
                Main.cerrarVentana();
                Main.ventanaVerEquipo();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de crear usuario
         */
        jmiCrearUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en crear usuario */
                Main.cerrarVentana();
                Main.ventanaCrearUsuario();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de  modificar usuario
         */
        jmiModificarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en modificar usuario */
                Main.cerrarVentana();
                Main.ventanaModificarUsuario();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de eliminar usuario
         */
        jmiEliminarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en eliminar usuario */
                Main.cerrarVentana();
                Main.ventanaEliminarUsuario();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de ver usuario
         */
        jmiVerUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en ver usuario */
                Main.cerrarVentana();
                Main.ventanaVerUsuarios();
            }
        });
        /**
         * Metodo para llamar a cerrar la ventana de administrador y volver a la login.
         */
        jmiCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en cerrar sesión */
                Main.cerrarVentana();
                Main.ventanaPrincipal();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de  crear jornada
         */
        jmiGenerarJornada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en generar jornada */
                Main.generarJornada();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de  modificar jornada
         */
        jmiActualizarJornada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en modificar jornada */
                Main.cerrarVentana();
                Main.ventanaModificarJornada();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de  ver jornada
         */
        jmiVerJornada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en ver jornada */
                Main.cerrarVentana();
                Main.ventanaVerJornada();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de crear asistente
         */
        jmiCrearAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en crear asistente */
                Main.cerrarVentana();
                Main.ventanaCrearAsistente();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de  ver asistente.
         */
        jmiVerAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en ver asistente */
                Main.cerrarVentana();
                Main.ventanaVerAsistente();
            }
        });

        /**
         * Metodo para llamar a generar la ventana de  modificar asistente.
         */
        jmiModificarAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en modificar asistente */
                Main.cerrarVentana();
                Main.ventanaModificarAsistente();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de  modificar usuario
         */
        jmiModificarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en modificar usuario */
                Main.cerrarVentana();
                Main.ventanaModificarUsuario();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de  eliminar asistente
         */
        jmiEliminarAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en eliminar asistente */
                Main.cerrarVentana();
                Main.ventanaEliminarAsistente();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de  crear entrenador
         */
        jmiCrearEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en crear entrenador */
                Main.cerrarVentana();
                Main.ventanaCrearEntrenador();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de  eliminar entrenador
         */
        jmiEliminarEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en eliminar entrenador */
                Main.cerrarVentana();
                Main.ventanaEliminarEntrenador();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de  modificar entrenador
         */
        jmiModificarEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en modificar entrenador */
                Main.cerrarVentana();
                Main.ventanaModificarEntrenador();
            }
        });
        /**
         * Metodo para llamar a generar la ventana de  ver entrenador
         */
        jmiVerEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Accion al hacer click en ver entrenador */
                Main.cerrarVentana();
                Main.ventanaVerEntrenador();
            }
        });
    }
}
