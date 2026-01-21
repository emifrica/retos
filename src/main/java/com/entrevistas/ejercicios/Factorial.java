package com.entrevistas.ejercicios;

/*
  Calcula el factorial de un numero usando recursion
 */

public class Factorial {

    public static void main(String[] args) {
        int numero = 3;
        System.out.println( "El factorial de " + numero + " es : " + calculaFactorial(numero));
    }

    public static int calculaFactorial(int numero){
        if(numero == 1){
            return 1;
        }

        return numero * calculaFactorial (numero -1);
    }
}
