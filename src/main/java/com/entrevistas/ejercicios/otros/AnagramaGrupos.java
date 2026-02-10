package com.entrevistas.ejercicios.otros;

import java.util.*;

public class AnagramaGrupos {


    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> lista =groupAnagrams(strs);
        System.out.println(lista);
    }

        public static List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) {
                return new ArrayList<>();
            }

            Map<String, List<String>> map = new HashMap<>();

            for (String str : strs) {
                // Convert string to char array, sort it, and convert back to string
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String sortedStr = new String(charArray);

                // Add to the map
                if (!map.containsKey(sortedStr)) {
                    map.put(sortedStr, new ArrayList<>());
                }
                map.get(sortedStr).add(str);
            }
            map.forEach((k,v) -> System.out.println( k + " ->" + v));

            return new ArrayList<>(map.values());
        }
}
