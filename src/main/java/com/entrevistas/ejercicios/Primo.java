package com.entrevistas.ejercicios;

/*
 * Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 */

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Primo {

    public static void main(String[] args) {
        int numero = 5;

        System.out.println("El numero " +  numero + " es primo ? " + verificaPrimo(numero));

        System.out.println("Numeros primos entre 1 y 100");
        for(int i = 1; i <=100; i++){
            if(verificaPrimo(i)){
                System.out.print(i + ",");
            }
        }


        System.out.println("Version funcional");
        List<Integer> primos = IntStream.rangeClosed(1, 100)
                .filter(Primo::verificaPrimo)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(primos.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",")));
    }

    public static boolean verificaPrimo(int numero){
        boolean bandera = true;
        for (int i = 2; i < numero; i++){
            if ( numero % i == 0){
                bandera = false;
                break;
            }
        }
        return bandera;
    }
}

