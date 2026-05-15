/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herenciapersona;

/**
 *
 * @author demon
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializacionProfesor {

     private static final String ARCHIVO_DATOS = "profesores.dat";

     public static void guardar(List<Profesor> profesores) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ARCHIVO_DATOS))) {
            oos.writeObject(profesores);
            System.out.println("Datos guardados exitosamente en '" + ARCHIVO_DATOS + "'.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }