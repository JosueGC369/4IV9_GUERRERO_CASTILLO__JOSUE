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

public class DAOEstudiante {
    
    //vamos a crear un programa para dar de alta 10 estudiantes
    
    //un objeto por parte de estudiante
    Estudiante obj[] = new Estudiante[10];
    int x = 0;
    List<Estudiante> obj = SerializacionEstudiante.cargar();
    
    //metodo del menu para el programa
    void menu(){
        String var = "si";
        String mensaje = "";
        
        while(var.equalsIgnoreCase("si")){
            int op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingresa la opcion deseada : \n"
                    + "1.- Dar de alta a nuevo estudiante. \n"
                    + "2.- Mostrar los datos de todos los estudiantes \n"
                    + "3.- Editar los datos de un estudiante \n"
                    + "4.- Elininar un estudiante \n"
                    + "5.- Buscar estudiante por boleta \n"
                    + "6.- Guardar datos \n"));
            switch (op) {
                case 1:
                    //metodo para registrar
                    pedirEstudiante();                    
                    
                    break;
                case 2:
                    //mostrar estudiantes
                    mostrarEstudiante();

                    break;
                case 3:

                    editarEstudiante();

                    break;
                case 4:

                    eliminarEstudiante();

                    break;
                case 5:

                    buscarEstudiante();

                    break;
                case 6:

                    SerializacionEstudiante.guardar(obj);
                    JOptionPane.showMessageDialog(null, "Datos de estudiantes guardados correctamente.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
            mensaje = JOptionPane.showInputDialog("¿Desea repetir el programa?");
            var = mensaje; 
        }
    }

    public void pedirEstudiante() {

        if (x >= 10) {
            JOptionPane.showMessageDialog(null, "Ya no hay espacio para más estudiantes.");
            return;
        }
        
        int numboleta = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Ingresa la boleta del estudiante: "));
        String nom = JOptionPane.showInputDialog(
                "Ingresa el nombre del estudiante");
        int edad = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Ingresa la edad del estudiante: "));
        char gen = JOptionPane.showInputDialog(
                "Ingresa el genero del estudiante").charAt(0);
        
        obj[x] = new Estudiante(numboleta, nom, edad, gen);
        x++;
        JOptionPane.showMessageDialog(null, "Estudiante registrado correctamente.");
        
    }

    public void mostrarEstudiante() {
        //necesitamos recorrer el arreglo del tamaño que sea
        if (x == 0) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados.");
            return;
        }
        
        for(int i = 0; i < x; i++){
            //visualizar los datos
            JOptionPane.showMessageDialog(null, 
                    "La boleta del estudiante es: " + obj[i].getNumBoleta() + "\n"
                    +"El nombre del estudiante es: " + obj[i].getNombre()+ "\n"
                   +"La edad del estudiante es: " + obj[i].getEdad() + "\n"
                   +"El genero del estudiante es: " + obj[i].getGenero()+ "\n");
        }
    }

    public void editarEstudiante() {

        int boleta = Integer.parseInt(JOptionPane.showInputDialog(
                "Ingresa la boleta del estudiante que deseas editar: "));

        boolean econtrado = false;
        for (int i = 0; i < x; i++) {
            if (obj[i].getNumBoleta() == boleta) {
                String nuevoNombre = JOptionPane.showInputDialog(
                        "Ingresa el nuevo nombre del estudiante: ");
                int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog(
                        "Ingresa la nueva edad del estudiante: "));
                char nuevoGenero = JOptionPane.showInputDialog(
                        "Ingresa el nuevo genero del estudiante: ").charAt(0);

                obj[i].setNombre(nuevoNombre);
                obj[i].setEdad(nuevaEdad);
                obj[i].setGenero(nuevoGenero);

                JOptionPane.showMessageDialog(null, "Estudiante actualizado correctamente.");
                encontrado = true;
                break;
        }
    }
    if  (!encontrado) {
        JOptionPane.showMessageDialog(null, "No se encontro un estudiante con esa boleta.");
    }
}

public void eliminarEstudiante() {

     int boleta = Integer.parseInt(JOptionPane.showInputDialog(
                "Ingresa la boleta del estudiante que deseas eliminar: "));
    
    boolean encontrado = false;
    for (int i = 0; i < x; i++) {
        if (obj[i].getNumBoleta() == boleta) {
            for (int j = i; j < x - 1; j++) {
                obj[j] = obj[j + 1];
            }
            obj[x - 1] = null;
            x--;
            JOptionPane.showMessageDialog(null, "Estudiante eliminado correctamente.");
            encontrado = true;
            break;
        }
    }
    if (!encontrado) {
        JOptionPane.showMessageDialog(null, "No se encontro algun estudiante con esa boleta.");
    }
}

public void buscarEstudiante() {
    
    int boleta = Integer.parseInt(JOptionPane.showInputDialog(
        "Ingresa la boleta del estudiante que deseas buscar: "));
    
    boolean encontrado = false;
    for (int i = 0; i < x; i++) {
        if (obj[i].getNumBoleta() == boleta) {
            JOptionPane.showMessageDialog(null,
                    "Estudiante encontrado:\n"
                    + "La boleta del estudiante es: " + obj[i].getNumBoleta() + "\n"
                    + "La boleta del estudiante es: " + obj[i].getNumBoleta() + "\n"
                    + "La edad del estudiante es: " + obj[i].getEdad() + "\n"
                    + "El genero del estudiante es: " + obj[i].getGenero() + "\n");
            encontrado = true;
            break;
        }
    }
    if (!encontrado) {
        JOptionPane.showMessageDialog(null, "No se encontro un estudiante con esa boleta.");
    }
}   
}