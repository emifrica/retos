package com.entrevistas.ejercicios;

/*
 * Crea un programa que determine si dos vectores son ortogonales.
 * - Los dos array deben tener la misma longitud.
 * - Cada vector se podría representar como un array. Ejemplo: [1, -2]
 */

public class VectoreOrtogonales {

    public static void main(String[] args) {
        int[] vector1 = {1,2,3,4};
        int[] vector2 = {1,-2,-3,3};

        System.out.println("Los vectores son Ortogonales: " + multiplicaVectores(vector1, vector2));
    }

    private static boolean multiplicaVectores(int[] vector1, int[] vector2) {
        long total = 0L;

        if (vector1.length != vector2.length){
            return false;
        }

        for (int i=0; i <= vector2.length -1; i++){
            total += vector1[i] * vector2[i];
        }
        return total == 0;
    }


}
