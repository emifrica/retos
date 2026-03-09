package com.entrevistas.ejercicios;

/*
 * Crea una función que reciba un texto y muestre cada palabra en una línea,
 * formando un marco rectangular de asteriscos.
 * - ¿Qué te parece el reto? Se vería así:
 *   **********
 *   * ¿Qué   *
 *   * te     *
 *   * parece *
 *   * el     *
 *   * reto?  *
 *   **********
 */

public class MarcoPalabras {

    public static void main(String[] args) {
        String cadena = "¿Que te parece el reto?";
        imprimeMarco(cadena);
    }

    public static void imprimeMarco(String palabras){
        String[] words =  palabras.split(" ");
        
        int masLarga = palabraMasLarga(words);
        imprimeLinea(masLarga);
        for(String word : words){
            System.out.print( "* ".concat(word));
            int espacios = masLarga - word.length();
            System.out.println(" ".repeat(espacios).concat(" *"));
        }
        imprimeLinea(masLarga);

    }

    private static void imprimeLinea(int masLarga) {
        System.out.println("*".repeat(masLarga + 4));
    }

    private static int palabraMasLarga(String[] words) {
        int masLarga = 0;
        for(String word : words){
            if (word.length() > masLarga){
                masLarga = word.length();
            }
        }
        return masLarga;
    }
}
