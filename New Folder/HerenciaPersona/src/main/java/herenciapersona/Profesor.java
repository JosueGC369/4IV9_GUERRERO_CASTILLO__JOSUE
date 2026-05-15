/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herenciapersona;

/**
 *
 * @author demon
 */

public class Profesor extends Persona {

    private int numEmpleado;
    private String materia;
 
    public Profesor(int numEmpleado, String nom, int edad, char gen, String materia) {
        super(nom, edad, gen);
        this.numEmpleado = numEmpleado;
        this.materia = materia;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }
 
    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }
 
    public String getMateria() {
        return materia;
    }
 
    public void setMateria(String materia) {
        this.materia = materia;
    }
 
}