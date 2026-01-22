package com.entrevistas.ejercicios;

/*
 * Escribe una función que reciba dos palabras (String) y retorne
 * verdadero o falso (Bool) según sean o no anagramas.
 * - Un Anagrama consiste en formar una palabra reordenando TODAS
 *   las letras de otra palabra inicial.
 * - NO hace falta comprobar que ambas palabras existan.
 * - Dos palabras exactamente iguales no son anagrama.
 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class Anagrama {


    public static void main(String[] args) {
        String palabra1 = "arma";
        String palabra2 = "rama";

        System.out.println( palabra1 + " y " + palabra2 + " son anagramas : " + verificaAnagrama(palabra1, palabra2) );

    }

    public static boolean verificaAnagrama (String word1, String word2){
        char[] palabra1 = word1.toCharArray();
        char[] palabra2 = word2.toCharArray();

        Arrays.sort(palabra1);
        Arrays.sort(palabra2);

        return Arrays.equals(palabra1, palabra2);


    }

}
