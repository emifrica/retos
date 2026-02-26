package com.entrevistas.ejercicios;

/*
 * Crea una función que reciba un String de cualquier tipo y se encargue de
 * poner en mayúscula la primera letra de cada palabra.
 * - No se pueden utilizar operaciones del lenguaje que
 *   lo resuelvan directamente.
 */

import java.util.Arrays;
import java.util.stream.Collectors;

public class ToUpperCase {

    public static void main(String[] args) {
        String palabra = "armando guerrero gonzalez";
        System.out.println("La cadena <<" + palabra + ">> en mayusculas es <<" + tranformaPalabra(palabra) + ">>");
        System.out.println("La cadena <<" + palabra + ">> en mayusculas es <<" + tranformaWord(palabra) + ">>");
        System.out.println("La cadena <<" + palabra + ">> en mayusculas es <<" + transWordStyream(palabra) + ">>");

    }

    private static String transWordStyream(String palabra) {

        return Arrays.stream(palabra.split("(?<=\\s)|(?=\\s)"))
                .map(ToUpperCase::aMayusculas)
                .collect(Collectors.joining());
    }

    private static String aMayusculas(String s) {

        char[] chars = s.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return new String(chars);

    }

    private static String tranformaWord(String palabra) {
        StringBuilder mayusculas = new StringBuilder();
        boolean esBlanco = true;

        for(Character c : palabra.toCharArray() ){
            if (Character.isWhitespace(c)){
                mayusculas.append(c);
                esBlanco = true;
            } else if (esBlanco){
                mayusculas.append(Character.toUpperCase(c));
                esBlanco = false;
            } else {
                mayusculas.append(c);
            }
        }
        return mayusculas.toString();
    }

    private static String tranformaPalabra(String palabra) {
        StringBuilder resultado = new StringBuilder();
        String[] palabras = palabra.trim().split("\\s+");
        for(String word : palabras){
            char[] caracteres = word.toCharArray();
            char c = caracteres[0];
            caracteres[0] = Character.toUpperCase(c);
            resultado.append(caracteres);
            resultado.append(" ");
        }
        resultado.deleteCharAt(resultado.length() -1);
        return resultado.toString();
    }
}
