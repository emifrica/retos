package com.entrevistas.ejercicios;


/*
 * Crea un programa que sea capaz de transformar texto natural a código
 * morse y viceversa.
 * - Debe detectar automáticamente de qué tipo se trata y realizar
 *   la conversión.
 * - En morse se soporta raya "—", punto ".", un espacio " " entre letras
 *   o símbolos y dos espacios entre palabras "  ".
 * - El alfabeto morse soportado será el mostrado en
 *   https://es.wikipedia.org/wiki/Código_morse.
 */

import java.util.HashMap;
import java.util.Map;




public class CodigoMorse {

    private static final Map<Character, String> CHAR_A_MORSE = new HashMap<>();

    static {
        // Letras
        CHAR_A_MORSE.put('A', ".-");
        CHAR_A_MORSE.put('B', "-...");
        CHAR_A_MORSE.put('C', "-.-.");
        CHAR_A_MORSE.put('D', "-..");
        CHAR_A_MORSE.put('E', ".");
        CHAR_A_MORSE.put('F', "..-.");
        CHAR_A_MORSE.put('G', "--.");
        CHAR_A_MORSE.put('H', "....");
        CHAR_A_MORSE.put('I', "..");
        CHAR_A_MORSE.put('J', ".---");
        CHAR_A_MORSE.put('K', "-.-");
        CHAR_A_MORSE.put('L', ".-..");
        CHAR_A_MORSE.put('M', "--");
        CHAR_A_MORSE.put('N', "-.");
        CHAR_A_MORSE.put('O', "---");
        CHAR_A_MORSE.put('P', ".--.");
        CHAR_A_MORSE.put('Q', "--.-");
        CHAR_A_MORSE.put('R', ".-.");
        CHAR_A_MORSE.put('S', "...");
        CHAR_A_MORSE.put('T', "-");
        CHAR_A_MORSE.put('U', "..-");
        CHAR_A_MORSE.put('V', "...-");
        CHAR_A_MORSE.put('W', ".--");
        CHAR_A_MORSE.put('X', "-..-");
        CHAR_A_MORSE.put('Y', "-.--");
        CHAR_A_MORSE.put('Z', "--..");

        // Números
        CHAR_A_MORSE.put('0', "-----");
        CHAR_A_MORSE.put('1', ".----");
        CHAR_A_MORSE.put('2', "..---");
        CHAR_A_MORSE.put('3', "...--");
        CHAR_A_MORSE.put('4', "....-");
        CHAR_A_MORSE.put('5', ".....");
        CHAR_A_MORSE.put('6', "-....");
        CHAR_A_MORSE.put('7', "--...");
        CHAR_A_MORSE.put('8', "---..");
        CHAR_A_MORSE.put('9', "----.");

        // Caracteres especiales (opcional)
        CHAR_A_MORSE.put('.', ".-.-.-");
        CHAR_A_MORSE.put(',', "--..--");
        CHAR_A_MORSE.put('?', "..--..");
        CHAR_A_MORSE.put('\'', ".----.");
        CHAR_A_MORSE.put('!', "-.-.--");
        CHAR_A_MORSE.put('/', "-..-.");
        CHAR_A_MORSE.put('(', "-.--.");
        CHAR_A_MORSE.put(')', "-.--.-");
        CHAR_A_MORSE.put('&', ".-...");
        CHAR_A_MORSE.put(':', "---...");
        CHAR_A_MORSE.put(';', "-.-.-.");
        CHAR_A_MORSE.put('=', "-...-");
        CHAR_A_MORSE.put('+', ".-.-.");
        CHAR_A_MORSE.put('-', "-....-");
        CHAR_A_MORSE.put('_', "..--.-");
        CHAR_A_MORSE.put('"', ".-..-.");
        CHAR_A_MORSE.put('@', ".--.-.");
        CHAR_A_MORSE.put(' ', "/"); // Espacio entre palabras

    }

    public static void main(String[] args) {
        String palabra = """
                Armando Guerrero Gonzalez""";

        System.out.println( palabra + " a morse es: " + pasaAMorse(palabra));

    }

    public static String pasaAMorse(String palabra){
        StringBuilder morse = new StringBuilder();
        palabra = palabra.toUpperCase();

        for(char c : palabra.toCharArray()){
            if (CHAR_A_MORSE.containsKey(c)){
                morse.append(CHAR_A_MORSE.get(c));
                morse.append(" ");
            }
        }

        return morse.toString();

    }
}
