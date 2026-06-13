import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Index {

    private static final Path ROOT = Paths.get("").toAbsolutePath();
    private static final String GITHUB = "https://github.com/JosueGC369/4IV9_GUERRERO_CASTILLO__JOSUE.git";

    private static final Practica[] PRACTICAS = {
        new Practica("01", "Hola Mundo", "01HolaMundo", "01HolaMundo", "HolaMundo"),
        new Practica("02", "Entrada de datos", "02EntradaDatos", "02EntradaDatos", "EntradaTexto"),
        new Practica("03", "Estructura de datos", "03EstructuraDatos", "03EstructuraDatos", "EstructuraDatos"),
        new Practica("04", "Examen de programacion", "04Examen", "04Examen", "ExamenProgramacion"),
        new Practica("05", "Clases", "05clases", "05clases", "Principal"),
        new Practica("06", "Figuras", "06Figura", "06Figura", "Main"),
        new Practica("07", "Arreglos", "07Arreglos", "07Arreglos", "arreglos"),
        new Practica("08", "Herencia", "08Herencia", "08Herencia", "Principal"),
        new Practica("09", "Serializacion", "10Serializacion", "10Serializacion", "Principal"),
        new Practica("10", "ArrayList", "11ArrayList", "11ArrayList/src/main/java/principal", "principal.App"),
        new Practica("11", "Ventana", "13Ventana", "13Ventana", "Ventana"),
        new Practica("12", "CRUD con SQL", "14CRUDSQL/CRUDSQL", "14CRUDSQL/CRUDSQL/src/main/java/crudsql", "crudsql.CRUDSQL"),
        new Practica("13", "Herencia Persona", "New Folder/HerenciaPersona", "New Folder/HerenciaPersona/src/main/java/herenciapersona", "herenciapersona.HerenciaPersona")
    };

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            System.out.print("Elige una opcion: ");
            String opcion = entrada.nextLine().trim();

            if (opcion.equals("0")) {
                System.out.println("Programa terminado.");
                return;
            }

            try {
                int numero = Integer.parseInt(opcion);

                if (numero < 1 || numero > PRACTICAS.length) {
                    System.out.println("Opcion no valida.");
                    pausar(entrada);
                    continue;
                }

                abrirPractica(PRACTICAS[numero - 1]);
                pausar(entrada);
            } catch (NumberFormatException error) {
                System.out.println("Opcion no valida.");
                pausar(entrada);
            } catch (Exception error) {
                System.out.println("No se pudo abrir la practica.");
                System.out.println(error.getMessage());
                pausar(entrada);
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n========================================");
        System.out.println("PORTAFOLIO DE EVIDENCIAS");
        System.out.println("GitHub: " + GITHUB);
        System.out.println("========================================");

        for (int i = 0; i < PRACTICAS.length; i++) {
            System.out.println((i + 1) + ".- " + PRACTICAS[i].nombre);
        }

        System.out.println("0.- Salir");
        System.out.println("========================================");
    }

    private static void abrirPractica(Practica practica) throws IOException, InterruptedException {
        Path build = ROOT.resolve(".index-build").resolve(practica.numero);
        Files.createDirectories(build);

        List<String> fuentes = obtenerFuentes(ROOT.resolve(practica.carpetaFuentes));
        if (fuentes.isEmpty()) {
            System.out.println("No se encontraron archivos para esta practica.");
            return;
        }

        System.out.println("\nPreparando: " + practica.nombre);

        List<String> compilar = new ArrayList<>();
        compilar.add("javac");
        compilar.add("-encoding");
        compilar.add("UTF-8");
        compilar.add("-d");
        compilar.add(build.toString());
        compilar.addAll(fuentes);

        if (ejecutar(compilar, ROOT.toFile()) != 0) {
            System.out.println("La practica no pudo prepararse.");
            return;
        }

        System.out.println("Abriendo: " + practica.nombre + "\n");

        List<String> ejecutar = new ArrayList<>();
        ejecutar.add("java");
        ejecutar.add("-cp");
        ejecutar.add(build.toString());
        ejecutar.add(practica.clasePrincipal);

        int salida = ejecutar(ejecutar, ROOT.resolve(practica.carpetaEjecucion).toFile());
        if (salida != 0) {
            System.out.println("La practica termino con un aviso.");
        }
    }

    private static List<String> obtenerFuentes(Path carpeta) throws IOException {
        List<String> fuentes = new ArrayList<>();

        try (Stream<Path> archivos = Files.walk(carpeta)) {
            archivos
                    .filter(Files::isRegularFile)
                    .filter(archivo -> archivo.toString().endsWith(".java"))
                    .forEach(archivo -> fuentes.add(archivo.toString()));
        }

        return fuentes;
    }

    private static int ejecutar(List<String> comando, File carpeta) throws IOException, InterruptedException {
        ProcessBuilder proceso = new ProcessBuilder(comando);
        proceso.directory(carpeta);
        proceso.inheritIO();
        return proceso.start().waitFor();
    }

    private static void pausar(Scanner entrada) {
        System.out.print("\nPresiona Enter para volver al menu...");
        entrada.nextLine();
    }

    private static class Practica {
        private final String numero;
        private final String nombre;
        private final String carpetaEjecucion;
        private final String carpetaFuentes;
        private final String clasePrincipal;

        private Practica(String numero, String nombre, String carpetaEjecucion, String carpetaFuentes, String clasePrincipal) {
            this.numero = numero;
            this.nombre = nombre;
            this.carpetaEjecucion = carpetaEjecucion;
            this.carpetaFuentes = carpetaFuentes;
            this.clasePrincipal = clasePrincipal;
        }
    }
}
