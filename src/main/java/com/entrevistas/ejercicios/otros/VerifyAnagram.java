package com.entrevistas.ejercicios.otros;

import java.util.HashMap;
import java.util.Map;

public class VerifyAnagram {

    public static void main(String[] args) {
        String s = "delira";
        String t = "lidera";

        Map<Character, Integer> mapaCadena1 = new HashMap<>();
        Map<Character, Integer> mapaCadena2 = new HashMap<>();

        mapaCadena1 = cuentaLetras(s);
        System.out.println(mapaCadena1);
        mapaCadena2 = cuentaLetras(t);
        System.out.println(mapaCadena2);

        if (mapaCadena1.equals(mapaCadena2)){
            System.out.println("Son Anagrama");
        } else {
            System.out.println("No son Anagrama");
        }
    }

    public static  Map<Character, Integer> cuentaLetras(String cadena){
        Map<Character, Integer> resultado = new HashMap<>();

        for(int i=0; i < cadena.length(); i++){

            resultado.put(cadena.charAt(i), resultado.getOrDefault(cadena.charAt(i), 0) + 1);

        }
        return resultado;
    }

}
