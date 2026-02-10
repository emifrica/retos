package com.entrevistas.ejercicios.otros;

import java.util.Arrays;

public class MaxFrequency {

    /**
     * Calcula la máxima frecuencia posible de cualquier número
     * después de realizar 'numOperations' operaciones, donde cada operación
     * permite sumar un número en el rango [-k, k] a un índice distinto.
     *
     * @param nums           arreglo de enteros
     * @param k              rango permitido para modificar cada valor
     * @param numOperations  número de operaciones disponibles
     * @return la máxima frecuencia alcanzable
     */
    public static int maxFrequency(int[] nums, int k, int numOperations) {
        // Paso 1: Ordenamos el arreglo
        // Esto permite analizar los intervalos de forma consecutiva
        Arrays.sort(nums);
        int n = nums.length;

        // Punteros para nuestra ventana deslizante
        int left = 0;
        int maxFreq = 1; // al menos un número siempre existe

        // Paso 2: Recorremos el arreglo con el puntero derecho
        for (int right = 0; right < n; right++) {

            // Paso 3: Mover el puntero izquierdo si los rangos dejan de solaparse
            // Un rango [nums[i] - k, nums[i] + k]
            // se solapa con otro si |nums[right] - nums[left]| <= 2*k
            while (nums[right] - nums[left] > 2 * k) {
                left++; // reducimos ventana hasta que se solapen de nuevo
            }

            // Paso 4: El tamaño de la ventana indica cuántos rangos se solapan
            int windowSize = right - left + 1;

            // Paso 5: Actualizamos la frecuencia máxima posible
            maxFreq = Math.max(maxFreq, windowSize);
        }

        // Paso 6: Limitamos el resultado por el número de operaciones disponibles
        // Solo podemos modificar 'numOperations' índices distintos.
        // Por lo tanto, la frecuencia máxima real no puede exceder numOperations + 1
        return Math.min(maxFreq, numOperations + 1);
    }

    public static void main(String[] args) {
        // Ejemplo 1
        int[] nums1 = {1, 4, 5};
        System.out.println(maxFrequency(nums1, 1, 2)); // 2
        // Explicación:
        // Rango 1: [0,2], Rango 4: [3,5], Rango 5: [4,6]
        // Los rangos [3,5] y [4,6] se solapan → podemos convertir 4 y 5 en el mismo número

        // Ejemplo 2
        int[] nums2 = {5, 11, 20, 20};
        System.out.println(maxFrequency(nums2, 5, 1)); // 2
        // Rango 11: [6,16], Rango 20: [15,25]
        // Se solapan, podemos hacer que 11 y 20 sean iguales con una sola operación

        // Ejemplo adicional
        int[] nums3 = {1, 2, 4, 8, 10};
        System.out.println(maxFrequency(nums3, 2, 2)); // 2

        int[] nums4 = {1, 1, 1};
        System.out.println(maxFrequency(nums4, 0, 0)); // 3
    }
}
