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

public class DAOEstudiante {
    
    //vamos a crear un programa para dar de alta 10 estudiantes
    
    //un objeto por parte de estudiante
    Estudiante obj[] = new Estudiante[10];
    int x = 0;
    
    //metodo del menu para el programa
    void menu(){
        String var = "si";
        String mensaje = "";
        
        while(var.equalsIgnoreCase("si")){
            int op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingresa la opcion deseada : \n"
                    + "1.- Dar de alta a nuevo estudiante. \n"
                    + "2.- Mostrar los datos de todos los estudiantes \n"));
            switch (op) {
                case 1:
                    //metodo para registrar
                    pedirEstudiante();                    
                    
                    break;
                case 2:
                    //mostrar estudiantes
                    mostrarEstudiante();
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
            mensaje = JOptionPane.showInputDialog("¿Desea repetir el programa?");
        }
    }

    public void pedirEstudiante() {
        
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
        
        
    }

    public void mostrarEstudiante() {
        //necesitamos recorrer el arreglo del tamaño que sea
        
        for(int i = 0; i < x; i++){
            //visualizar los datos
            JOptionPane.showMessageDialog(null, 
                    "La boleta del estudiante es: " + obj[i].getNumBoleta() + "\n"
                    +"El nombre del estudiante es: " + obj[i].getNombre()+ "\n"
                   +"La edad del estudiante es: " + obj[i].getEdad() + "\n"
                   +"El genero del estudiante es: " + obj[i].getGenero()+ "\n");
        }
    }
    
}