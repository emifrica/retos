package com.entrevistas.ejercicios.otros;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidPatentheses {

    public static void main(String[] args) {
        String[] testCases = {
                "()",          // true
                "()[]{}",      // true
                "(]",          // false
                "([])",        // true
                "([)]",        // false
                "{[]}",        // true
                "",            // true
                "((()))",      // true
                "((())",       // false
                "))",          // false
                "a"            // false
        };

        System.out.println("Testing isValid method:");
        for (String test : testCases) {
            boolean result = isValid(test);
            System.out.println("Input: \"" + test + "\" -> Output: " + result);
        }
    }


    public static boolean isValid(String s) {
        //Stack<Character> stack = new Stack<>();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // Si es un paréntesis de apertura, lo agregamos al stack
                stack.push(c);
            } else {
                // Si es un paréntesis de cierre
                if (stack.isEmpty()) {
                    return false; // No hay paréntesis de apertura correspondiente
                }

                char top = stack.pop();

                // Verificamos si el paréntesis de cierre coincide con el de apertura
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // El stack debe estar vacío al final
        return stack.isEmpty();
    }
}
