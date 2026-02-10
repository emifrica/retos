package com.entrevistas.ejercicios.otros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrama {


    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

     List<Integer> resultado = cuentaAnagramas(s, p);

        System.out.println(resultado);

    }

    static List<Integer> cuentaAnagramas(String uno, String dos){
        int longitudUno = uno.length();
        int longitudDos = dos.length();
        List<Integer> listaRes = new ArrayList<>();

        for (int i =0; i <= longitudUno - longitudDos;  i++){
            String subString  = uno.substring(i, i + longitudDos);
            if (isAnagram(subString,dos))
                listaRes.add(i);
        }
        return listaRes;
    }

    public static boolean isAnagram(String a, String b){
        if (a.length() != b.length())
            return false;
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        return Arrays.equals(arrA, arrB);
    }
}
