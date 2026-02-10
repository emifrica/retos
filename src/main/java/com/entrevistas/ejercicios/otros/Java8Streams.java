package com.entrevistas.ejercicios.otros;

import java.io.CharArrayReader;
import java.util.*;
import java.util.stream.Collectors;

public class Java8Streams {

    public static void main(String[] args) {

        // Find the first non-repeated character in a string
        String input = "armando";

        Character result = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(result);

        //Find duplicate elements in a list
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,1,2,6);

        Set<Integer> duplicates = numbers.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        System.out.println(duplicates);

        //Find the longest string in a list

        List<String> words = Arrays.asList("java", "springboot", "kafka", "gcp");

        String longest = words.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);

        System.out.println(longest);

        //Sum of squares of even numbers
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6);

        int sum = numeros.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .sum();

        System.out.println(sum);

        // Group words by their length
        List<String> palabras = Arrays.asList("java", "springboot", "kafka", "gcp", "hola");

        Map<Integer, List<String>> grouped = palabras.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(grouped);


        //Find top 3 highest numbers from a list
        List<Integer> num = Arrays.asList(10, 45, 32, 67,89, 21,90);

        List<Integer> top3 = num.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(top3);

        //Check if a list contains duplicates
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);

        boolean hasDuplicated = nums.size() != numbers.stream().distinct().count();

        System.out.println(hasDuplicated);

        //Find the frequency of each character in a string
        String cadena = "banana";

        Map<Character, Long> mapaFreq = cadena.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(mapaFreq);

        //Sort a map by values (descending)
        Map<String, Integer> map = Map.of("Java", 8, "Spring", 6,"Kafka", 9);

        LinkedHashMap<String, Integer> sorted = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        System.out.println(sorted);

        //FlatMap example — Split words into characters
        List<String> pal = Arrays.asList("Java", "Streams");

        List<String> chars = pal.stream()
                .flatMap(w -> Arrays.stream(w.split("")))
                .collect(Collectors.toList());

        System.out.println(chars);


    }


}
