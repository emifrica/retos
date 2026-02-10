package com.entrevistas.ejercicios.otros;

public class ArraysConsecutivos {

    public static void main(String[] args) {
        //int[] nums = {2,5,7,8,9,2,3,4,3,1};
        //int k = 3;
        //int[] nums = {1,2,3,4,4,4,4,5,6,7};
        //int k = 4;
        //int[] nums = {-15,19};
        //int k = 1;
        int[] nums = {5,6, -2,-1};
        int k = 2;

        if (buscaArrays(nums, k)){
            System.out.println("SI existen 2 arryas consecutivos de longitud " + k);
        } else {
            System.out.println("NO existen 2 arryas consecutivos de longitud " + k);
        }

    }
    public static boolean buscaArrays(int[] numeros, int longitud){

        int totalCoonsecutivos = 1;
        int total = 0;

        if (numeros.length > 0 && longitud == 1)
            return true;

        for (int i = 0; i < numeros.length - 1 ; i++){
            if (numeros[i+1] - numeros[i] == 1 ) {
                totalCoonsecutivos++;
                if (totalCoonsecutivos == longitud) {
                    total++;
                    totalCoonsecutivos = 1;
                }
            }
        }

        return (total == 2);
    }

}
