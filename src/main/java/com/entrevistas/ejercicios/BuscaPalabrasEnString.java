package com.entrevistas.ejercicios;

/*
  dan dos cadenas. crear un algoritmo para verificar que con las
  palabras de la segunda cadena se pude crear la cadena 1.
  Es decir que las palabras de la primer cadena existan en la segunda
 */

public class BuscaPalabrasEnString {

    public static void main(String[] args) {

        String palabra1 = "Armando Guerrero ";
        String palabra2 = "Esta  guerrero cadena es una prueba ";

        System.out.println("La palabaras existen : " + verfificaPalabras(palabra1, palabra2));

    }

    private static boolean verfificaPalabras(String palabra1, String palabra2) {
        int longitud = palabra1.trim().split("\\s+").length;
        String word2 = palabra2.trim().toUpperCase();
        int coincidencias = 0;
        String[] arrayPalabreas = palabra1.toUpperCase().trim().split("\\s+");

        for(String word : arrayPalabreas) {
            if (word2.contains(word)) {
                coincidencias++;
            }
        }

        return coincidencias == longitud;
    }
}
