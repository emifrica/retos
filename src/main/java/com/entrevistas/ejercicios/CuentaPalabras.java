package com.entrevistas.ejercicios;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CuentaPalabras {

    public static void main(String[] args) {
        String palabras = """  
                                Crea un programa que cuente cuantas veces se repite cada palabra
                                y que muestre el recuento final de todas ellas.
                                Los signos de puntuación no forman parte de la palabra.
                                Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
                                No se pueden utilizar funciones propias del lenguaje que
                                No se pueden utilizar funciones propias del lenguaje que
                                lo resuelvan automáticamente""";

        cuentaPalabras(palabras);

    }

    private static void cuentaPalabras(String palabras) {

        Map<String, Long> mapaPalabras = new HashMap<>();

        String[] words = palabras.split("\\s+");
        for (int i = 0; i < words.length -1; i++){
            mapaPalabras.put(words[i].toLowerCase(), mapaPalabras.getOrDefault(words[i], 0L) + 1);
        }


         mapaPalabras = Arrays.stream(palabras.split("[^\\p{L}\\p{N}]+"))
                .filter(palabra -> !palabra.isBlank())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
                ));


        System.out.println("el recuento de letras es : " );
        mapaPalabras.forEach( (k, v) -> System.out.println("Palabra : " + k + " Repetida : " + v + " veces."));
    }
}
