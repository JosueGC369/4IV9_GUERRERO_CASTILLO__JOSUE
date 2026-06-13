package principal;

import java.util.Scanner;

public class VistaPersona {

    private final ControladorPersona controlador = new ControladorPersona();
    private final Scanner entrada = new Scanner(System.in);

    public void Principal() {
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\nMenu de personas");
            System.out.println("1.- Registrar persona");
            System.out.println("2.- Mostrar personas");
            System.out.println("3.- Buscar persona");
            System.out.println("4.- Salir");
            System.out.print("Elige una opcion: ");

            opcion = leerNumero();

            switch (opcion) {
                case 1:
                    registrarPersona();
                    break;
                case 2:
                    mostrarPersonas();
                    break;
                case 3:
                    buscarPersona();
                    break;
                case 4:
                    System.out.println("Saliendo de ArrayList...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    private void registrarPersona() {
        System.out.print("Id: ");
        int id = leerNumero();
        entrada.nextLine();

        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Edad: ");
        int edad = leerNumero();

        controlador.registrarPersona(new Persona(id, nombre, edad));
        System.out.println("Persona registrada.");
    }

    private void mostrarPersonas() {
        if (controlador.mostrarPersonas().isEmpty()) {
            System.out.println("No hay personas registradas.");
            return;
        }

        for (Persona persona : controlador.mostrarPersonas()) {
            imprimirPersona(persona);
        }
    }

    private void buscarPersona() {
        System.out.print("Id a buscar: ");
        int id = leerNumero();
        Persona persona = controlador.buscarPersona(id);

        if (persona.getNombre() == null) {
            System.out.println("Persona no encontrada.");
        } else {
            imprimirPersona(persona);
        }
    }

    private int leerNumero() {
        while (!entrada.hasNextInt()) {
            System.out.print("Ingresa un numero valido: ");
            entrada.next();
        }

        return entrada.nextInt();
    }

    private void imprimirPersona(Persona persona) {
        System.out.println("Id: " + persona.getId()
                + " | Nombre: " + persona.getNombre()
                + " | Edad: " + persona.getEdad());
    }
}
