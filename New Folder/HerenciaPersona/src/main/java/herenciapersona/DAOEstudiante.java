package herenciapersona;

import javax.swing.JOptionPane;
import java.util.List;

public class DAOEstudiante {

    List<Estudiante> obj = SerializacionEstudiante.cargar();

    void menu() {
        String var = "si";
        String mensaje = "";

        while (var.equalsIgnoreCase("si")) {
            int op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingresa la opcion deseada : \n"
                    + "1.- Dar de alta a nuevo estudiante. \n"
                    + "2.- Mostrar los datos de todos los estudiantes \n"
                    + "3.- Editar los datos de un estudiante \n"
                    + "4.- Eliminar un estudiante \n"
                    + "5.- Buscar estudiante por boleta \n"
                    + "6.- Guardar datos \n"));

            switch (op) {
                case 1:
                    pedirEstudiante();
                    break;
                case 2:
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

            mensaje = JOptionPane.showInputDialog("Desea repetir el programa?");
            var = mensaje;
        }
    }

    public void pedirEstudiante() {
        if (obj.size() >= 10) {
            JOptionPane.showMessageDialog(null, "Ya no hay espacio para mas estudiantes.");
            return;
        }

        int numboleta = Integer.parseInt(
                JOptionPane.showInputDialog("Ingresa la boleta del estudiante: "));
        String nom = JOptionPane.showInputDialog("Ingresa el nombre del estudiante");
        int edad = Integer.parseInt(
                JOptionPane.showInputDialog("Ingresa la edad del estudiante: "));
        char gen = JOptionPane.showInputDialog("Ingresa el genero del estudiante").charAt(0);

        obj.add(new Estudiante(numboleta, nom, edad, gen));
        JOptionPane.showMessageDialog(null, "Estudiante registrado correctamente.");
    }

    public void mostrarEstudiante() {
        if (obj.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados.");
            return;
        }

        for (Estudiante estudiante : obj) {
            mostrarDatos(estudiante);
        }
    }

    public void editarEstudiante() {
        int boleta = Integer.parseInt(JOptionPane.showInputDialog(
                "Ingresa la boleta del estudiante que deseas editar: "));

        Estudiante estudiante = encontrarEstudiante(boleta);

        if (estudiante == null) {
            JOptionPane.showMessageDialog(null, "No se encontro un estudiante con esa boleta.");
            return;
        }

        String nuevoNombre = JOptionPane.showInputDialog("Ingresa el nuevo nombre del estudiante: ");
        int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la nueva edad del estudiante: "));
        char nuevoGenero = JOptionPane.showInputDialog("Ingresa el nuevo genero del estudiante: ").charAt(0);

        estudiante.setNombre(nuevoNombre);
        estudiante.setEdad(nuevaEdad);
        estudiante.setGenero(nuevoGenero);

        JOptionPane.showMessageDialog(null, "Estudiante actualizado correctamente.");
    }

    public void eliminarEstudiante() {
        int boleta = Integer.parseInt(JOptionPane.showInputDialog(
                "Ingresa la boleta del estudiante que deseas eliminar: "));

        Estudiante estudiante = encontrarEstudiante(boleta);

        if (estudiante == null) {
            JOptionPane.showMessageDialog(null, "No se encontro algun estudiante con esa boleta.");
            return;
        }

        obj.remove(estudiante);
        JOptionPane.showMessageDialog(null, "Estudiante eliminado correctamente.");
    }

    public void buscarEstudiante() {
        int boleta = Integer.parseInt(JOptionPane.showInputDialog(
                "Ingresa la boleta del estudiante que deseas buscar: "));

        Estudiante estudiante = encontrarEstudiante(boleta);

        if (estudiante == null) {
            JOptionPane.showMessageDialog(null, "No se encontro un estudiante con esa boleta.");
        } else {
            mostrarDatos(estudiante);
        }
    }

    private Estudiante encontrarEstudiante(int boleta) {
        for (Estudiante estudiante : obj) {
            if (estudiante.getNumBoleta() == boleta) {
                return estudiante;
            }
        }

        return null;
    }

    private void mostrarDatos(Estudiante estudiante) {
        JOptionPane.showMessageDialog(null,
                "La boleta del estudiante es: " + estudiante.getNumBoleta() + "\n"
                + "El nombre del estudiante es: " + estudiante.getNombre() + "\n"
                + "La edad del estudiante es: " + estudiante.getEdad() + "\n"
                + "El genero del estudiante es: " + estudiante.getGenero() + "\n");
    }
}
