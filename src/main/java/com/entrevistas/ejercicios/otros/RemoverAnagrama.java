package com.entrevistas.ejercicios.otros;

import java.util.*;

public class RemoverAnagrama {

    public static List<String> RemoveAnagrams(String[] words){
        Deque<String> stack = new ArrayDeque<>();
        List<String> lista = new ArrayList<>();

        for (String word : words) {
            //if (!stack.isEmpty() && isAnagram(stack.peekLast(), word)) {
            if(!lista.isEmpty() && isAnagram(lista.getLast(), word)){
                continue;
            } else {
                //stack.addLast(word);
                lista.add(word);
            }
        }
        return lista; // new ArrayList<>(stack);
    }

    public static boolean isAnagram(String a, String b){
        if (a.length() != b.length())
            return false;
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        return Arrays.equals(arrA, arrB);
    }

    public static void main(String[] args) {
        String[] word1 = {"abba", "baba", "bbaa", "cd", "cd"};
        String[] word2 = {"a", "b", "c","d","e"};

        System.out.println(RemoveAnagrams(word1));
        System.out.println(RemoveAnagrams(word2));
    }

}
