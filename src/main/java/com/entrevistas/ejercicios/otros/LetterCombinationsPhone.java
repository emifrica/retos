package com.entrevistas.ejercicios.otros;

import java.util.*;

public class LetterCombinationsPhone {

    // se remuev esta parte para inicializarlo dentro del la funcion
   /* private static final Map<Character, String> DIGIT_TO_LETTERS = createMapping();

    private static Map<Character, String> createMapping() {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return Collections.unmodifiableMap(map);
    } */

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }

        Map<Character, String> numeroALetras = new HashMap<>();
        numeroALetras.put('2', "abc");
        numeroALetras.put('3', "def");
        numeroALetras.put('4', "ghi");
        numeroALetras.put('5', "jkl");
        numeroALetras.put('6', "mno");
        numeroALetras.put('7', "pqrs");
        numeroALetras.put('8', "tuv");
        numeroALetras.put('9', "wxyz");

        Queue<String> cola = new LinkedList<>();
        cola.add("");

        for (char digito : digits.toCharArray()) {
            String letras = numeroALetras.get(digito);
            if (letras == null) continue; // ignora dígitos inválidos

            int currentSize = cola.size();
            for (int i = 0; i < currentSize; i++) {
                String prefix = cola.poll();
                for (char letter : letras.toCharArray()) {
                    cola.add(prefix + letter);
                }
            }
        }

        return new ArrayList<>(cola);
    }

    // --- Ejemplo de uso ---
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("79"));
    }
}
