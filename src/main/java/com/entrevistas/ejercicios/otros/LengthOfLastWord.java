package com.entrevistas.ejercicios.otros;

/*
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal
consisting of non-space characters only.
 */

public class LengthOfLastWord {

    public static void main(String[] args) {

        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }


    public static int lengthOfLastWord(String cadena){

        String[] tokens = cadena.split(" ");

        return tokens[tokens.length -1].length();

    }
}
