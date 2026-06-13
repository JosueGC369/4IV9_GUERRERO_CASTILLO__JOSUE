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

class SerializacionProfesor {

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

    @SuppressWarnings("unchecked")
    public static List<Profesor> cargar() {
        File archivo = new File(ARCHIVO_DATOS);

        if (!archivo.exists()) {
            System.out.println("No se encontro archivo de datos. Iniciando con lista vacia.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(ARCHIVO_DATOS))) {
            List<Profesor> profesores = (List<Profesor>) ois.readObject();
            System.out.println("Datos cargados exitosamente. " + profesores.size() + " profesores encontrados.");
            return profesores;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
