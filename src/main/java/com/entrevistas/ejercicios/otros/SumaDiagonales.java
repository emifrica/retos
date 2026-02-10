package com.entrevistas.ejercicios.otros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumaDiagonales {

    public static void main(String[] args) {
        List<List <Integer>> matriz = new ArrayList<>();

        matriz.add(Arrays.asList(11,2,4));
        matriz.add(Arrays.asList(4,5,6));
        matriz.add(Arrays.asList(10,8,-12));

        System.out.println(Math.abs(diagonalDifference(matriz)));

    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int leftToRight = 0;
        int rightToLeft = 0;
        int renglon = 0;

        for (int i = 0; i < arr.get(0).size(); i++){
            leftToRight += arr.get(i).get(i);
        }

        for (int i = arr.get(0).size() -1; i >= 0; i--){
            rightToLeft += arr.get(renglon).get(i);
            renglon++;
        }

        return leftToRight - rightToLeft;

    }

}
