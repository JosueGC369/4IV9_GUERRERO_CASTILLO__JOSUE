/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package herenciapersona;

/**
 *
 * @author demon
 */
import javax.swing.JOptionPane;

public class HerenciaPersona {

    public static void main(String[] args) {
        String var = "si";
        String mensaje = "";
        
        while(var.equalsIgnoreCase("si")){
            int op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Bienvenido. Selecciona una opcion: \n"
                    + "1.- CRUD de Estudiantes \n"
                    + "2.- CRUD de Profesores \n"));
                    
            switch (op) {
                case 1:
                    DAOEstudiante objEstudiante = new DAOEstudiante();
                    objEstudiante.menu();
                    break;
                case 2:
                    DAOProfesor objProfesor = new DAOProfesor();
                    objProfesor.menu();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
            mensaje = JOptionPane.showInputDialog("¿Desea volver al menu principal?");
            var = mensaje;
        }
        JOptionPane.showMessageDialog(null, "Programa terminado.");
    }
}