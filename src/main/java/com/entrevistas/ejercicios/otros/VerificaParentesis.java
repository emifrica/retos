package com.entrevistas.ejercicios.otros;

/*
A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2.
if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.
Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"
Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.
Given a string, determine if it is balanced or not.

 */


import java.util.LinkedList;
import java.util.Queue;

public class VerificaParentesis {

    public static void main(String[] args) {
        String parentesis1 = "}()";
        String parentesis2 = "({()})";
        String parentesis3 = "{}(";
        String parentesis4 = "[]";

        System.out.println("}() " + verificaParentesis(parentesis1));
        System.out.println("({()}) " + verificaParentesis(parentesis2));
        System.out.println("{}( " + verificaParentesis(parentesis3));
        System.out.println("[] " + verificaParentesis(parentesis4));
    }

    public static boolean verificaParentesis(String cadena){
        Queue<Character> cola = new LinkedList<>();

        for (Character c : cadena.toCharArray()){
            if (c == '(' || c == '[' || c == '{' ){
                cola.add(c);
            } else {
                if (cola.isEmpty()){
                    return false;
                }
                Character temp = cola.poll();
                if ((temp == '(' && c != ')') ||
                    (temp == '[' && c != ']') ||
                    (temp == '{' && c != '}') ){
                    return false;
                }
            }
        }
        return cola.isEmpty();
    }
}
