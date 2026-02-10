package com.entrevistas.ejercicios;


/*
 Se reciben dos cadenas, hay que ver que con las palabras de la segunda cadena
 se puede formar la primera palabra deben contener nel mismo numero o mayor en las
 palabras repetidas
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RetoMagazine {

    public static void main(String[] args) {
        String cadena1 = "esta es una cadena esta cadena o palabra palabra es de prueba prueba prueba palabra final";
        String cadena2 = "esta es otra una cadena esta cadena o palabra es de prueba anterior prueba prueba palabra final esta es";

        verificaPalabras(cadena1,cadena2);
    }

    private static void verificaPalabras(String cadena1, String cadena2) {
        Map<String, Integer> mapaWord1 = new HashMap<>();
        Map<String, Integer> mapaWord2 = new HashMap<>();
        boolean sonIguales = true;

        String word1[] = cadena1.toLowerCase().trim().split("\\s+");
        String word2[] = cadena2.toLowerCase().trim().split("\\s+");

        mapaWord1 = ArrayToMap(word1);
        mapaWord2 = ArrayToMap(word2);

        for(String palabra : mapaWord1.keySet()){
                if (mapaWord1.get(palabra) >  mapaWord2.get(palabra)){
                    sonIguales = false;
                }
        }
        System.out.println("El resultado es " + sonIguales);
    }

    private static Map<String, Integer> ArrayToMap(String[] word) {
        Map<String, Integer> resultado = new HashMap<>();

        for (String palabra : word) {
            resultado.put(palabra, resultado.getOrDefault(palabra, 0) + 1);
        }

        System.out.println("==========================================================");
        resultado.forEach((k,v) -> System.out.println( k + " -> "+ v));
        return resultado;
    }


}
