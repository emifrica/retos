package com.entrevistas.ejercicios.otros;

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number
 sorted in non-decreasing order.
 */

import java.lang.module.FindException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedSquares {

    public static void main(String[] args) {
        int[] numeros = {-4, -1, 0, 3, 10};
        System.out.println("Array -> " + Arrays.toString(numeros) + " Oredenado -> " + Arrays.toString(OrdenaCuadrados(numeros)));
    }

    public static int[] OrdenaCuadrados(int[] numeros){
        int longitud = numeros.length;
        int[] ordenados = new int[longitud];
        int izquierda = 0;
        int derecha = longitud -1;
        int indice = derecha;

        while (izquierda <= derecha){
            int cuadradoIzq = numeros[izquierda] * numeros[izquierda];
            int cuadradoDer = numeros[derecha] * numeros[derecha];

            if (cuadradoIzq > cuadradoDer){
                ordenados[indice] = cuadradoIzq;
                izquierda++;
            } else {
                ordenados[indice] = cuadradoDer;
                derecha--;
            }
            indice--;
        }

        int[] listaOrdenada = Arrays.stream(numeros).boxed().map(n -> n *n).sorted().mapToInt(Integer::intValue).toArray();


        return listaOrdenada;
    }
}
