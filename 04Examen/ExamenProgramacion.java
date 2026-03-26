import java.util.Scanner;

public class ExamenProgramacion{

    static final double PRECIO_PORCELANATO = 22.35;
    static final double PRECIO_MARMOLEADO = 34.27;
    static final double PRECIO_ACRILICO = 22.94;
    static final double IVA = 0.16;
    static final double DESCUENTO = 0.0795;

    static String  nombre = "";
    static String  apPaterno = "";
    static String  apMaterno = "";
    static String  fechaNac = "";
    static String  direccion = "";
    static boolean datosCapturados = false;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean ejecutando = true;

        imprimirBienvenida();
        while(ejecutando){
            try{
                mostrarMenu();
                int opcion = leerEntero("Ingresa una opcion: ", 1, 5);

                switch (opcion){
                    case 1 -> capturarDatosComprador();
                    case 2 -> mostrarCatalogo();
                    case 3 -> calcularCotizacion();
                    case 4 -> nuevaCotizacion();
                    case 5 -> {
                        ejecutando = false;
                        imprimirDespedida();
                    }
                }

            } catch (Exception e){
                System.out.println("\n  ERROR " + e.getMessage());
                System.out.println("Regresando al menú principal");
                sc.nextLine();
            }
        }

        sc.close();
    }

    static void imprimirBienvenida() {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║        CALCULAELPISO — COTIZADOR DE PISO             ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
    }

    static void imprimirDespedida() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("  ║    ¡Gracias por usar CALCULAELPISO! Hasta pronto.    ║");
        System.out.println("  ╚══════════════════════════════════════════════════════╝\n");
    }

    static void mostrarMenu() {
        String estadoDatos = datosCapturados ? "Capturados" : "";
        System.out.println("\n┌──────────────────────────────────────────────────────┐");
        System.out.println("  │                    MENÚ PRINCIPAL                    │");
        System.out.println("  ├──────────────────────────────────────────────────────┤");
        System.out.printf( "  │  1. Datos del comprador%-29s│%n", estadoDatos);      
        System.out.println("  │  2. Catálogo de pisos                                │");
        System.out.println("  │  3. Calcular cotizacion                              │");
        System.out.println("  │  4. Nueva cotizacion                                 │");
        System.out.println("  │  5. SALIR                                            │");
        System.out.println("  └──────────────────────────────────────────────────────┘");
    }

    static void capturarDatosComprador() {
        System.out.println("\n══════════════════════════════════════════════════════");
        System.out.println("  OPCIÓN 1 — DATOS DEL COMPRADOR");
        System.out.println("  ══════════════════════════════════════════════════════");

        try {
            nombre    = leerTexto("Nombre: ");
            apPaterno = leerTexto("Apellido Paterno: ");
            apMaterno = leerTexto("Apellido Materno: ");
            fechaNac  = leerFecha("Fecha de Nacimiento");
            direccion = leerLinea("Dirección: ");

            datosCapturados = true;
            System.out.println("\n  Datos guardados.");

        } catch (Exception e) {
            System.out.println("\n  No se pudieron guardar los datos: " + e.getMessage());
            datosCapturados = false;
        }

        pausar();
    }

    static void mostrarCatalogo() {
        System.out.println("\n══════════════════════════════════════════════════════");
        System.out.println("  OPCIÓN 2 — CATALOGO DE PISOS");
        System.out.println("  ══════════════════════════════════════════════════════\n");

        try {
            String[] tipos   = { "Porcelanato", "Marmoleado ", "Acrílico   " };
            double[] precios = { PRECIO_PORCELANATO, PRECIO_MARMOLEADO, PRECIO_ACRILICO };

            System.out.println("  ┌─────┬─────────────────┬────────────┬──────────────┐");
            System.out.println("  │     │ Tipo de Piso    │  Precio/m² │    IVA 16%   │");
            System.out.println("  ├─────┼─────────────────┼────────────┼──────────────┤");

            for (int i = 0; i < tipos.length; i++) {
                try {
                    double conIva = calcularConIva(precios[i]);
                    System.out.printf("  │  %d  │ %s │  $%7.2f  │  $%9.2f  │%n",
                            i + 1, tipos[i], precios[i], conIva);

                } catch (ArithmeticException ae) {
                    System.out.printf("  │  %d  │ %s │  ERROR   │%n", i + 1, tipos[i]);
                }
            }

            System.out.println("  └─────┴─────────────────┴────────────┴──────────────┘");
            System.out.println("\n  Precio por metro cuadrado.");
            System.out.println("IVA del 16% incluido en la columna final.\n");

        } catch (Exception e) {
            System.out.println("\n  ERROR " + e.getMessage());
        }

        pausar();
    }

    static void calcularCotizacion() {
        if (!datosCapturados) {
            System.out.println("\n  Primero ingresa los datos del comprador.");
            pausar();
            return;
        }

        System.out.println("\n══════════════════════════════════════════════════════");
        System.out.println("  OPCIÓN 3 — CALCULAR COTIZACIÓN");
        System.out.println("  ══════════════════════════════════════════════════════");

        try {
            
            int numCuartos = leerEntero(
                "¿Cuantos cuartos tiene el inmueble? (2-4): ", 2, 4);

            double[] largos = new double[numCuartos];
            double[] anchos = new double[numCuartos];
            int[]    tipos  = new int[numCuartos];

            for (int i = 0; i < numCuartos; i++) {
                boolean cuartoValido = false;

                while (!cuartoValido) {
                    try {
                        System.out.println("\n  ┌─ CUARTO " + (i + 1)
                                + " " + "─".repeat(41) + "┐");
                        largos[i] = leerDecimal("  │  Largo (metros)     : ");
                        anchos[i] = leerDecimal("  │  Ancho (metros)     : ");
                        tipos[i]  = elegirTipoPiso();
                        System.out.println("  └" + "─".repeat(47) + "┘");
                        cuartoValido = true;

                    } catch (Exception e) {

                        System.out.println(" Error al guardar " + (i + 1)
                                + ": " + e.getMessage());
                        System.out.println(" Por favor reingresa los datos del cuarto.");
                    }
                }
            }

            imprimirCotizacion(largos, anchos, tipos, numCuartos);

        } catch (Exception e) {
            System.out.println("\n Ocurriao un problema en el calculo: "
                    + e.getMessage());
            pausar();
        }
    }

    static void imprimirCotizacion(double[] largos, double[] anchos,
                                    int[] tipos, int numCuartos) {
        try {
            double totalSinIva = 0;
            double totalIva = 0;
            double totalGeneral = 0;

            System.out.println(
                "\n══════════════════════════════════════════════════════");
            System.out.println("COTIZACION");
            System.out.println(
                "══════════════════════════════════════════════════════");
            System.out.printf("Cliente: %s %s %s%n",
                    nombre, apPaterno, apMaterno);
            System.out.printf("Nacimiento: %s%n", fechaNac);
            System.out.printf("Dirección : %s%n%n", direccion);

            System.out.println(
                "  ┌──────────┬──────────────────┬──────────┬────────────┬────────────┬────────────┐");
            System.out.println(
                "  │  Cuarto  │ Tipo de Piso     │  Área m² │  Subtotal  │  IVA 16%   │   Total    │");
            System.out.println(
                "  ├──────────┼──────────────────┼──────────┼────────────┼────────────┼────────────┤");

            for (int i = 0; i < numCuartos; i++) {
                try {
                    double area     = largos[i] * anchos[i];
                    double precioB  = obtenerPrecio(tipos[i]);

                    if (precioB <= 0)
                        throw new ArithmeticException("Precio invalido.");
                    if (area <= 0)
                        throw new ArithmeticException("Area invalida.");

                    double subtotal = area * precioB;
                    double iva      = subtotal * IVA;
                    double total    = subtotal + iva;

                    totalSinIva  += subtotal;
                    totalIva     += iva;
                    totalGeneral += total;

                    System.out.printf(
                        "  │ Cuarto %-2d │ %-16s │ %6.2f m² │ $%9.2f │ $%9.2f │ $%9.2f │%n",
                        i + 1, nombreTipo(tipos[i]), area, subtotal, iva, total);

                } catch (ArithmeticException ae){
                    System.out.printf(
                        "  │ Cuarto %-2d │ [ERROR: %-38s] │%n",
                        i + 1, ae.getMessage());
                }
            }

            System.out.println(
                "  ├──────────┴──────────────────┴──────────┼────────────┼────────────┼────────────┤");
            System.out.printf(
                "  │                             TOTALES    │ $%9.2f │ $%9.2f │ $%9.2f │%n",
                totalSinIva, totalIva, totalGeneral);
            System.out.println(
                "  └────────────────────────────────────────┴────────────┴────────────┴────────────┘");

            preguntarCompra(totalGeneral);

        } catch (Exception e) {
            System.out.println("\n  Fallo en la cotizacion: "
                    + e.getMessage());
            pausar();
        }
    }

    static void preguntarCompra(double totalGeneral) {
        System.out.println(
            "\n══════════════════════════════════════════════════════");
        System.out.println("  ¿ESTAS SEGURO DE REALIZAR LA COMPRA?");
        System.out.println(
            "══════════════════════════════════════════════════════");
        System.out.printf("  Total a pagar      : $%.2f%n", totalGeneral);
        System.out.println(
            "Descuento especial : 7.95% si confirma ahora.");

        try {
            System.out.print("\n  ¿Confirmarmas la compra? (S/N): ");
            String resp = sc.next().trim().toUpperCase();
            sc.nextLine();

            if (resp.equals("S")) {
                try {
                    double descuento  = totalGeneral * DESCUENTO;
                    double totalFinal = totalGeneral - descuento;

                    if (totalFinal < 0)
                        throw new ArithmeticException(
                            "El TOTAL FINAL no puede ser negativo.");

                    System.out.println(
                        "\n  ╔══════════════════════════════════════════════════╗");
                    System.out.println(
                        "  ║              ¡COMPRA EXITOSA!  ✓             ║");
                    System.out.println(
                        "  ╠══════════════════════════════════════════════════╣");
                    System.out.printf(
                        "  ║  Total original: $%10.2f                  ║%n",
                        totalGeneral);
                    System.out.printf(
                        "  ║  Descuento 7.95%%: -$%9.2f                  ║%n",
                        descuento);
                    System.out.println(
                        "  ║  ─────────────────────────────────────────────  ║");
                    System.out.printf(
                        "  ║  TOTAL FINAL: $%10.2f                  ║%n",
                        totalFinal);
                    System.out.println(
                        "  ╠══════════════════════════════════════════════════╣");

                    String nc = nombre + " " + apPaterno + " " + apMaterno;
                    System.out.printf("  ║  Comprador: %-37s║%n",
                        nc.length() > 37 ? nc.substring(0, 37) : nc);
                    System.out.println(
                        "  ╚══════════════════════════════════════════════════╝");

                } catch (ArithmeticException ae) {
                    System.out.println(
                        "\n  Cálculo de descuento fallido: "
                        + ae.getMessage());
                }
            } else if (resp.equals("N")) {
                System.out.println(
                    "\n  Compra No Exitosa. Puede regresar al menú.");
            } else {
                System.out.println(
                    "\n  No se reconoce la respuesta. Compra no procesada.");
            }
        } catch (Exception e) {
            System.out.println(
                "\n  No se pudo procesar la respuesta: "
                + e.getMessage());
            sc.nextLine();
        }
        preguntarNuevaCotizacion();
    }
    static void preguntarNuevaCotizacion() {
        try {
            System.out.println(
                "\n  ──────────────────────────────────────────────────────");
            System.out.print(
                "¿Deseas realizar otra cotizacion? (S/N): ");
            String resp = sc.next().trim().toUpperCase();
            sc.nextLine();
            if (resp.equals("S")) {
                limpiarDatos();
                System.out.println(
                    "\n  Datos reiniciados. Regresando al menu");
            } else {
                System.out.println("\n  Regresando al menu principal.");
            }
        } catch (Exception e) {
            System.out.println("\n  ERROR " + e.getMessage());
            sc.nextLine();
        }
    }
    static void nuevaCotizacion() {
        System.out.println(
            "\n══════════════════════════════════════════════════════");
        System.out.println("  OPCIÓN 4 — NUEVA COTIZACION");
        System.out.println(
              "══════════════════════════════════════════════════════");
        try {
            if (!datosCapturados) {
                System.out.println(
                    "No hay datos previos que limpiar.");
                pausar();
                return;
            }
            System.out.print(
                "¿Seguro que quieres limpiar todos los datos? (S/N): ");
            String resp = sc.next().trim().toUpperCase();
            sc.nextLine();
            if (resp.equals("S")) {
                limpiarDatos();
                System.out.println(
                    "Datos eliminados. Puede iniciar una nueva cotización.");
            } else {
                System.out.println("La operacion ha sido cancelada.");
            }
        } catch (Exception e) {
            System.out.println(
                "\n  No se pudo reiniciar: " + e.getMessage());
            sc.nextLine();
        }
        pausar();
    }
    static void limpiarDatos() {
        nombre = "";
        apPaterno = "";
        apMaterno = "";
        fechaNac = "";
        direccion = "";
        datosCapturados = false;
    }
    static int elegirTipoPiso() {
        System.out.println("  │  Tipo de piso:");
        System.out.printf( "  │    1. Porcelanato  ($%.2f/m²)%n",
                PRECIO_PORCELANATO);
        System.out.printf( "  │    2. Marmoleado   ($%.2f/m²)%n",
                PRECIO_MARMOLEADO);
        System.out.printf( "  │    3. Acrílico     ($%.2f/m²)%n",
                PRECIO_ACRILICO);
        return leerEntero("  │  Seleccione: ", 1, 3);
    }
    static double calcularConIva(double precioBase) {
        try {
            if (precioBase < 0)
                throw new IllegalArgumentException(
                    "Precio base negativo.");
            return precioBase * (1 + IVA);
        } catch (IllegalArgumentException e) {
            System.out.println(" ERROR DE IVA " + e.getMessage());
            return 0;
        }
    }
    static double obtenerPrecio(int tipo) {
        try {
            return switch (tipo) {
                case 1 -> PRECIO_PORCELANATO;
                case 2 -> PRECIO_MARMOLEADO;
                case 3 -> PRECIO_ACRILICO;
                default -> throw new IllegalArgumentException(
                    "Tipo de piso inválido: " + tipo);
            };
        } catch (IllegalArgumentException e) {
            System.out.println(" ERROR " + e.getMessage());
            return 0;
        }
    }
    static String nombreTipo(int tipo) {
        return switch (tipo) {
            case 1 -> "Porcelanato";
            case 2 -> "Marmoleado";
            case 3 -> "Acrílico";
            default -> "Desconocido";
        };
    }
    static int leerEntero(String mensaje, int min, int max) {
        int valor  = 0;
        boolean ok = false;

        while (!ok) {
            try {
                System.out.print(mensaje);
                valor = Integer.parseInt(sc.next().trim());

                if (valor < min || valor > max)
                    throw new IllegalArgumentException(
                        "El valor debe estar entre " + min + " y " + max + ".");
                ok = true;
            } catch (NumberFormatException e) {
                System.out.println(
                    "Solo se permiten números enteros.");
            } catch (IllegalArgumentException e) {
                System.out.println(" CUIDADO " + e.getMessage());
            } catch (Exception e) {
                System.out.println(" ERROR " + e.getMessage());
                sc.nextLine();
            }
        }
        return valor;
    }
    static double leerDecimal(String mensaje) {
        double valor = 0;
        boolean ok   = false;

        while (!ok) {
            try {
                System.out.print(mensaje);
                valor = Double.parseDouble(sc.next().trim());
                if (valor <= 0)
                    throw new IllegalArgumentException(
                        "El valor debe ser mayor a 0.");
                if (Double.isInfinite(valor) || Double.isNaN(valor))
                    throw new ArithmeticException(
                        "El valor esta fuera del rango numerico. Intentalo otra vez.");
                ok = true;
            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalido. Usa punto decimal.");
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println(" [!] " + e.getMessage());
            } catch (Exception e) {
                System.out.println(" ERROR " + e.getMessage());
                sc.nextLine();
            }
        }
        return valor;
    }
    static String leerTexto(String mensaje) {
        String texto = "";
        boolean ok   = false;
        while (!ok) {
            try {
                System.out.print(mensaje);
                texto = sc.next().trim();
                if (texto.isEmpty())
                    throw new IllegalArgumentException(
                        "No puede estar vacio el campo.");
                if (texto.matches(".*\\d.*"))
                    throw new IllegalArgumentException(
                        "El campo no puede contener numeros");
                ok = true;
            } catch (IllegalArgumentException e) {
                System.out.println(" [!] " + e.getMessage());
            } catch (Exception e) {
                System.out.println(" ERROR " + e.getMessage());
            }
        }
        return texto;
    }
    static String leerLinea(String mensaje) {
        String texto = "";
        boolean ok   = false;
        try { sc.nextLine(); } catch (Exception ignored) {}
        while (!ok) {
            try {
                System.out.print(mensaje);
                texto = sc.nextLine().trim();
                if (texto.isEmpty())
                    throw new IllegalArgumentException(
                        "La direccion no puede estar vacía.");
                if (texto.length() < 5)
                    throw new IllegalArgumentException(
                        "La direccion es demasiado corta o esta incompleta. Verificala.");
                ok = true;
            } catch (IllegalArgumentException e) {
                System.out.println(" [!] " + e.getMessage());
            } catch (Exception e) {
                System.out.println(" ERRO " + e.getMessage());
            }
        }
        return texto;
    }
    static String leerFecha(String mensaje) {
        String  fecha = "";
        boolean ok    = false;
        while (!ok) {
            try {
                System.out.print(mensaje + "(DD/MM/AAAA): ");
                fecha = sc.next().trim();
                if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}"))
                    throw new IllegalArgumentException(
                        "Formato incorrecto. Use DD/MM/AAAA (Ej: 15/03/1990).");
                String[] p = fecha.split("/");
                int dia = Integer.parseInt(p[0]);
                int mes = Integer.parseInt(p[1]);
                int anio = Integer.parseInt(p[2]);
                if (mes  < 1  || mes  > 12)
                    throw new IllegalArgumentException(
                        "El mes debe estar entre 01 y 12.");
                if (dia  < 1  || dia  > 31)
                    throw new IllegalArgumentException(
                        "El día debe estar entre 01 y 31.");
                if (anio < 1900 || anio > 2025)
                    throw new IllegalArgumentException(
                        "El año debe estar entre 1900 y 2025.");
                ok = true;
            } catch (NumberFormatException e) {
                System.out.println(
                    "La fecha es invalida contiene caracteres no numéricos.");
            } catch (IllegalArgumentException e) {
                System.out.println(" [!] " + e.getMessage());
            } catch (Exception e) {
                System.out.println(" ERROR " + e.getMessage());
                sc.nextLine();
            }
        }
        return fecha;
    }
    static void pausar() {
        try {
            System.out.print("\n  Presione Enter para continuar");
            sc.nextLine();
        } catch (Exception e) {
        }
    }
}