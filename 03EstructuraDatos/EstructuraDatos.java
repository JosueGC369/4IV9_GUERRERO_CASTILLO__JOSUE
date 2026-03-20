/*
Vamos a rear 14 programas dnetro de un menu gigante
para poner a prueba sus conocimientos 
de algortimia
1.- Desarrollar un programa para calcular el bono de un descuento por edad
2.- Convertir numeros decimales a binarios
3.- Convertir temperaturas entre los 3 principales grados C -> F y K 
4.- Realizar un programa para contar numero de positivos y negavitosde una serie de numeros
5.- Desarrollar una tienda para agregar productos y precios
6.- Desarrollar un programa para calcular el area y perimetro de 5 diferentes figuras
7.- Desarrollar una tabla ahoria a ver de que se me ocurre
8.- Desarrollar un programa para calcular el factorial 
9.- Vamos hacer dibujitos wiiiii   triangulo equilatero     rombo
10.- Desarrollar una figura hueca
11.- 
12.- Realizar un diamante
13.- Desarrollar una calculadora basica + - * / para n numeros
*/

import java.util.Scanner;

class EstructuraDatos{

    public static void main(String[] args){
        //aqui van las variables
        int opcion;
        char repetir;
        float compra=0;
        boolean ejecutar = true;

        //aqui van los objetos
        Scanner entrada = new Scanner(System.in);

        //aqui va el menu

        do{
        System.out.println("Bienvenido a este programa para verificar que tanto saben programar a partir de algoritmos basicos.");
        System.out.println("Por favor elija la opción deseada:");
        System.out.println("1.- Descuento por edad");
        System.out.println("2.- Numeros decimales a binarios");
        System.out.println("3.- Convertir temperaturas");
        System.out.println("4.- Contador de numeros positivos y negativos");
        System.out.println("5.- Tiendita");
        System.out.println("6.- Calcular area y perimetro de figuras");
        System.out.println("7.- Tabla");
        System.out.println("8.- Calcular factorial con recursividad");
        System.out.println("9.- Dibujito wiiiiiiii");
        System.out.println("10.- Figura hueca");
        System.out.println("11.- Patrones");
        System.out.println("12.- Diamantito");
        System.out.println("13.- Calculadora basica");
        System.out.println("14.- Salir ");
        
        //entrada de dato
        opcion = entrada.nextInt();

        //ahora tengo que evaluar la entrada
        switch (opcion){
            case 1:
                System.out.println("Programa de descuento por edad");
                System.out.println("Ingresa la edad");
                int edad = entrada.nextInt();

                if(edad < 13){
                    System.out.println("Tiene descuento de 20%");
                }else{
                    System.out.println("No tiene descuento");
                }
                break;
            case 2:  
            //convertir un numero decimal a binario
            System.out.println("Ingrese un numero positivo entero que se desee convertir a binario");
            int numbinario;
            String guardarbinario ="";
            numbinario = entrada.nextInt();

            if(numbinario > 0){
                //realizamos el mod 2
                while(numbinario > 0){
                    if(numbinario%2 == 0){
                        guardarbinario = "0" + guardarbinario;

                    }else{
                        guardarbinario = "1" + guardarbinario;

                    }
                    numbinario = (int)numbinario/2;
                }

            }else if(numbinario == 0){
                
                guardarbinario = "0";
            }else{
               //aqui no se puede llegale
               guardarbinario = "No se puede convertir ese numero, solo acepta positivos";
            }
            System.out.println("El numero convertido a binario es: " + guardarbinario);
                
                break;
            case 3:
                System.out.println("Convertir temperaturas");
                System.out.println("1.- Celsius(C) a Fahrenheit(F) y Kelvin(K)");
                System.out.println("2.- Fahrenheit(F) a Celsius(C) y Kelvin(K)");
                System.out.println("3.- Kelvin(K) a Celsius(C) y Fahrenheit(F)");
                System.out.println("Ingresa la opcion deseada");
                int opTemp = entrada.nextInt();
                System.out.println("Ingresa la temperatura");
                float temp = entrada.nextFloat();
 
                if(opTemp == 1){
                    float fahrenheit = (temp * 9 / 5) + 32;
                    float kelvin = temp + 273.15f;
                    System.out.println("Temperatura en Fahrenheit(F): " + fahrenheit);
                    System.out.println("Temperatura en Kelvin(F): " + kelvin);
                }else if(opTemp == 2){
                    float celsius2 = (temp - 32) * 5 / 9;
                    float kelvin2 = celsius2 + 273.15f;
                    System.out.println("Temperatura en Celsius(C): " + celsius2);
                    System.out.println("Temperatura en Kelvin(K): " + kelvin2);
                }else if(opTemp == 3){
                    if(temp < 0) {
                        System.out.println("Kelvin no puede ser negativo");
                    }else{
                        float celsius3 = temp - 273.15f;
                        float fahrenheit3 = (celsius3 * 9 / 5) + 32;
                        System.out.println("Temperatura en Celsius(C): " + celsius3);
                        System.out.println("Temperatura en Fahrenheit(F): " + fahrenheit3);
                    }
                }else{
                    System.out.println("Opcion invalida");
                }
                break;
            
            case 4:
                System.out.println("Contador de numeros positivos y negativos");
                System.out.println("Ingresa la cantidad de numeros que vas a ingresar");
                int canum = entrada.nextInt();
 
                int positivo = 0;
                int negativo = 0;
                int cero = 0;
 
                for (int i = 1; i <= canum; i++){
                    System.out.println("Ingresa el numero " + i);
                    int num = entrada.nextInt();
                    if (num > 0){
                        positivo++;
                    }else if(num < 0){
                        negativo++;
                    }else{
                        cero++;
                    }
                }
                System.out.println("Numeros positivos: " + positivo);
                System.out.println("Numeros negativos: " + negativo);
                System.out.println("Ceros: " + cero);
                break;
            
            case 5:
                System.out.println("Bienvenido a esta hermosa tiendita linda y kawaii");
                System.out.println("Por favor ingrese cuantos elementos va a comprar");
                int elementosproducto = 0;
                elementosproducto = entrada.nextInt();
                if( elementosproducto > 0){
                    for(int i = 1; i<= elementosproducto; i++){
                        System.out.println("Ingresa el nombre del producto");
                        String nombreproducto="";
                        nombreproducto = entrada.next();
                        System.out.println("Ingrese el precio");
                        float precio=0;
                        precio = entrada.nextFloat();
                        float resultado;
                        System.out.println("Ingrese la cantidad de producto");
                        int cantidad=0;
                        precio = entrada.nextInt();
                        resultado = precio * cantidad;
                        
                        compra = resultado + compra;


                    }
                    System.out.println("El total de la compra es: " + compra);

                }else{
                    System.out.println("ingrese solo cantidades positivas");
                }
                
                break;
            case 6:
                System.out.println("1) Cuadrado");
                System.out.println("2) Rectangulo");
                System.out.println("39 Triangulo");
                System.out.println("4) Circulo");
                System.out.println("5) Pentagono");
                int fig = entrada.nextInt();
 
                switch (fig) {
                    case 1:
                        System.out.println("Ingresa el lado");
                        float lado = entrada.nextFloat();
                        System.out.println("Area: " + (lado * lado));
                        System.out.println("Perimetro: " + (lado * 4));
                        break;
                    case 2:
                        System.out.println("Ingresa la base");
                        float base = entrada.nextFloat();
                        System.out.println("Ingresa la altura");
                        float altura = entrada.nextFloat();
                        System.out.println("Area: " + (base * altura));
                        System.out.println("Perimetro: " + (2 * (base + altura)));
                        break;
                    case 3:
                        System.out.println("Ingresa la base");
                        float basetrian = entrada.nextFloat();
                        System.out.println("Ingresa la altura");
                        float alturatrian = entrada.nextFloat();
                        System.out.println("Area: " + ((basetrian * alturatrian) / 2));
                        break;
                    case 4:
                        System.out.println("Ingresa el radio");
                        float radio = entrada.nextFloat();
                        System.out.println("Area: " + (3.1416f * radio * radio));
                        System.out.println("Perimetro: " + (2 * 3.1416f * radio));
                        break;
                    case 5:
                        System.out.println("Ingresa el lado");
                        float ladopen = entrada.nextFloat();
                        System.out.println("Ingresa el apotema");
                        float apo = entrada.nextFloat();
                        float perimetrop = ladopen * 5;
                        System.out.println("Area: " + ((perimetrop * apo) / 2));
                        System.out.println("Perimetro: " + perimetrop);
                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
                break;
            
            case 7:
                //quiero dejarles una tabla de multiplicar
                //deberan de darle formato y titulos a cada columna
                for(int n = 1; n <= 10; n++){
                    System.out.println(
                        "| " + n + " | " + (n*10 + " " + (n*100) +" " + (n*1000)));
                }
                break;
            case 8:
                System.out.println("Ingresa un numero");
                int nFact = entrada.nextInt();
                if(nFact < 0){
                    System.out.println("El factorial no esta definido para negativos");
                }else{
                    int res = fact(nFact);
                    System.out.println("Factorial de " + nFact + " = " + res);
                }
                break;
            case 9:
                //vamos a realizar un cuadrado magico
                System.out.println("Vamos a realizar el dibujo de un cuadrado magico");
                System.out.println("Ingrese el tamaño del cuadrado");
                int n1= entrada.nextInt();

                if(n1 >= 1 && n1 <=20){
                    //se imprime
                    for(int i = 1; i <= n1; i++){
                        //recorro las columnas
                        //System.out.print(" 1 ");
                        for(int j = 1; j <= n1; j++){
                            System.out.print(" * ");

                        }
                        System.out.println("");
                    }
                    break;
                }else{
                    System.out.println("Por favor solo ingrese valores entre el 1 y el 20");
                }
                break;
            case 10:
                System.out.println("Ingresa el tamaño de la figura");
                int t = entrada.nextInt();
                for(int i = 1; i <= t; i++){
                    for(int j = 1; j <= t; j++){
                        if(i == 1 || i == t || j == 1 || j == t){
                            System.out.print("* ");
                        }else{
                            System.out.print("  ");
                        }
                    }
                    System.out.println();
                }
                break;
            case 11:
                System.out.println("Ingresa el tamañano");
                int p = entrada.nextInt();
                for(int i = 1; i <= p; i++) {
                    for(int j = 1; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            case 12:
                System.out.println("Ingresa el tamano");
                int d = entrada.nextInt();
                for(int i = 1; i <= d; i++){
                    for(int j = 1; j <= d - i; j++){
                        System.out.print(" ");
                    }
                    for(int j = 1; j <= (2 * i - 1); j++){
                        System.out.print("*");
                    }
                    System.out.println();
                 }
                for(int i = d - 1; i >= 1; i--){
                    for (int j = 1; j <= d - i; j++){
                        System.out.print(" ");
                    }
                    for(int j = 1; j <= (2 * i - 1); j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 13:
                System.out.println("Ingresa numero 1");
                    float a = entrada.nextFloat();
                    System.out.println("ingresa numero 2");
                    float b = entrada.nextFloat();
                    System.out.println("1) suma 2) resta 3) multipliacion 4 division");
                    int op2 = entrada.nextInt();
                    if(op2 == 1){
                        System.out.println(a + b);
                    }
                    if(op2 == 2){
                        System.out.println(a - b);
                    }
                    if(op2 == 3){
                        System.out.println(a * b);
                    }
                    if(op2 == 4){
                        System.out.println(a / b);
                    }
                    break;
            case 14:
                System.out.println("Saliendo del programa...");
                ejecutar = false;
                break;
 
            default:
                System.out.println("Opcion no valida, intente de nuevo");
        }
 
        if(ejecutar){
            System.out.println("Presione v para volver al menu");
            repetir = entrada.next().charAt(0);
            if (repetir != 'v') {
                ejecutar = false;
            }
        }
 
    }while(ejecutar);
 
}
public static int fact(int n){
    if (n == 0){
        return 1;
    }else{
        return n * fact(n - 1);
    }
}
 
}
