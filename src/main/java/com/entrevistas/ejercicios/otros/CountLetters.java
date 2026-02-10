package com.entrevistas.ejercicios.otros;

import java.util.HashMap;
import java.util.Map;

public class CountLetters {


    public static void main(String[] args){

        char[] chars1 = {'a','a','a','b','c','c','d','d','d','d'};
        System.out.println("Input: [\"a\",\"a\",\"a\",\"b\",\"c\",\"c\",\"d\",\"d\",\"d\",\"d\"]");
        System.out.println("Single Map Output: \"" + compress(chars1) + "\"");
        System.out.println();
    }

    public static StringBuilder compress (char[] chars){

        if (chars == null || chars.length == 0) {
            return new StringBuilder("");
        }

        StringBuilder compressed = new StringBuilder();
        Map<Character, Integer> compressedMap = new HashMap<>();

        for (Character caracter : chars){
            compressedMap.put(caracter, compressedMap.getOrDefault(caracter, 0) + 1);
        }

        compressedMap.forEach((clave, valor) -> {
            if ( valor > 1){
                compressed.append(clave).append(valor);
            } else{
                compressed.append(clave);
            }
        });
        return compressed;
    }
}
