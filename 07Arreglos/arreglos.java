import java.util.Scanner;

public class arreglos{

    //vamos a realizar un arreglo unidimensional
    // un arreglo solo puede ser de un tipo de dato primitivo
    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);
        int j = 0;
/* 
        int arreglo[]= new int[10];

        int valor = 0;

        for(int j = 0; j < arreglo.length; j++){
            System.out.println("Ingresa los valores para el arreglo: ");
            arreglo[j] = entrada.nextInt();
        }

        for(int i = 0; i < arreglo.length; i++){
            System.out.println("Vamos a recorrer el arreglo: " + arreglo[i]);
        }
    }
    */

    int matriz[][] = new int[3][3];

    for(int i = 0; i < matriz.length; i++){
        //filas de la matriz
        System.out.println(i);
        for(j = 0; j < matriz.length; j++){
            //columnas
            System.out.println(j);
            System.out.println("Ingresa el valor de la fila: " + i + " ahora ingresa el valor de la columna: " + j);
            matriz[i][j] = entrada.nextInt();
        }
    }

    for(int i = 0; i < matriz.length; i++){
        //filas de la matriz
        System.out.println(i);
        for(j = 0; j < matriz.length; j++){
            //columnas
            System.out.println(j);
            
            
        }
        System.out.println("Mostrar la Matriz " + i +" "+ j);
    }
    }
 }