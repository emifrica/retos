package com.entrevistas.ejercicios;

import java.util.HashSet;
import java.util.Set;

/*
 * Crea dos funciones, una que calcule el máximo común divisor (MCD) y otra
 * que calcule el mínimo común múltiplo (mcm) de dos números enteros.
 * - No se pueden utilizar operaciones del lenguaje que
 *   lo resuelvan directamente.
 */
public class MaximoDivisorMinimoMultiplo {

    public static void main(String[] args) {
        int operador1 = 12;
        int operador2 = 18;

        int maxComunDivisor = calculaMaximoComunDivisor(operador1, operador2);
        System.out.printf("Maximo Comun Divisor de %d y %d es: %d", operador1, operador2, maxComunDivisor);
        
        int minComunMultiplo = calculaMinimoComunMultiplo(operador1, operador2);
        System.out.println("");
        System.out.printf("Minimo Comun Multiplo de %d y %d es: %d", operador1, operador2, minComunMultiplo);

        /**
         * Calcula el Máximo Común Divisor (MCD)
         * usando el algoritmo de Euclides. MCD = (b, a%b) hasta que b = 0
         */
        int mcd = obtenMCD(operador1, operador2);
        System.out.printf("%n");
        System.out.printf("Maximo Comun Divisor de %d y %d es: %d", operador1, operador2, mcd);

        /**
         * Calcula el Mínimo Común Múltiplo (MCM)
         * basado en la relación matemática con el MCD. mcd = a / mcd(a,b) * b
         */
        int mcm = obtenMCM(operador1, operador2);
        System.out.printf("%n");
        System.out.printf("Maximo Comun Divisor de %d y %d es: %d", operador1, operador2, mcm);


    }

    private static int obtenMCM(int operador1, int operador2) {
        if (operador1 == 0 || operador2 == 0)
            return 0;

        return operador1 / obtenMCD(operador1, operador2) * operador2;
    }

    private static int obtenMCD(int operador1, int operador2) {
        int a = Math.abs(operador1);
        int b = Math.abs(operador2);

        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int calculaMinimoComunMultiplo(int operador1, int operador2) {
        int operadorMaximo = Math.max(operador1, operador2);
        int operadorMinimo = Math.min(operador1, operador2);
        int indice = 1;
        boolean bandera = true;
        Set<Integer> setNumeros = new HashSet<>();
        int min = 0;

        while (bandera){
            int multiplo1 = operadorMaximo * indice;
            setNumeros.add(multiplo1);
            int multiplo2 = operadorMinimo * indice;
            if (setNumeros.contains(multiplo2)){
                min = multiplo2;
                bandera = false;
            }
            indice++;
        }
        return min;
    }


    private static int calculaMaximoComunDivisor(int operador1, int operador2) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        int max = 0;

        for(int i = 1; i <= operador1; i++ ){
            if (operador1 % i == 0){
                setA.add(i);
            }
        }

        for(int i = 1; i <= operador2; i++ ){
            if (operador2 % i == 0){
                setB.add(i);
            }
        }

        for(int numero : setA){
            if (setB.contains(numero)){
                if (numero > max){
                    max = numero;
                }
            }
        }

        return max;
    }
}
