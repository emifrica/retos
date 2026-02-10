package com.entrevistas.ejercicios.otros;

import java.util.Arrays;

public class SortedArrayRemoveDuplicates {

    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};

        removeDuplicates(nums1);
        removeDuplicates(nums2);

    }

    public static int removeDuplicates(int[] nums) {
        // Si el arreglo está vacío, no hay elementos únicos
        if (nums.length == 0) {
            return 0;
        }

        int i = 0; // puntero del último elemento único

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;               // movemos puntero de elementos únicos
                nums[i] = nums[j]; // copiamos el valor único
            }
        }

        System.out.println("Indice : " + i);
        System.out.println("Array : " + Arrays.toString(nums));

        return i + 1; // cantidad de elementos únicos
    }

}
