package com.entrevistas.ejercicios;

/*
 Escribe una función que calcule si un número dado es un número de Armstrong
 (o también llamado narcisista).
  Un número de Armstrong (también llamado número narcisista, número de pleno poder
  o número pluscuamperfecto) es un número que es igual a la suma de sus propios
  dígitos elevados a la potencia del número de dígitos.
 */

public class NumeroArmstrong {

    public static void main(String[] args) {

        Integer num = 153;
        System.out.println("El numero " + num + " es un numero Armstrong ? " +
                esNumeroArmstrong(num) );
    }

    private static boolean esNumeroArmstrong(Integer num) {
        String cadena = String.valueOf(num);
        double resultado = 0;

        int potencia = cadena.length();

        for( char c : cadena.toCharArray()){
            resultado += Math.pow(Integer.parseInt(String.valueOf(c)), potencia);
        }

        return resultado == num;

    }


}
