package com.entrevistas.ejercicios.otros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangulo {

    public static void main(String[] args) {

        List<List<Integer>> matriz = new ArrayList<>();
        matriz.add(Arrays.asList(2));
        matriz.add(Arrays.asList(4, 3));
        matriz.add(Arrays.asList(6, 5, 7));
        matriz.add(Arrays.asList(4, 1, 8, 3));
        //matriz.add(Arrays.asList(-1));
        //matriz.add(Arrays.asList(2, 3));
        //matriz.add(Arrays.asList(1, -1, -3));

        System.out.println(minimumTotal(matriz));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int suma = 0;
        int posicion = 0;
        int valor = 0;
        for (List<Integer> renglon : triangle){
            if (suma == 0 && renglon.size() == 1){
                suma = renglon.get(0);
                valor = renglon.get(0);
                posicion = 0;
            } else {
                if (renglon.get(posicion) + valor < renglon.get(posicion+1) + valor){
                    suma += renglon.get(posicion);
                    valor = renglon.get(posicion);
                } else {
                    suma += renglon.get(posicion +1 );
                    valor = renglon.get(posicion + 1);
                    posicion++;
                }
            }

        }
        return suma;
    }
}
