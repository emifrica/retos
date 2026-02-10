package com.entrevistas.ejercicios.otros;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height2 = {1, 1};

        System.out.println("Resultado 1: " + maxArea(height1)); // 49
        System.out.println("Resultado 2: " + maxArea(height2)); // 1
    }

    public static int maxArea(int[] height) {
        int izq = 0;
        int der = height.length - 1;
        int maxArea = 0;

        while (izq < der){
            int ancho = der -izq;
            int alturaMinima = Math.min(height[izq], height[der]);
            int area = ancho * alturaMinima;

            if (area > maxArea){
                maxArea = area;
            }

            if (height[izq] < height[der] ){
                izq++;
            } else {
                der--;
            }

        }


        return maxArea;
    }
}
