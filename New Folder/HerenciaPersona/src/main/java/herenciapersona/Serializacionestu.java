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

public class SerializacionEstudiante {
    
    private static final String ARCHIVO_DATOS = "estudiantes.dat";

    public static void guardar(List<Estudiante> estudiantes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ARCHIVO_DATOS))) {
            oos.writeObject(estudiantes);
            System.out.println("Datos guardados exitosamente en '" + ARCHIVO_DATOS + "'.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Estudiante> cargar() {
        File archivo = new File(ARCHIVO_DATOS);

        if (!archivo.exists()) {
            System.out.println("No se encontró archivo de datos. Iniciando con lista vacía.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(ARCHIVO_DATOS))) {
            List<Estudiante> estudiantes = (List<Estudiante>) ois.readObject();
            System.out.println("Datos cargados exitosamente. " + estudiantes.size() + " estudiantes encontrados.");
            return estudiantes;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}

