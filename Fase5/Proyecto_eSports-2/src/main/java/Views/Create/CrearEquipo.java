/**
 * @author: Equipo4
 * @version: 1
 */
package Views.Create;

import Controlador.Main;
import Modelo.Asistente;
import Modelo.Dueno;
import Modelo.Entrenador;
import Modelo.Equipo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CrearEquipo {
    public JPanel jCrearEquipo;
    private JLabel lTitulo;
    private JTextField tfNombre;
    private JTextField tfAñoCreacion;
    private JTextField tfNacionalidad;
    private JLabel lNombre;
    private JLabel lAñoCreacion;
    private JLabel lNacionalidad;
    private JLabel Dueño;
    private JLabel Entrenador;
    private JLabel Asistente;
    private JButton bCrear;
    private JButton bSalir;
    private JPanel jBotones;
    private JPanel jContenido;
    private JComboBox cbDueño;
    private JComboBox cbEntrenador;
    private JComboBox cbAsistente;

    public CrearEquipo() {
// lista con los dueños sin asignar a un equipo
        ArrayList<Dueno> listaDueños = Main.verNombreDuenos();
        for (Dueno dueno : listaDueños) {
            cbDueño.addItem(dueno);
        }
//Lista de lso entrenadores sin asignar a un equipo
        ArrayList<Entrenador> listaEntrenadores = Main.verNombreEntrenadores();
        for (Entrenador entrenador : listaEntrenadores) {
            cbEntrenador.addItem(entrenador);
        }
//Lista de los asistentes que no estan en un equipo
        ArrayList<Asistente> listaAsistente = Main.verNombreAsistentes();
        Asistente nulo = new Asistente();
        nulo.setNombre("Ningún asistente");
        cbAsistente.addItem(nulo);

        for (Asistente asistente : listaAsistente) {
            cbAsistente.addItem(asistente);
        }
        /**
         * A la hora de ejecutar el boton aceptar se crea un nuevo equipo con los datos obtenidos de la ventana,
         * diferenciando si hay asistente o no.
         */
        bCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbAsistente.getSelectedItem() == nulo) {
                    Main.generarEquipo(tfNombre.getText(), tfAñoCreacion.getText(),tfNacionalidad.getText(),
                            (Dueno) cbDueño.getSelectedItem(), (Entrenador) cbEntrenador.getSelectedItem());
                    Main.cerrarVentana();
                    Main.ventanaCrearEquipo();
                }
                else {
                    Main.generarEquipo(tfNombre.getText(), tfAñoCreacion.getText(),tfNacionalidad.getText(),
                            (Dueno) cbDueño.getSelectedItem(), (Entrenador) cbEntrenador.getSelectedItem(),
                            (Asistente) cbAsistente.getSelectedItem());
                    Main.cerrarVentana();
                    Main.ventanaCrearEquipo();
                }
            }
        });
        /**
         * A la hora de ejecutar el boton salir vuelve a la ventana del administrador.
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
