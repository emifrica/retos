package com.entrevistas.ejercicios;

/*
 * Crea una función que reciba dos cadenas como parámetro (str1, str2)
 * e imprima otras dos cadenas como salida (out1, out2).
 * - out1 contendrá todos los caracteres presentes en la str1 pero NO
 *   estén presentes en str2.
 * - out2 contendrá todos los caracteres presentes en la str2 pero NO
 *   estén presentes en str1.
 */

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EliminaCaracteres {

    public static void main(String[] args) {
        String cadena1 = "armando";
        String cadena2 = "guerrero";

        String out1 = filtraLetras(cadena1, cadena2);
        String out2 = filtraLetras(cadena2, cadena1);

        System.out.println(cadena1 + " letras filtradas ===> " + out1);
        System.out.println(cadena2 + " letras filtradas ===> " + out2);

        //utilizando set
        Set<Character> set1 = pasaSet(cadena1);
        Set<Character> set2 = pasaSet(cadena2);

        // Obtener diferencias usando removeAll (modifica set1)
        Set<Character> dif1 = new HashSet<>(set1);
        dif1.removeAll(set2);

        Set<Character> dif2 = new HashSet<>(set2);
        dif2.removeAll(set1);

        //Pasar a cadena
        String res1 = setToString(dif1);
        String res2 = setToString(dif2);

        System.out.println("==================   SET   =========================");
        System.out.println(cadena1 + " letras filtradas ===> " + res1);
        System.out.println(cadena2 + " letras filtradas ===> " + res2);

        System.out.println("==================   STREAMS   =========================");
        Set<Character> chars1 = cadena1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        Set<Character> chars2 = cadena2.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        String response1 = chars1.stream()
                .filter(c -> !chars2.contains(c))
                .map(String::valueOf)
                .collect(Collectors.joining());

        String response2 = chars2.stream()
                .filter(c -> !chars1.contains(c))
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(cadena1 + " letras filtradas ===> " + response1);
        System.out.println(cadena2 + " letras filtradas ===> " + response2);
    }

    private static String setToString(Set<Character> dif) {
        StringBuilder res = new StringBuilder();

        for(char c : dif){
            res.append(c);
        }

        return res.toString();
    }

    private static Set<Character> pasaSet(String cadena) {
        Set<Character> set = new HashSet<>();
        for (char c : cadena.toCharArray()){
            set.add(c);
        }
        return set;
    }

    private static String filtraLetras(String cadena1, String cadena2) {
        StringBuilder salida = new StringBuilder();

        for( Character c : cadena1.toCharArray()){
            if (!cadena2.contains(c.toString())){
                salida.append(c);
            }
        }
        return salida.toString();
    }


}
