package com.entrevistas.ejercicios.otros;

/*
Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.

 */

public class VolteaCadena {
    public static void main(String[] args) {
        char[] word1 = {'h','e','l','l','o'};
        char[] word2 = {'H','a','n','n','a', 'h'};
        char[] word3 = {'o','c','a','M','o', 'm', 'A','e','T'};

        System.out.println(new String(word1) + " -> " + new String(volteaCadena(word1)));
        System.out.println(new String(word2) + " -> " + new String(volteaCadena(word2)));
        System.out.println(new String(word3) + " -> " + new String(volteaCadena(word3)));
    }

    public static char[] volteaCadena( char[] word){
         int izq  = 0;
         int der = word.length -1;

         while (izq < der){
             char temp = word[izq];
             word[izq] = word[der];
             word[der] = temp;
             izq++;
             der--;
         }
        return word;
    }
}
