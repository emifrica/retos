package com.entrevistas.ejercicios;

import java.util.ArrayDeque;
import java.util.Deque;


/*
 * Crea un programa que comprueba si los paréntesis, llaves y corchetes
 * de una expresión están equilibrados.
 * - Equilibrado significa que estos delimitadores se abren y cieran
 *   en orden y de forma correcta.
 * - Paréntesis, llaves y corchetes son igual de prioritarios.
 *   No hay uno más importante que otro.
 * - Expresión balanceada: { [ a * ( c + d ) ] - 5 }
 * - Expresión no balanceada: { a * ( c + d ) ] - 5 }
 */

public class ParentesisEquilibrados {

    public static void main(String[] args) {
        String expresion = "{ [ a * ( c + d ) ] - 5 }";
        System.out.println("La expresion es balanceada : " + validaParentesis(expresion));
    }

    public static boolean validaParentesis(String exp){
        Deque<Character> colaParentesis = new ArrayDeque<>();
        boolean bandera = true;

        for(char c : exp.toCharArray()){
            if ( c == '(' || c == '{' || c == '[' ){
                colaParentesis.push(c);
            } else if (c == ')' || c == '}' || c == ']' ) {
                char ultimo = colaParentesis.pop();
                if ( (c == ')' && ultimo != '(') ||
                   (c == '}' && ultimo != '{') ||
                   (c == ']' && ultimo != '[') ) {
                     bandera = false;
                     break;
                }
            }
        }
        return bandera;
    }
}
