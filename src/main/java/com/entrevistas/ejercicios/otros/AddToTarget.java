package com.entrevistas.ejercicios.otros;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order
Descripción del problema
Se te da:
Un arreglo de enteros nums
Un número entero target
Debes encontrar los índices de dos números en el arreglo cuya suma sea igual a target.
Reglas
Cada entrada tiene exactamente una solución válida.
No puedes usar el mismo elemento dos veces.
Puedes regresar los índices en cualquier orden.

 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AddToTarget {

    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int target1 = 9;

        int[] nums2 = {3,2,4};
        int target2 = 6;

        int[] nums3 = {3,3};
        int target3 = 6;

        System.out.println("Numeros : " + Arrays.toString(nums1) + " Target : " + target1 + " Indices : " + Arrays.toString(EncuentraResta(nums1, target1)));
        System.out.println("Numeros : " + Arrays.toString(nums2) + " Target : " + target2 + " Indices : " + Arrays.toString(EncuentraResta(nums2, target2)));
        System.out.println("Numeros : " + Arrays.toString(nums3) + " Target : " + target3 + " Indices : " + Arrays.toString(EncuentraResta(nums3, target3)));

    }

    public static int[] EncuentraResta(int[] numeros, int target){
        Map<Integer, Integer> mapa = new HashMap<>();
        int resta = 0;

        for(int i = 0; i <= numeros.length -1; i++){
            resta = target - numeros[i];
            if (mapa.containsKey(resta)){
                return new int[] { mapa.get(resta), i};

            } else {
                mapa.put(numeros[i],i);
            }
        }

        return new int[]{};
    }
}
