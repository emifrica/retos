package com.entrevistas.ejercicios;

/*
 * Quiero contar del 1 al 100 de uno en uno (imprimiendo cada uno).
 * ¿De cuántas maneras eres capaz de hacerlo?
 * Crea el código para cada una de ellas.
 */

import java.util.stream.IntStream;

public class IteracionJava8 {

    public static void main(String[] args) {
        IntStream numeros = IntStream.rangeClosed(1,100);
        numeros.forEach(System.out::println);

        IntStream.iterate(1, n -> n +1).limit(100).forEach(System.out::println);
    }
}
