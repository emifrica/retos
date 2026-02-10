package com.entrevistas.ejercicios.otros;

import java.util.Arrays;
import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Set;

public class EncuentraDuplicado {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        int[] nums2 = {3, 1, 3, 4, 2};

        System.out.println("Streams Approach:");
        System.out.println("Input: [1,3,4,2,2] -> Output: " + findDuplicate(nums1));
        System.out.println("Input: [3,1,3,4,2] -> Output: " + findDuplicate(nums2));
    }

    public static int findDuplicate(int[] numeros){
        Set<Integer> setNumeros = new HashSet<>();

        OptionalInt numeroRepetido = Arrays.stream(numeros)
                .filter(num -> !setNumeros.add(num))
                .findFirst();

        return numeroRepetido.orElse(-1);
    }
}
