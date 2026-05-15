/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herenciapersona;

/**
 *
 * @author demon
 */

import javax.swing.JOptionPane;
import java.util.List;

public class DAOProfesor {

    List<Profesor> obj = SerializacionProfesor.cargar();

    void menu(){
        String var = "si";
        String mensaje = "";
        
        while(var.equalsIgnoreCase("si")){
            int op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingresa la opcion deseada : \n"
                    + "1.- Dar de alta a nuevo profesor. \n"
                    + "2.- Mostrar los datos de todos los profesores \n"
                    + "3.- Editar datos de un profesor \n"
                    + "4.- Eliminar un profesor \n"
                    + "5.- Buscar un profesor por numero de empleado \n"
                    + "6.- Guardar datos \n"));
             switch (op) {
                case 1:

                    pedirProfesor();

                    break;
                case 2:

                    mostrarProfesor();

                    break;
                case 3:

                    editarProfesor();

                    break;
                case 4:

                    eliminarProfesor();

                    break;
                case 5:

                    buscarProfesor();

                    break;
                case 6:

                    SerializacionProfesor.guardar(obj);
                    JOptionPane.showMessageDialog(null, "Datos de profesores guardados correctamente.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
            mensaje = JOptionPane.showInputDialog("¿Desea repetir el programa?");
            var = mensaje;
        }
    }

    public void pedirProfesor() {

        if (obj.size() >= 10) {
            JOptionPane.showMessageDialog(null, "Ya no hay espacio para mas profesores.");
            return;
        }

        int numEmpleado = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Ingresa el numero de empleado del profesor: "));
        String nom = JOptionPane.showInputDialog(
                "Ingresa el nombre del profesor");
        int edad = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Ingresa la edad del profesor: "));
        char gen = JOptionPane.showInputDialog(
                "Ingresa el genero del profesor").charAt(0);
        String materia = JOptionPane.showInputDialog(
                "Ingresa la materia que imparte el profesor: ");
        
        obj.add(new Profesor(numEmpleado, nom, edad, gen, materia));
        JOptionPane.showMessageDialog(null, "Profesor registrado correctamente.");
    }

    public void mostrarProfesor() {

        if (obj.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay profesores registrados.");
            return;
        }

        for(int i = 0; i < obj.size(); i++){
            JOptionPane.showMessageDialog(null, 
                    "El numero de empleado del profesor es: " + obj.get(i).getNumEmpleado() + "\n"
                    +"El nombre del profesor es: " + obj.get(i).getNombre()+ "\n"
                    +"La edad del profesor es: " + obj.get(i).getEdad() + "\n"
                    +"El genero del profesor es: " + obj.get(i).getGenero()+ "\n"
                    +"La materia que imparte es: " + obj.get(i).getMateria()+ "\n");
        }
    }

     public void editarProfesor() {

        int numEmpleado = Integer.parseInt(JOptionPane.showInputDialog(
                "Ingresa el numero de empleado del profesor que deseas editar: "));
        
        boolean encontrado = false;
        for (int i = 0; i < obj.size(); i++) {
            if (obj.get(i).getNumEmpleado() == numEmpleado) {
                String nuevoNombre = JOptionPane.showInputDialog(
                        "Ingresa el nuevo nombre del profesor: ");
                int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog(
                        "Ingresa la nueva edad del profesor: "));
                char nuevoGenero = JOptionPane.showInputDialog(
                        "Ingresa el nuevo genero del profesor: ").charAt(0);
                String nuevaMateria = JOptionPane.showInputDialog(
                        "Ingresa la nueva materia que imparte: ");
                
                obj.get(i).setNombre(nuevoNombre);
                obj.get(i).setEdad(nuevaEdad);
                obj.get(i).setGenero(nuevoGenero);
                obj.get(i).setMateria(nuevaMateria);

                JOptionPane.showMessageDialog(null, "Profesor actualizado correctamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontro un profesor con ese numero de empleado.");
        }
    }

    public void eliminarProfesor() {

        int numEmpleado = Integer.parseInt(JOptionPane.showInputDialog(
                "Ingresa la boleta del profesor que deseas eliminar: "));
        
        boolean encontrado = false;
        for (int i = 0; i < obj.size(); i++) {
            if (obj.get(i).getNumEmpleado() == numEmpleado) {
                obj.remove(i);
                JOptionPane.showMessageDialog(null, "Profesor eliminado correctamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontro un profesor con ese numero de empleado.");
        }
    }

    public void buscarProfesor() {
        
        int numEmpleado = Integer.parseInt(JOptionPane.showInputDialog(
                "Ingresa el numero de empleado del profesor que deseas buscar: "));
        
        boolean encontrado = false;
        for (int i = 0; i < obj.size(); i++) {
            if (obj.get(i).getNumEmpleado() == numEmpleado) {
                JOptionPane.showMessageDialog(null,
                        "Profesor encontrado:\n"
                        + "El numero de empleado del profesor es: " + obj.get(i).getNumEmpleado() + "\n"
                        + "El nombre del profesor es: " + obj.get(i).getNombre() + "\n"
                        + "La edad del profesor es: " + obj.get(i).getEdad() + "\n"
                        + "El genero del profesor es: " + obj.get(i).getGenero() + "\n"
                        + "La materia que imparte es: " + obj.get(i).getMateria() + "\n");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontro un profesor con ese numero de empleado.");
        }
    }
    
}