package com.entrevistas.ejercicios;

/*
 * Crea un programa se encargue de transformar un número
 * decimal a binario sin utilizar funciones propias del lenguaje que lo hagan directamente.
 */

public class DecimalABinario {

    public static void main(String[] args) {

        int numeroDecimal = 100;
        String binario =  DecimalABinario(numeroDecimal);

        System.out.println("El numero binario de " + numeroDecimal +  " es : " + binario);
    }

    public static String DecimalABinario(int numeroDecimal){

        String resultado = "";

        // se puede usar un StringBuilder yusar la funcion insert
        // y asi se evita voltear la cadena y usar ela funciona recursiva
        while(numeroDecimal >= 1){
           resultado = resultado.concat( String.valueOf( numeroDecimal % 2));
           numeroDecimal /= 2;

        }
        return invierteCadenaRecursivo(resultado);
    }

    private static String invierteCadenaRecursivo(String texto) {
        if (texto.length()  <= 1){
            return texto;
        }

        return texto.charAt(texto.length() -1) + invierteCadenaRecursivo(texto.substring(0, texto.length() -1 ));
    }
}
