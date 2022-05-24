/**
 * @author: Equipo4
 * @version: 1
 */

package Controlador;
import Modelo.*;
import Views.Create.*;
import Views.Delete.*;
import Views.Login.*;
import Views.Read.*;
import Views.Update.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static JFrame frame;
    public static String usuario;
    public static String nombre;
    public static String tipoUsuario;

    /**
     *Nos quenera la ventana de Login
     * @param args: argumento
     */
    public static void main (String[] args) {
        ventanaPrincipal();
}

    /**
     * Conexion con la base de datos para transferir información.
     *
     * @return con: Devulve la conexion.
     */
    public static Connection conectarbbdd() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String conexion = "jdbc:oracle:thin:@SrvOracle:1521:orcl";
            con = DriverManager.getConnection(conexion,"eqdaw04","eqdaw04");
        }
        catch (Exception e) {
            System.err.println("Error: "+ e.getMessage());
        }
        return con;
    }

    /**
     * Comprobacion de si el cliente es un usuario o un administrador, ademas de abrir su ventana correspondiente.
     * @param pass: Contraseña itroducida por el cliente.
     * @return error: Si el login falla devuelve un error.
     */
    public static boolean login(String pass) {
        boolean error = true;
        usuario = usuario.toLowerCase();
        try {
            String select = "SELECT TIPO FROM LOGIN WHERE LOWER(USUARIO) ='" + usuario + "' AND PASS ='" + pass + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            resultado.next();
            tipoUsuario = resultado.getString("tipo").toLowerCase();
            if (resultado.getString("tipo").toLowerCase().equals("u")) {
                ocultarVentana();
                ventanaUsuario();
            } else if (resultado.getString("tipo").toLowerCase().equals("a")) {
                ocultarVentana();
                ventanaAdministrador();
            } else {
                error = false;
            }
        } catch (Exception e){
            error = false;
        }
        return error;
    }

    // Metodos cerrar/ocultar ventanas

    /**
     * Metodo para cerra la ventana.
     */
    public static void cerrarVentana() {
        frame.dispose();
    }

    /**
     * Metodo para ocultar la ventana.
     */
    public static void ocultarVentana() {
        frame.setVisible(false);
    }

    // Métodos de Vistas Principales (Generar)

    /**
     * Metodo para generar la venta principal
     */
    public static void ventanaPrincipal() {
        frame = new JFrame("Inicio de sesión");
        frame.setContentPane(new VistaPrincipal().jPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    /**
     * Metodo para generar la venta del Usuario
     */
    public static void ventanaUsuario(){
        frame = new JFrame("Vista de usuario");
        frame.setContentPane(new VistaUsuario().jVistaUsuario);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    /**
     * Metodo para generar la venta del administrador
     */
    public static void ventanaAdministrador(){
        frame = new JFrame("Vista de administrador");
        frame.setContentPane(new VistaAdministrador().jAdministrador);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Ventanas Crear

    /**
     * Metodo para generar la ventana crear usuario
     */
    public static void ventanaCrearUsuario(){
        frame = new JFrame("Crear usuario");
        frame.setContentPane(new CrearUsuario().jCrearUsuario);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana crear equipo
     */
    public static void ventanaCrearEquipo(){
        frame = new JFrame("Crear equipo");
        frame.setContentPane(new CrearEquipo().jCrearEquipo);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana crear dueño
     */
    public static void ventanaCrearDueño(){
        frame = new JFrame("CrearDueño");
        frame.setContentPane(new CrearDueño().jCrearDueño);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana crear  jugador
     */
    public static void ventanaCrearJugador(){
        frame = new JFrame("Crear jugador");
        frame.setContentPane(new CrearJugador().jJugador);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana crear asistente
     */
    public static void ventanaCrearAsistente(){
        frame = new JFrame("Crear Asistente");
        frame.setContentPane(new CrearAsistente().jCrearAsistente);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana crear entrenador
     */
    public static void ventanaCrearEntrenador() {
        frame = new JFrame("Crear Entrenador");
        frame.setContentPane(new CrearEntrenador().jCrearEntrenador);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    // Ventanas Visualizar
    /**
     * Metodo para generar la ventana ver usuarios
     */
    public static void ventanaVerUsuarios() {
        frame = new JFrame("Lista de usuarios");
        frame.setContentPane(new VerUsuario().jVerUsuarios);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana ver jugadores
     */
    public static void ventanaVerJugadores() {
        frame = new JFrame("Visualización de jugadores");
        frame.setContentPane(new VerJugador().jVerJugadores);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana ver dueños
     */
    public static void ventanaVerDueno() {
        frame = new JFrame("Ver Dueño");
        frame.setContentPane(new VerDueño().jVerDueño);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana ver asistentes
     */
    public static void ventanaVerAsistente() {
        frame = new JFrame("Ver Asistente");
        frame.setContentPane(new VerAsistente().jVerAsistente);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana ver entrenadore
     */
    public static void ventanaVerEntrenador() {
        frame = new JFrame("Ver Entrenador");
        frame.setContentPane(new VerEntrenador().jVerEntrenador);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana ver equipos
     */
    public static void ventanaVerEquipo() {
        frame = new JFrame("Ver Equipo");
        frame.setContentPane(new VerEquipo().jVerEquipo);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana ver jornada
     */
    public static void ventanaVerJornada() {
        frame = new JFrame("Ver Jornadas");
        frame.setContentPane(new VerJornada().jVerJornadas);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (Main.tipoUsuario.toLowerCase().equals("u")) {
                    Main.cerrarVentana();
                    Main.ventanaUsuario();
                } else {
                    Main.cerrarVentana();
                    Main.ventanaAdministrador();
                }
            }
        });
    }
    /**
     * Metodo para generar la ventana ver clasificacion
     */
    public static void ventanaVerUltimaJornada() {
        frame = new JFrame("Ver Última Jornada");
        frame.setContentPane(new VerUltimaJornada().jVerUltimaJornada);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaUsuario();
            }
        });
    }

    /**
     * Metodo para generar la ventana ver clasificacion
     */
    public static void ventanaVerClasificacion(){
        frame = new JFrame("Ver Clasificacion");
        frame.setContentPane(new VerClasificacion().jVerClasificacion);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (Main.tipoUsuario.toLowerCase().equals("u")) {
                    Main.cerrarVentana();
                    Main.ventanaUsuario();
                } else {
                    Main.cerrarVentana();
                    Main.ventanaAdministrador();
                }
            }
        });
    }

    // Ventana Modificar
    /**
     * Metodo para generar la ventana modificar asistente
     */
    public static void ventanaModificarAsistente() {
        frame = new JFrame("Modificar Asistente");
        frame.setContentPane(new ModificarAsistente().jModificarAsistente);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana modificar dueño
     */
    public static void ventanaModificarDueño() {
        frame = new JFrame("Modificar Dueño");
        frame.setContentPane(new ModificarDueño().jModificarDueño);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana modificar entrenador
     */
    public static void ventanaModificarEntrenador() {
        frame = new JFrame("Modificar Entrenador");
        frame.setContentPane(new ModificarEntrenador().jModificarEntrenador);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana modificar equipo
     */
    public static void ventanaModificarEquipo() {
        frame = new JFrame("Modificar Equipo");
        frame.setContentPane(new ModificarEquipo().jModificarEquipo);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana modificar jugador
     */
    public static void ventanaModificarJugador() {
        frame = new JFrame("Modificar Jugador");
        frame.setContentPane(new ModificarJugador().jModificarJugador);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana modificar usuario
     */
    public static void ventanaModificarUsuario() {
        frame = new JFrame("Modificar Usuario");
        frame.setContentPane(new ModificarUsuario().jModificarUsuario);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana modificar jornada
     */
    public static void ventanaModificarJornada() {
        frame = new JFrame("Modificar Jornada");
        frame.setContentPane(new ModificarJornada().jVerPartido);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }


    // Ventanas Eliminar
    /**
     * Metodo para generar la ventana eliminar usuario
     */
    public static void ventanaEliminarUsuario() {
        frame = new JFrame("Eliminar Usuario");
        frame.setContentPane(new BorrarUsuario().jEliminarUsuario);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana eliminar equipo
     */
    public static void ventanaEliminarEquipo() {
        frame = new JFrame("Borrar Equipo");
        frame.setContentPane(new BorrarEquipo().jEliminarEquipo);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana eliminar jugador
     */
    public static void ventanaEliminarJugador() {
        frame = new JFrame("Borrar Jugador");
        frame.setContentPane(new BorrarJugador().jBorrarJugador);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana eliminar dueño
     */
    public static void ventanaEliminarDueño() {
        frame = new JFrame("Borrar Dueño");
        frame.setContentPane(new BorrarDueño().jBorrarDueño);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana eliminar entrenadro
     */
    public static void ventanaEliminarEntrenador() {
        frame = new JFrame("Borrar Entrenador");
        frame.setContentPane(new BorrarEntrenador().jBorrarEntrenador);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }
    /**
     * Metodo para generar la ventana eliminar asistente
     */
    public static void ventanaEliminarAsistente() {
        frame = new JFrame("Borrar Asistente");
        frame.setContentPane(new BorrarAsistente().jBorrarAsistente);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
                ventanaAdministrador();
            }
        });
    }



    // Metodos generar datos

    /**
     * Generar un Usuario A través del nombre y contraseñas introducidas por el administrdor.
     * @param nombre: Nombre del nuevo usuario
     * @param pass: Contraseña del nuevo usuario
     */
    public static void generarUsuario(String nombre, String pass) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Login log = new Login();
        log.setUsuario(nombre);
        log.setPass(pass);
        log.setTipo("U");
        em.persist(log);
        transaction.commit();
    }

    /**
     * Generar los datos de un dueño mediante el administrador.
     * @param nombre: Nombre del dueño nuevo
     * @param telefono: Telefono del dueño nuevo
     * @param empresa: Nombre de la empresa que dirige el dueño nuevo
     */
    public static void generarDueño(String nombre, String telefono, String empresa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            do {
                transaction.begin();
                Dueno dueno = new Dueno();
                dueno.setNombre(nombre);
                dueno.setTelefono(telefono);
                dueno.setNombreEmpresa(empresa);
                em.persist(dueno);
                transaction.commit();
            } while (JOptionPane.showConfirmDialog(null, "¿Desea crear mas dueños?", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) == 0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error desconocido. Contacte con un administrador");
        }
    }

    /**
     * Generar un nuevo jugador para un equipo atraves del administrador.
     * @param idEquipo: Identificador del equipo al que se asigna el nuevo jugador.
     * @param nombre: Nombre del nuevo jugador.
     * @param nickname: Nickname del jugador en la competicion.
     * @param sueldo: Sueldo del nuevo jugador.
     * @param telefono: Telefono del nuevo jugador.
     * @param rol: Rol que tendra el jugador en el equipo.
     */
    public static void generarJugador(int idEquipo, String nombre, String nickname, String sueldo, String telefono, String
            rol) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        // Conseguir id_equipo a traves de nombre equipo
        try {
            do {
                transaction.begin();
                Jugador jug = new Jugador();
                jug.setIdEquipo(idEquipo);
                jug.setNombre(nombre);
                jug.setNickname(nickname);
                jug.setSueldo(Integer.parseInt(sueldo));
                jug.setTelefono(telefono);
                jug.setRol(rol);
                em.persist(jug);
                transaction.commit();
            } while (JOptionPane.showConfirmDialog(null, "¿Desea crear mas jugadores?", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) == 0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la BBDD: " + e.getMessage());
        }
    }

    /**
     * Generar un nuevo entrenador A través del administrador.
     * @param nombre: Nombre del nuevo entrenador.
     * @param telefono: Telefono del nuevo entrenador.
     * @param añosExp: Años de experiencia de ese nuevo entrenador.
     */
    public static void generarEntrenador(String nombre, String telefono, int añosExp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            do {
                transaction.begin();
                Entrenador ent = new Entrenador();
                ent.setNombre(nombre);
                ent.setTelefono(telefono);
                ent.setAnosExp(añosExp);
                em.persist(ent);
                transaction.commit();
            } while (JOptionPane.showConfirmDialog(null, "¿Desea crear mas entrenadores?", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) == 0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error desconocido. Contacte con un administrador");
        }
    }

    /**
     * Genera un asistete A través del administrador.
     * @param nombre: Nombre del nuevo asistente.
     * @param tlf: Telefono del asistente nuevo.
     * @param desc: Descripcion de las funciones del asistente nuevo.
     */
    public static void generarAsistente(String nombre, String tlf, String desc) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            do {
                transaction.begin();
                Asistente a = new Asistente();
                a.setNombre(nombre);
                a.setTelefono(tlf);
                a.setDescripcionFuncion(desc);
                em.persist(a);
                transaction.commit();
            } while (JOptionPane.showConfirmDialog(null, "¿Desea crear mas asistentes?", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) == 0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error desconocido. Contacte con un administrador");
        }
    }

    /**
     * Genera un nuevo equipo A través del administrador. ATENCION: Aqui se asignan el entrenador, el dueño y CON
     * el asistente de los equipos.
     * @param nombre: Nombre del nuevo equipo participante;
     * @param anoCrear: Año en el que se creo el equipo.(Podria haberse creado en años anteriores)
     * @param nacionalidad: Nacionalidad del equipo.
     * @param id_dueno: Identificador del dueño que dirige el equipo nuevo.
     * @param id_entrenador: Identificador del entrenador que entrena el nuevo equipo.
     * @param id_asistentes Identificador del asistente del nuevo equipo.
     */
    public static void generarEquipo(String nombre, String anoCrear, String nacionalidad, Dueno id_dueno, Entrenador id_entrenador,
                                     Asistente id_asistentes) {
        int anoCreacion = Integer.parseInt(anoCrear);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Equipo equi = new Equipo();
            equi.setNombre(nombre);
            equi.setAnoCreacion(anoCreacion);
            equi.setNacionalidad(nacionalidad);
            equi.setIdDueno(id_dueno.getIdDueno());
            equi.setIdEntrenador(id_entrenador.getIdEntrenador());
            System.out.println(id_asistentes.getIdAsistente());
            equi.setIdAsistente(id_asistentes.getIdAsistente());
            em.persist(equi);
            transaction.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error desconocido. Contacte con un administrador");
        }
    }

    /**
     * Genera un nuevo equipo A través del administrador. ATENCION: Aqui se asignan el entrenador, el dueño y SIN
     * el asistente de los equipos.
     * @param nombre: Nombre del nuevo equipo participante;
     * @param anoCrear: Año en el que se creo el equipo.(Podria haberse creado en años anteriores)
     * @param nacionalidad: Nacionalidad del equipo.
     * @param id_dueno: Identificador del dueño que dirige el equipo nuevo.
     * @param id_entrenador: Identificador del entrenador que entrena el nuevo equipo.
     */
    public static void generarEquipo (String nombre, String anoCrear, String nacionalidad, Dueno id_dueno, Entrenador id_entrenador) {
        int anoCreacion = Integer.parseInt(anoCrear);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            do {
                transaction.begin();
                Equipo equi = new Equipo();
                equi.setNombre(nombre);
                equi.setAnoCreacion(anoCreacion);
                equi.setNacionalidad(nacionalidad);
                equi.setIdDueno(id_dueno.getIdDueno());
                equi.setIdEntrenador(id_entrenador.getIdEntrenador());
                em.persist(equi);
                transaction.commit();
            } while (JOptionPane.showConfirmDialog(null, "¿Desea crear mas equipos?", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) == 0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error desconocido. Contacte con un administrador");
        }
    }

    /**
     * Genera las jornadas automaticamente tras asignar los partidos con los equipos correspondientes.
     */
    public static void generarJornada() {
        int dia = 01;
        int mes = 01;
        int equipos = 0;
        int x = 0;
        int contador = 0;
        ArrayList<Equipo> equi = verIDEquipos();
        ArrayList<Equipo> equiReves = new ArrayList<>();

        try {
            String borrarJornadas = "DELETE FROM JORNADA";
            PreparedStatement ps1 = conectarbbdd().prepareStatement(borrarJornadas);
            ResultSet t1 = ps1.executeQuery(borrarJornadas);

            String borrarPartidos = "DELETE FROM PARTIDO";
            PreparedStatement ps7 = conectarbbdd().prepareStatement(borrarPartidos);
            ResultSet t2 = ps7.executeQuery(borrarPartidos);


            String selectID = "SELECT COUNT(*)-1 FROM EQUIPO";
            PreparedStatement ps = conectarbbdd().prepareStatement(selectID);
            ResultSet resultadoID = ps.executeQuery(selectID);
            while (resultadoID.next()) {
                equipos = resultadoID.getInt("COUNT(*)-1");
            }

            do {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String fecha = "2022/" + mes + "/" + dia;

                EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
                EntityManager em = emf.createEntityManager();
                EntityTransaction transaction = em.getTransaction();

                if (dia < 28) {
                    String insertar = "INSERT INTO JORNADA(FECHA) VALUES(TO_DATE('" + fecha + "','yyyy/MM/dd'))";
                    PreparedStatement ps2 = conectarbbdd().prepareStatement(insertar);
                    ResultSet resultado = ps2.executeQuery(insertar);

                    // Conseguir id jornada
                    int idJornada = obtenerIdJornada();

                    // Generar partidos
                    if (contador == 0) {
                        for (int i = 0; i < equi.size(); i = i+2) {
                            int hora = 12;
                            int minutos = 00;
                            String horaPartido = hora + ":" + minutos;
                            String insertarP = "INSERT INTO PARTIDO(HORA,ID_LOCAL,ID_VISITANTE,PUNTOS_LOCAL,PUNTOS_VISITANTE,ID_JORNADA) " +
                                    "VALUES(TO_DATE('" + horaPartido + "','HH24:MI')," +  equi.get(i).getIdEquipo() + "," + equi.get(i+1).getIdEquipo() +"," +
                                    "0,0," + idJornada + ")";
                            PreparedStatement ps3 = conectarbbdd().prepareStatement(insertarP);
                            ResultSet resultadoP = ps3.executeQuery(insertarP);
                            hora ++;
                        }
                    } else {
                        for (int i = 0; i < equiReves.size(); i = i+2) {
                            System.out.println(equiReves.size());
                            int hora = 13;
                            int minutos = 00;
                            String horaPartido = hora + ":" + minutos;
                            String insertarP = "INSERT INTO PARTIDO(HORA,ID_LOCAL,ID_VISITANTE,PUNTOS_LOCAL,PUNTOS_VISITANTE,ID_JORNADA) " +
                                    "VALUES(TO_DATE('" + horaPartido + "','HH24:MI')," +  equiReves.get(i).getIdEquipo() + "," + equiReves.get(i+1).getIdEquipo() +"," +
                                    "0,0," + idJornada + ")";
                            PreparedStatement ps3 = conectarbbdd().prepareStatement(insertarP);
                            ResultSet resultadoP = ps3.executeQuery(insertarP);
                            hora ++;
                        }
                    }

                    for (int y = 1; equiReves.size() == equi.size(); y++) {
                        equiReves.add(equi.get(y));
                        if ((equiReves.size() -1) == equi.size()){
                            equiReves.add(equi.get(-1));
                        }
                    }
                    dia = dia + 07;
                    x ++;
                    contador ++;
                } else {
                    mes = mes + 01;
                    dia = 01;
                }
            } while (equipos > x);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Metodos borrar datos

    /**
     * Borra un usuario.
     * @param usu: Usuario que se quiere eliminar.
     */
    public static void borrarUsuario(Object usu){
        try {
            String borrar = "DELETE FROM LOGIN WHERE LOWER(usuario) = '" + usu.toString().toLowerCase() + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(borrar);
            if (JOptionPane.showConfirmDialog(null, "¿Estás seguro? Esta acción" +
                            " es irreversible", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) == 0) {
                ResultSet resultado = ps.executeQuery(borrar);
                resultado.next();
                JOptionPane.showMessageDialog(null, "Usuario borrado correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }

    }
    /**
     * Borra un Equipo.
     * @param equi: Equipo que se quiere eliminar.
     */
    public static void borrarEquipo(Object equi) {
        try {
            String borrar = "DELETE FROM EQUIPO WHERE LOWER(NOMBRE) = '" + equi.toString().toLowerCase() + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(borrar);
            if (JOptionPane.showConfirmDialog(null, "¿Estás seguro? Esta acción" +
                            " es irreversible", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) == 0) {
                ResultSet resultado = ps.executeQuery(borrar);
                resultado.next();
                JOptionPane.showMessageDialog(null, "Equipo borrado correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }

    /**
     * Borra un dueño.
     * @param due: Dueño que se quiere borrar.
     */
    public static void borrarDueño(Object due) {
        try {
            String borrar = "DELETE FROM DUENO WHERE NOMBRE = '" + due.toString() + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(borrar);
            if (JOptionPane.showConfirmDialog(null, "¿Estás seguro? Esta acción" +
                            " es irreversible", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) == 0) {
                ResultSet resultado = ps.executeQuery(borrar);
                resultado.next();
                JOptionPane.showMessageDialog(null, "Dueno borrado correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }

    /**
     * Borrar un jugador.
     * @param jug: Jugadpr que se quiere borrar.
     */
    public static void borrarJugador(Object jug) {
        try {
            String borrar = "DELETE FROM JUGADOR WHERE lower(NICKNAME) = '" + jug.toString().toLowerCase() + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(borrar);
            if (JOptionPane.showConfirmDialog(null, "¿Estás seguro? Esta acción" +
                            " es irreversible", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) == 0) {
                ResultSet resultado = ps.executeQuery(borrar);
                resultado.next();
                JOptionPane.showMessageDialog(null, "Jugador borrado correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }

    /**
     * Borrar un entrenador.
     * @param ent: Entrenador que se quiere borrar.
     */
    public static void borrarEntrenador(Object ent) {
        try {
            String borrar = "DELETE FROM ENTRENADOR WHERE lower(nombre) = '" + ent.toString().toLowerCase() + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(borrar);
            if (JOptionPane.showConfirmDialog(null, "¿Estás seguro? Esta acción" +
                            " es irreversible", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) == 0) {
                ResultSet resultado = ps.executeQuery(borrar);
                resultado.next();
                JOptionPane.showMessageDialog(null, "Jugador borrado correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }

    /**
     * Borrar un asistente.
     * @param asis: Asistente que se quiere borrar.
     */
    public static void borrarAsistente(Object asis) {
        try {
            String borrar = "DELETE FROM ASISTENTE WHERE nombre = '" + asis.toString() + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(borrar);
            if (JOptionPane.showConfirmDialog(null, "¿Estás seguro? Esta acción" +
                            " es irreversible", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) == 0) {
                ResultSet resultado = ps.executeQuery(borrar);
                resultado.next();
                JOptionPane.showMessageDialog(null, "Asistente borrado correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }


    // Metodos visualizar datos

    /**
     * Muestra todos los datos del Usuario.
     * @return datos: Devuelve el Id, usuario y contraseña del usuario.
     */
    public static String consultarUsuarios() {
        StringBuilder datos = new StringBuilder("");
        try {
            String select = "SELECT ID_LOGIN, USUARIO, PASS FROM LOGIN WHERE TIPO = 'U' ORDER BY ID_LOGIN ASC";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                datos.append("  ID_Usuario = ").append(resultado.getInt("id_login")).append(", Usuario = ").
                        append(resultado.getString("usuario")).append(", Contraseña = ")
                        .append(resultado.getString("pass")).append("\n");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return datos.toString();
    }
    /**
     * Muestra todos los datos del dueño.
     * @return datos: Devuelve todos los datos del dueño menos el id.
     */
    public static String consultarDueno() {
        StringBuilder datos = new StringBuilder("");
        try {
            String select = "SELECT NOMBRE, TELEFONO, NOMBRE_EMPRESA FROM DUENO ORDER BY ID_DUENO ASC";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                datos.append("  Nombre = ").append(resultado.getString("nombre")).append(", Teléfono = ").
                        append(resultado.getString("telefono")).append(", Nombre de la empresa = ")
                        .append(resultado.getString("nombre_empresa")).append("\n");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return datos.toString();
    }
    /**
     * Muestra todos los datos de la clasificacion.
     * @return datos: Devuelve todos los datos de la clasificacion menos el id.
     */
    public static String consultarClasificacion() {
        StringBuilder datos = new StringBuilder("");
        try {
            String select = "SELECT NOMBRE, PUNTOS FROM VerClasificacion";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                datos.append("  Equipo = ").append(resultado.getString("nombre")).append(", Puntos = ").
                        append(resultado.getString("puntos")).append("\n");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return datos.toString();
    }

    /**
     * Muestra todos los datos del entrenador.
     * @return datos: Devuelve todos los datos del entrenador menos el id.
     */
    public static String consultarEntrenadores() {
        StringBuilder datos = new StringBuilder("");
        try {
            String select = "SELECT NOMBRE, TELEFONO, ANOS_EXP FROM ENTRENADOR ORDER BY ID_ENTRENADOR ASC";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                datos.append("  Nombre = ").append(resultado.getString("nombre")).append(", Teléfono = ").
                        append(resultado.getString("telefono")).append(", Años de experiencia = ")
                        .append(resultado.getInt("anos_exp")).append("\n");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return datos.toString();
    }
    /**
     * Muestra todos los datos del asistente.
     * @return datos: Devuelve todos los datos del asistente menos el id.
     */
    public static String consultarAsistente() {
        StringBuilder datos = new StringBuilder("");
        try {
            String select = "SELECT NOMBRE, TELEFONO, DESCRIPCION_FUNCION FROM ASISTENTE ORDER BY ID_ASISTENTE ASC";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                datos.append("  Nombre = ").append(resultado.getString("nombre")).append(", Teléfono = ").
                        append(resultado.getString("telefono")).append(", Función = ")
                        .append(resultado.getString("descripcion_funcion")).append("\n");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return datos.toString();
    }
    /**
     * Muestra todos los datos del equipo.
     * @return datos: Devuelve todos los datos del equipo.
     */
    public static String consultarEquipos() {
        StringBuilder datos = new StringBuilder("");
        try {
            String select = "SELECT * FROM VerEquipos";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                datos.append("  Equipo = ").append(resultado.getString("nombre")).append(", Año creación = ").
                        append(resultado.getString("año")).append(", Nacionalidad = ")
                        .append(resultado.getString("nacionalidad")).append(", Dueño = ")
                        .append(resultado.getString("dueno")).append(", Asistente = ")
                        .append(resultado.getString("asistente")).append(", Entrenador = ")
                        .append(resultado.getString("entrenador")).append("\n");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return datos.toString();
    }
    /**
     * Muestra todos los datos de los jugadores que hay en cada equipo.
     * @return datos: Devuelve todos los datos de los jugadores menos el id.
     * @param Equipo: Equipo a consultar
     */
    public static String consultarJugadores(Equipo Equipo) {
        String datosJugadores = "";
        try {
            int idEquipo = 0;
            String selectID = "SELECT ID_EQUIPO FROM EQUIPO WHERE NOMBRE = '" + Equipo.getNombre() + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(selectID);
            ResultSet resultadoID = ps.executeQuery(selectID);
            while (resultadoID.next()) {
                idEquipo = resultadoID.getInt("id_equipo");
            }
            String select = "SELECT NOMBRE, NICKNAME, SUELDO, TELEFONO, ROL FROM JUGADOR WHERE ID_EQUIPO = '" + idEquipo
                    + "'";
            PreparedStatement ps2 = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps2.executeQuery(select);
            while (resultado.next()) {
                datosJugadores = datosJugadores + "  Nombre = " + resultado.getString("NOMBRE") +
                        ", Nickname: " + resultado.getString("NICKNAME") +
                        ", Sueldo: " + resultado.getInt("SUELDO") +
                        ", Teléfono: " + resultado.getString("TELEFONO") +
                        ", Rol: " + resultado.getString("ROL") + "\n";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return datosJugadores;
    }
    /**
     * Muestra todos los datos de las jornadas.
     * @return datos: Devuelve todos los datos de las jornadas.
     */
    public static String consultarJornadas(){
        StringBuilder datos = new StringBuilder("");
        try {
            String select = "SELECT ID_JORNADA, FECHA FROM JORNADA ORDER BY FECHA ASC";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                datos.append("  Nº de Jornada = ").append(resultado.getInt("id_jornada"))
                        .append(", Fecha correspondiente = ").append(resultado.getDate("fecha")).append("\n");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return datos.toString();
    }


    /**
     * Muestra todos los datos de la ultima jornada.
     * @return datos: Devuelve todos los datos de la ultima jornada.
     */
    public static String consultarUltimaJornada(){
        StringBuilder datos = new StringBuilder("");
        try {
            String select = "SELECT ID_JORNADA, FECHA FROM JORNADA WHERE FECHA = (SELECT MAX(FECHA) FROM JORNADA)";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                datos.append("  Nº de Jornada = ").append(resultado.getInt("id_jornada")).
                        append(", Fecha correspondiente = ").append(resultado.getDate("fecha")).append("\n");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return datos.toString();
    }

    //Metedos actualizar datos

    /**
     * A través de la id hacemos los cambios correspondientes del dueño.
     * @param nom: Nombre del dueño modificado.
     * @param tlf: Numero de telefono del dueño modificado.
     * @param nEmpresa: Nombre de la empresa modificado.
     */
    public static void actializarDueno (Object nom, String tlf, String nEmpresa){
        try{
        String modifica = "UPDATE DUENO SET TELEFONO = '" + tlf +"', NOMBRE_EMPRESA= '" +nEmpresa +"' WHERE NOMBRE = '" + nom.toString() +"'";
        PreparedStatement ps = conectarbbdd().prepareStatement(modifica);
        if (JOptionPane.showConfirmDialog(null, "¿Estás seguro? Esta acción" +
                        " es irreversible", "Confirmación",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) == 0) {
            ResultSet resultado = ps.executeQuery(modifica);
            resultado.next();
            JOptionPane.showMessageDialog(null, "Dueño modificado correctamente");
        }
    } catch (Exception e) {
        System.out.println(e.getClass());
    }

    }

    /**
     * A través de la id hacemos los cambios correspondientes del entrenador.
     * @param nom: Nombre del entrenador modificado.
     * @param tlf: Telefono del entrenador modificado.
     * @param añosExp: Años de experiencia del entrenador modificado.
     */
    public static void actializarEntrenadores(Object nom, String tlf,int añosExp){
        try{
            String modifica = "UPDATE ENTRENADOR SET TELEFONO = '" + tlf +"', ANOS_EXP= '" +añosExp +"' WHERE NOMBRE = '" + nom.toString() +"'";
            PreparedStatement ps = conectarbbdd().prepareStatement(modifica);
            if (JOptionPane.showConfirmDialog(null, "¿Estás seguro? Esta acción" +
                            " es irreversible", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) == 0) {
                ResultSet resultado = ps.executeQuery(modifica);
                resultado.next();
                JOptionPane.showMessageDialog(null, "Entrenador modificado correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }


    }

    /**
     * A través de la id hacemos los cambios correspondientes del asistente.
     * @param nom: Nombre del asistente modificado.
     * @param tlf: Telefono del asistente modificado.
     * @param descrip: Descripcion de funciones del asistente modificado.
     */
    public static void actializarAsistente(Object nom, String tlf, String descrip){
        try {
            String modifica = "UPDATE ASISTENTE SET TELEFONO = '" + tlf +"', DESCRIPCION_FUNCION = '" +descrip
                    +"' WHERE NOMBRE = '" + nom.toString() +"'";
            PreparedStatement ps = conectarbbdd().prepareStatement(modifica);
            if (JOptionPane.showConfirmDialog(null, "¿Estás seguro? Esta acción" +
                            " es irreversible", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) == 0) {
                ResultSet resultado = ps.executeQuery(modifica);
                resultado.next();
                JOptionPane.showMessageDialog(null, "Asistente modificado correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }

    /**
     * A través de la id hacemos los cambios correspondientes del usuario.
     * @param nom: Usuario modificado.
     * @param contraseña: Contraseña modificado.
     */
    public static void actializarUsuario(Object nom, String contraseña){
        try {
            String modifica = "UPDATE LOGIN SET PASS = '" + contraseña + "' WHERE USUARIO = '" + nom.toString() +"'";
            PreparedStatement ps = conectarbbdd().prepareStatement(modifica);
            if (JOptionPane.showConfirmDialog(null, "¿Estás seguro? Esta acción" +
                            " es irreversible", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) == 0) {
                ResultSet resultado = ps.executeQuery(modifica);
                resultado.next();
                JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }

    /**
     * A través de la id hacemos los cambios correspondientes del equipo.
     * @param nom: Nombre del equipo modificado.
     * @param aCrear: Año de creacion del equipo modificado.
     * @param nacion: Nacionnalidad del equipo modificado.
     * @param dueno: Dueño del equipo modificado.
     * @param entre: Entrenador del equipo modificado.
     * @param asisten: Aistente del equipo modificado.
     */
    public static void actializarEquipos (Object nom, String aCrear, String nacion, Object dueno, Object entre, Object asisten){
        try {
            Dueno due = new Dueno();
            due.setNombre(dueno.toString());
            int idDueno = obtenerIdDueno(due);

            Entrenador ent = new Entrenador();
            ent.setNombre(entre.toString());
            int idEntrenador = obtenerIdEntrenador(ent);

            Asistente asis = new Asistente();
            asis.setNombre(asisten.toString());
            int idAsistente = obtenerIdAsistente(asis);

            int año = Integer.parseInt(aCrear);
            String modifica = "UPDATE EQUIPO SET ANO_CREACION= '" + año +"', NACIONALIDAD = '" + nacion +"', ID_DUENO = '"+
                    idDueno +"', ID_ENTRENADOR= '"+ idEntrenador +"', ID_ASISTENTE= '"+idAsistente +"' WHERE NOMBRE = '" + nom.toString() +"'";
            PreparedStatement ps = conectarbbdd().prepareStatement(modifica);
            if (JOptionPane.showConfirmDialog(null, "¿Estás seguro? Esta acción" +
                            " es irreversible", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) == 0) {
                ResultSet resultado = ps.executeQuery(modifica);
                resultado.next();
                JOptionPane.showMessageDialog(null, "Equipo modificado correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }

    /**
     * A través de la id hacemos los cambios correspondientes del Jugador
     * @param nick: Nickname modificado.
     * @param nom: Nombre del jugador modificado.
     * @param sueldo: Sueldo modificado.
     * @param rol: Rol modificado.
     * @param tlf: Telefono modificado.
     * @param equipo: Equipo al que se ha transferido.
     */
    public static void actializarJugadores(Object nick, String nom, String sueldo, String rol, String tlf, Object equipo ){
        try {
            Equipo equi = new Equipo();
            equi.setNombre(equipo.toString());
            int idEquipo = obtenerIdEquipo(equi);


            String modifica = "UPDATE JUGADOR SET NOMBRE = '" + nom + "', SUELDO = '" + sueldo +"', TELEFONO = '" + tlf +"', ROL = '"+
                    rol +"', ID_EQUIPO= '"+idEquipo +"' WHERE NICKNAME = '" + nick.toString() +"'";
            PreparedStatement ps = conectarbbdd().prepareStatement(modifica);
            if (JOptionPane.showConfirmDialog(null, "¿Estás seguro? Esta acción" +
                            " es irreversible", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) == 0) {
                ResultSet resultado = ps.executeQuery(modifica);
                resultado.next();
                JOptionPane.showMessageDialog(null, "Jugador modificado correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }

    /**
     *
     */
    public static void actializarJornada (){}




    // Metodos internos necesarios

    /**
     * Regoge en una lista todos los nombres de los equipos generados.
     * @return listaEquipos: Lista de todos los nombres de los equipos.
     */
    public static ArrayList<Equipo> verNombreEquipos() {
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        try {
            String select = "SELECT NOMBRE FROM EQUIPO";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                Equipo e = new Equipo();
                e.setNombre(resultado.getString("nombre"));
                listaEquipos.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaEquipos;
    }

    /**
     * Regoge en una lista todos los nombres de los equipos generados.
     * @return listaIDEquipos: Lista de todos los nombres de los equipos.
     */
    public static ArrayList<Equipo> verIDEquipos() {
        ArrayList<Equipo> listaIDEquipos = new ArrayList<>();
        try {
            String select = "SELECT ID_EQUIPO FROM EQUIPO ORDER BY ID_EQUIPO ASC";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                Equipo e = new Equipo();
                e.setIdEquipo(resultado.getInt("id_equipo"));
                listaIDEquipos.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaIDEquipos;
    }


    /**
     *Recoge el nombre de los dueños que no estan en un equipo en una lista.
     * @return listaDuenos: Lista de todos los nombre de los dueños.
     */
    public static ArrayList<Dueno> verNombreDuenos() {
        ArrayList<Dueno> listaDuenos = new ArrayList<>();
        try {
            String select = "SELECT ID_DUENO, NOMBRE FROM DUENO WHERE ID_DUENO NOT IN (SELECT ID_DUENO FROM EQUIPO)";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                Dueno d = new Dueno();
                d.setNombre(resultado.getString("nombre"));
                d.setIdDueno(resultado.getInt("id_dueno"));
                listaDuenos.add(d);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaDuenos;
    }

    /**
     * Recoge los nicknames de los jugadores en una lista.
     * @return listaJugadores: lista de todos los nickname de jugadores.
     */
    public static ArrayList<Jugador> verNombreJugadores() {
        ArrayList<Jugador> listaJugador = new ArrayList<>();
        try {
            String select = "SELECT ID_JUGADOR, NICKNAME FROM JUGADOR";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                Jugador d = new Jugador();
                d.setNickname(resultado.getString("nickname"));
                d.setIdJugador(resultado.getInt("id_jugador"));
                listaJugador.add(d);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaJugador;
    }

    /**
     * Recoge los nombres de los asistentes que no estan en un equipo en una lista.
     * @return listaAsistentes: lista de los nombres de los asistentes.
     */
    public static ArrayList<Asistente> verNombreAsistentes() {
        ArrayList<Asistente> listaAsistentes = new ArrayList<>();
        try {
            String select = "SELECT ID_ASISTENTE, NOMBRE FROM ASISTENTE WHERE ID_ASISTENTE NOT IN (SELECT ID_ENTRENADOR FROM EQUIPO)";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                Asistente a = new Asistente();
                a.setNombre(resultado.getString("nombre"));
                a.setIdAsistente(resultado.getInt("id_asistente"));
                listaAsistentes.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaAsistentes;
    }

    /**
     * Recoge los nombres de los entrenadores que no estan en un equipo en un lista.
     * @return listaEntrenadores: Lista con los nombres de los entrenadores.
     */
    public static ArrayList<Entrenador> verNombreEntrenadores() {
        ArrayList<Entrenador> listaEntrenadores = new ArrayList<>();
        try {
            String select = "SELECT ID_ENTRENADOR, NOMBRE FROM ENTRENADOR WHERE ID_ENTRENADOR NOT IN " +
                    "(SELECT ID_ENTRENADOR FROM EQUIPO)";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                Entrenador e = new Entrenador();
                e.setNombre(resultado.getString("nombre"));
                e.setIdEntrenador(resultado.getInt("id_entrenador"));
                listaEntrenadores.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaEntrenadores;
    }

    /**
     * Recoge lso usuarios que se han generado en una lista.
     * @return listaUsurios: Lista con los usuarios.
     */
    public static ArrayList<Login> verNombreUsuarios() {
        ArrayList<Login> listaUsuarios = new ArrayList<>();
        try {
            String select = "SELECT USUARIO FROM LOGIN WHERE TIPO = 'U'";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                Login l = new Login();
                l.setUsuario(resultado.getString("usuario"));
                listaUsuarios.add(l);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }

    /**
     * Obtener la id del equipo A través de la consuta de su nombre.
     * @param team: Equipo del que se quiere sacar el id.
     * @return id: Id del equipo que se ha buscado.
     */
    public static int obtenerIdEquipo(Equipo team) {
        int id = -1;
        try {
            String selectID = "SELECT ID_EQUIPO FROM EQUIPO WHERE NOMBRE = '" + team.getNombre() + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(selectID);
            ResultSet resultadoID = ps.executeQuery(selectID);
            while (resultadoID.next()) {
                id = resultadoID.getInt("id_equipo");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    /**
     * Obtener el ide del entrenador A través del nombre.
     * @param entrena: Entrenador con el que se interactua.
     * @return id: Id del entrenador que buscamos,
     */
    public static int obtenerIdEntrenador(Entrenador entrena) {
        int id = -1;
        try {
            String selectID = "SELECT ID_ENTRENADOR FROM ENTRENADOR WHERE NOMBRE = '" + entrena.getNombre() + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(selectID);
            ResultSet resultadoID = ps.executeQuery(selectID);
            while (resultadoID.next()) {
                id = resultadoID.getInt("id_entrenador");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    /**
     * Buscar el id del asistente A través del nombre.
     * @param asiste: Aistente con el que se interactua.
     * @return id: Id del asistente que se busca.
     */
    public static int obtenerIdAsistente(Asistente asiste) {
        int id = -1;
        try {
            String selectID = "SELECT ID_ASISTENTE FROM ASISTENTE WHERE NOMBRE = '" + asiste.getNombre() + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(selectID);
            ResultSet resultadoID = ps.executeQuery(selectID);
            while (resultadoID.next()) {
                id = resultadoID.getInt("id_asistente");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    /**
     * Buscar el id del jornada
     * @return id: Id del asistente que se busca.
     */
    public static int obtenerIdJornada() {
        int id = -1;
        try {
            String selectID = "SELECT MAX(ID_JORNADA) FROM JORNADA";
            PreparedStatement ps = conectarbbdd().prepareStatement(selectID);
            ResultSet resultadoID = ps.executeQuery(selectID);
            while (resultadoID.next()) {
                id = resultadoID.getInt("MAX(ID_JORNADA)");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    /**
     * Buscar el id del dueño A través del nombre.
     * @param due: Dueño con el que se interactua.
     * @return id: Id del dueño que se busca.
     */
    public static int obtenerIdDueno(Dueno due) {
        int id = -1;
        try {
            String selectID = "SELECT ID_DUENO FROM DUENO WHERE NOMBRE = '" + due.getNombre() + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(selectID);
            ResultSet resultadoID = ps.executeQuery(selectID);
            while (resultadoID.next()) {
                id = resultadoID.getInt("id_dueno");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    /**
     * Obtener toda la informacion del jugador.
     * @param jug: Jugador del que se quiere obtener la informacion.
     * @return juga:
     */
    public static Jugador infoJugadores(Object jug){
        Jugador juga = new Jugador();
        try {
            String select = "SELECT NOMBRE, SUELDO, TELEFONO, ROL FROM JUGADOR WHERE NICKNAME = '" + jug.toString() + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                juga.setNombre(resultado.getString("nombre"));
                juga.setTelefono(resultado.getString("telefono"));
                juga.setSueldo(resultado.getInt("sueldo"));
                juga.setRol(resultado.getString("rol"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return juga;
    }

    /**
     * Obtener toda la informacion del entrenador
     * @param entre: Entrenador del que se quiere obtener.
     * @return entre:
     */
    public static Entrenador infoEntrenadores(Object entre){
        Entrenador entrena = new Entrenador();
        try {
            String select = "SELECT TELEFONO, ANOS_EXP FROM ENTRENADOR WHERE NOMBRE = '" + entre.toString() + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                entrena.setTelefono(resultado.getString("telefono"));
                entrena.setAnosExp(resultado.getInt("anos_exp"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entrena;
    }

    /**
     * Obtener toda la informacion del dueño.
     * @param due: Dueño del que se quiere obtener.
     * @return dueno:
     */
    public static Dueno infoDueno(Object due){
        Dueno dueno = new Dueno();
        try {
            String select = "SELECT TELEFONO, NOMBRE_EMPRESA FROM DUENO WHERE NOMBRE = '" + due.toString() + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                dueno.setTelefono(resultado.getString("telefono"));
                dueno.setNombreEmpresa(resultado.getString("nombre_empresa"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dueno;
    }

    /**
     * Obtener toda la informacion del asistente.
     * @param asis: Asistente del que se quiere obtener.
     * @return asistente:
     */
    public static Asistente infoAsistente(Object asis){
        Asistente asistente = new Asistente();
        try {
            String select = "SELECT TELEFONO, DESCRIPCION_FUNCION FROM ASISTENTE WHERE NOMBRE = '" + asis.toString() + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                asistente.setTelefono(resultado.getString("telefono"));
                asistente.setDescripcionFuncion(resultado.getString("descripcion_funcion"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return asistente;
    }

    /**
     * Obtener toda la indormacion del equipo.
     * @param equi: Equipo del que se quiere obtener.
     * @return equipo:
     */
    public static Equipo infoEquipo(Object equi){
        Equipo equipo = new Equipo();
    try {
            String select = "SELECT ANO_CREACION, NACIONALIDAD FROM EQUIPO WHERE" +
                    " NOMBRE = '" + equi.toString() + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                equipo.setAnoCreacion(resultado.getInt("ano_creacion"));
                equipo.setNacionalidad(resultado.getString("nacionalidad"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return equipo;
    }

    /**
     * Obtener toda la informacion del usuario.
     * @param usu: Usuario del que se quiere obtener.
     * @return usuario:
     */
    public static Login infoUsuario(Object usu){
        Login usuario = new Login();
        try {
            String select = "SELECT PASS FROM LOGIN WHERE USUARIO = '" + usu.toString() + "'";
            PreparedStatement ps = conectarbbdd().prepareStatement(select);
            ResultSet resultado = ps.executeQuery(select);
            while (resultado.next()) {
                usuario.setPass(resultado.getString("pass"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

    /**
     * Validacion del telefono que sea numerico y longitud 9
     * @param tlf: Telefono a validar.
     * @return error: Devuelvo un verdadero o falso.
     */
    public static boolean validarTelefono(String tlf) {
        boolean error;
        Pattern pat = Pattern.compile("^[67]\\d{8}$");
        Matcher mat = pat.matcher(tlf);
        if (mat.matches()) {
            error = true;
        } else {
            JOptionPane.showMessageDialog(null, "Error: Introduzca un número de telefono valido");
            error = false;
        }
        return error;
    }
}