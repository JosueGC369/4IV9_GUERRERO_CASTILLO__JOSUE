//librerias
import java.util.Scanner;
import java.lang.Math;

public class Figura{

    //vamos a colocar las variables globales
    double lado, altura, area, perimetro, base;
    int opcion;
    char letra;
    boolean esValido = false;

    //la instancia del objeto oara entrada de datos
    Scanner entrada = new Scanner(System.in);
    
    //datos
    public void menu(){

        //while(opcion >= 1 && opcion <= 7){
        do {
            System.out.println("Este es un programa para calcular Areas y Perimetros de Figuras Geometricas");
            System.out.println("1.- Triangulo");
            System.out.println("2.- Cuadrado");
            System.out.println("3.- Circulo");
            System.out.println("Agregar las otras opciones");
            System.out.println("Elija alguna de las opciones que son citadas");

            try{
                opcion = Integer.parseInt(entrada.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Solo se permiten numeros enteros, intente de nuevo");
                opcion = -1;
            }

            switch (opcion){
                case 1:
                    calcularTriangulo();
                    break;
                case 2:
                    calcularCuadrado();
                    break;
                case 3:
                    calcularCirculo();
                    break;
                default:
                    System.out.println("Gracias por ocuparme UwU");
                    break;
            }

            System.out.println("Si desea repetir el programa ingrese la letra S");
            try{
                String respuesta = entrada.nextLine().trim();
                if (respuesta.isEmpty()){
                    letra = ' ';
                } else{
                    letra = respuesta.charAt(0);
                }
            } catch (Exception e){
                System.out.println("No se pudo leer la respuesta: " + e.getMessage());
                letra = ' ';
            }

        } while (letra == 's' || letra == 'S');
    }

    public void calcularTriangulo(){
        System.out.println("Area y Perimetro de un Triangulo");
        System.out.println("Que tipo de triangulo desea calcular:");
        System.out.println("1.-Equilatero");
        System.out.println("2.-Isoseles");
        System.out.println("3.-Escaleno");

        try{
            opcion = Integer.parseInt(entrada.nextLine().trim());
        } catch (NumberFormatException e){
            System.out.println("Opcion no valida, regresando al menu");
            return;
        }

        switch (opcion){
            case 1:
                // P = 3 * lado   A = (b * a) / 2
                esValido = false;
                do{
                    System.out.println("Ingresa la base del triangulo:");
                    try{
                        base = Double.parseDouble(entrada.nextLine().trim());
                        if (base > 0){
                            esValido = true;
                        } else{
                            System.out.println("El valor debe ser mayor a cero");
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Eso no es un numero valido, intente de nuevo");
                    }
                } while (!esValido);

                esValido = false;
                do{
                    System.out.println("Ingresa la altura del triangulo:");
                    try{
                        altura = Double.parseDouble(entrada.nextLine().trim());
                        if (altura > 0){
                            esValido = true;
                        } else{
                            System.out.println("La altura debe ser mayor a cero");
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Eso no es un numero valido, intente de nuevo");
                    }
                } while (!esValido);

                try{
                    area = (base * altura) / 2;
                    perimetro = 3 * base;
                    System.out.println("Area del triangulo equilatero: " + area);
                    System.out.println("Perimetro del triangulo equilatero: " + perimetro);
                } catch (Exception e){
                    System.out.println("Ocurrio un problema al calcular: " + e.getMessage());
                }
                break;

            case 2:
                // P = 2 * l + b|  A = (b * a) / 2
                esValido = false;
                do{
                    System.out.println("Ingresa la base del triangulo:");
                    try{
                        base = Double.parseDouble(entrada.nextLine().trim());
                        if (base > 0){
                            esValido = true;
                        } else{
                            System.out.println("El valor debe ser mayor a cero");
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Dato no reconocido, escriba un numero");
                    }
                } while (!esValido);

                esValido = false;
                do{
                    System.out.println("Ingresa el lado igual del triangulo:");
                    try{
                        lado = Double.parseDouble(entrada.nextLine().trim());
                        if (lado > 0){
                            esValido = true;
                        } else{
                            System.out.println("El lado debe ser mayor a cero");
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Dato no reconocido, escriba un numero");
                    }
                } while (!esValido);

                esValido = false;
                do{
                    System.out.println("Ingresa la altura del triangulo:");
                    try{
                        altura = Double.parseDouble(entrada.nextLine().trim());
                        if (altura > 0){
                            esValido = true;
                        } else{
                            System.out.println("La altura debe ser mayor a cero");
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Dato no reconocido, escriba un numero");
                    }
                } while (!esValido);

                try{
                    area = (base * altura) / 2;
                    perimetro = (2 * lado) + base;
                    System.out.println("Area del triangulo isoseles: " + area);
                    System.out.println("Perimetro del triangulo isoseles: " + perimetro);
                } catch (Exception e){
                    System.out.println("Error al momento de calcular: " + e.getMessage());
                }
                break;

            case 3:
                // P = a + b + c    A = (b * a) / 2
                double ladoA = 0, ladoB = 0, ladoC = 0;

                esValido = false;
                do{
                    System.out.println("Ingresa el lado A:");
                    try{
                        ladoA = Double.parseDouble(entrada.nextLine().trim());
                        if (ladoA > 0){
                            esValido = true;
                        } else{
                            System.out.println("El lado debe ser positivo");
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Solo numeros por favor");
                    }
                } while (!esValido);

                esValido = false;
                do{
                    System.out.println("Ingresa el lado B:");
                    try{
                        ladoB = Double.parseDouble(entrada.nextLine().trim());
                        if (ladoB > 0){
                            esValido = true;
                        } else{
                            System.out.println("El lado debe ser positivo");
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Solo numeros por favor");
                    }
                } while (!esValido);

                esValido = false;
                do{
                    System.out.println("Ingresa el lado C (base):");
                    try{
                        ladoC = Double.parseDouble(entrada.nextLine().trim());
                        if (ladoC > 0){
                            esValido = true;
                        } else{
                            System.out.println("El lado debe ser positivo");
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Solo numeros por favor");
                    }
                } while (!esValido);

                esValido = false;
                do{
                    System.out.println("Ingresa la altura del triangulo:");
                    try{
                        altura = Double.parseDouble(entrada.nextLine().trim());
                        if (altura > 0){
                            esValido = true;
                        } else{
                            System.out.println("La altura debe ser positiva");
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Solo numeros por favor");
                    }
                } while (!esValido);

                try{
                    area = (ladoC * altura) / 2;
                    perimetro = ladoA + ladoB + ladoC;
                    System.out.println("Area del triangulo escaleno: " + area);
                    System.out.println("Perimetro del triangulo escaleno: " + perimetro);
                } catch (Exception e){
                    System.out.println("Error durante el calculo: " + e.getMessage());
                }
                break;

            default:
                System.out.println("Esa opcion no existe");
                break;
        }
    }

    public void calcularCuadrado() {
        esValido = false;
        do{
            System.out.println("Ingresa el lado del cuadrado:");
            try{
                lado = Double.parseDouble(entrada.nextLine().trim());
                if (lado > 0){
                    esValido = true;
                } else{
                    System.out.println("El lado debe ser un numero positivo");
                }
            } catch (NumberFormatException e){
                System.out.println("Entrada no valida, escriba un numero");
            }
        } while (!esValido);

        try{
            area = lado * lado;
            perimetro = 4 * lado;
            System.out.println("Area del cuadrado: " + area);
            System.out.println("Perimetro del cuadrado: " + perimetro);
        } catch (Exception e){
            System.out.println("Algo salio mal en el calculo: " + e.getMessage());
        }
    }

    public void calcularCirculo(){
        esValido = false;
        do{
            System.out.println("Ingresa el radio del circulo:");
            try{
                lado = Double.parseDouble(entrada.nextLine().trim());
                if (lado > 0){
                    esValido = true;
                } else{
                    System.out.println("El radio no puede ser negativo ni cero");
                }
            } catch (NumberFormatException e){
                System.out.println("Eso no parece un numero, intente otra vez");
            }
        } while (!esValido);

        try{
            area = Math.PI * Math.pow(lado, 2);
            perimetro = 2 * Math.PI * lado;
            System.out.println("Area del circulo: " + area);
            System.out.println("Perimetro (circunferencia) del circulo: " + perimetro);
        } catch (Exception e){
            System.out.println("Error inesperado en el calculo: " + e.getMessage());
        }
    }
}
