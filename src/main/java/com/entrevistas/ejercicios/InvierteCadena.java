package com.entrevistas.ejercicios;

import java.util.Arrays;

public class InvierteCadena {

    public static void main(String[] args) {
        invierteCadena("Armando");

        String volteada  = invierteCadenaRecursivo("Armando");
        System.out.println( ">>> con recursion : La cadena Armando se invierte en " + volteada);
    }

    private static String invierteCadenaRecursivo(String texto) {
        if (texto.length()  <= 1){
            return texto;
        }

        return texto.charAt(texto.length() -1) + invierteCadenaRecursivo(texto.substring(0, texto.length() -1 ));
    }

    private static void invierteCadena(String cadena) {

        int izq = 0;
        int der = cadena.length() - 1;
        char tempo;
        char[] palabra = cadena.toCharArray();

        do {
            tempo = palabra[der];
            palabra[der] = palabra[izq];
            palabra[izq] = tempo;
            izq++;
            der--;

        } while  (izq < der);

        System.out.println( "La cadena " + cadena + " se invierte en " + Arrays.toString(palabra));

        // con recursion

    }
}
