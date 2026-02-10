package com.entrevistas.ejercicios.otros;

public class CerosSbarrays {
    public static void main(String[] args) {

        //int[] nums  = {1,3,0,0,2,0,0,4};
        int[] nums  = {0,0,0,2,0,0};
        long total = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                total++;
                if (i > 0) {
                    if (nums[i - 1] == 0)
                        total++;
                }
            }
        }
        System.out.println(total);
    }
}
