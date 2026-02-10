package com.entrevistas.ejercicios.otros;

/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

    For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

 */


public class RaizCuadrada {

    public static void main(String[] args) {
        int x = 20;
        System.out.println(calculaRaiz(x));
    }

    public static int calculaRaiz(int x){
        if (x < 2){
            return x;  // raiz de 0 es 0 y raiaz de 1 es 1
        }

        long resultado = x;

        while (resultado * resultado > x){
            resultado = ( resultado + x / resultado) / 2;
        }

        return (int) resultado;
    }
}
