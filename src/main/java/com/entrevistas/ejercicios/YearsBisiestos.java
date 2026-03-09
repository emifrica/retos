package com.entrevistas.ejercicios;


/*
 * Crea una función que imprima los 30 próximos años bisiestos
 * siguientes a uno dado.
 * - Utiliza el menor número de líneas para resolver el ejercicio.
 */
import java.time.Year;
import java.util.stream.IntStream;

public class YearsBisiestos {

    public static void main(String[] args) {
        int currentYear = Year.now().getValue();

        IntStream.iterate(currentYear, n -> n + 1)
                .filter(YearsBisiestos::leapYears)
                .limit(30)
                .forEach(System.out::println);
    }

    private static boolean leapYears(int i) {
        return ( i % 4 == 0 && i % 100 != 0 ) || (i % 400 == 0);
    }
}
