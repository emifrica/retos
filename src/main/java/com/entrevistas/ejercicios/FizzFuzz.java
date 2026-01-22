package com.entrevistas.ejercicios;

/*
 * Escribe un programa que muestre por consola (con un print) los
 * números de 1 a 100 (ambos incluidos y con un salto de línea entre
 * cada impresión), sustituyendo los siguientes:
 * - Múltiplos de 3 por la palabra "fizz".
 * - Múltiplos de 5 por la palabra "buzz".
 * - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".
 */

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzFuzz {

    public static void main(String[] args) {
        boolean bandera = false;

        // primera opcion usando un for
        for (int i =1; i <= 100; i++){
            if ( i % 3 == 0){
                System.out.print("Fizz");
                bandera = true;
            }
            if ( i % 5 == 0){
                System.out.print("Fuzz");
                bandera = true;
            }
            if (bandera){
                System.out.println();
            } else{
                System.out.println(i);
            }
            bandera = false;
        }
        System.out.println("================================================================================");
        // segunda opcion con stream
        IntStream.rangeClosed(1, 100)
                .mapToObj(i -> {
                    if ( i % 15 == 0){
                        return "FizzBuzz";
                    } else if ( i % 3 == 0){
                        return "Fizz";
                    } else if ( i % 5 == 0){
                        return "Buzz";
                    } else {
                        return String.valueOf(i);
                    }
                })
                .forEach(System.out::println);

        System.out.println("================================================================================");
        // tercera opcion con streams mas conciso
        // usando foreach sin opciones intermedias
        IntStream.rangeClosed(1, 100)
                .forEach( i -> {
                    String resultado = "";
                    if ( i % 3 == 0) resultado += "Fizz";
                    if ( i % 5 == 0) resultado += "Buzz";
                    System.out.println(resultado.isEmpty() ? i : " 3 -" + resultado);
                });

        System.out.println("================================================================================");
        //cuarta opcion con streams y mas funcional
        String res = IntStream.rangeClosed(1, 100)
                .mapToObj( i ->
                    i % 15 == 0 ? "FizzBuzz" :
                    i % 3 == 0 ? "Fizz" :
                    i % 5 == 0 ? "Buzz" :
                    String.valueOf(i)
                )
                .collect(Collectors.joining("\n"));
        System.out.println(res);


    }
}
