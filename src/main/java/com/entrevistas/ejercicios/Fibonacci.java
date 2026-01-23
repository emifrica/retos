package com.entrevistas.ejercicios;

/*
 * Escribe un programa que imprima los 50 primeros números de la sucesión
 * de Fibonacci empezando en 0.
 * - La serie Fibonacci se compone por una sucesión de números en
 *   la que el siguiente siempre es la suma de los dos anteriores.
 *   0, 1, 1, 2, 3, 5, 8, 13...
 */


import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        imprimeFibonacci(50);
    }

    public static void imprimeFibonacci(int numero){
        long[] numerosFibonacci = new long[50];

        numerosFibonacci[0] = 0;
        numerosFibonacci[1] = 1;

        for(int i = 2; i <= 49; i++){
            numerosFibonacci[i] = numerosFibonacci[i -1] + numerosFibonacci[i-2];
        }

        System.out.println(Arrays.toString(numerosFibonacci));

    }
}
