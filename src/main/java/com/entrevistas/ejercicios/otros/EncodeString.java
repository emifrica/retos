package com.entrevistas.ejercicios.otros;

import java.util.Stack;

public class EncodeString {

        public static void main(String[] args) {
            // Test cases
            String[] testCases = {
                    "3[a]2[bc]",
                    "3[a2[c]]",
                    "2[abc]3[cd]ef",
                    "10[a]",
                    "2[3[a]b]",
                    "abc",
                    "1[a]",
                    "2[2[ab]1[c]]"
            };

            System.out.println("Decoding strings:");
            for (String test : testCases) {
                String result = decodeString(test);
                System.out.println("Input: \"" + test + "\"");
                System.out.println("Output: \"" + result + "\"");
                System.out.println();
            }
        }

        public static String decodeString(String s) {
            Stack<Integer> countStack = new Stack<>();
            Stack<StringBuilder> stringStack = new Stack<>();
            StringBuilder currentString = new StringBuilder();
            int currentNumber = 0;

            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    // Construir el número (puede tener múltiples dígitos)
                    currentNumber = currentNumber * 10 + (c - '0');
                } else if (c == '[') {
                    // Guardar el número actual y el string actual en los stacks
                    countStack.push(currentNumber);
                    stringStack.push(currentString);
                    // Resetear para la nueva substring
                    currentString = new StringBuilder();
                    currentNumber = 0;
                } else if (c == ']') {
                    // Decodificar la substring actual
                    StringBuilder decodedString = stringStack.pop();
                    int count = countStack.pop();
                    // Repetir la substring actual 'count' veces
                    for (int i = 0; i < count; i++) {
                        decodedString.append(currentString);
                    }
                    currentString = decodedString;
                } else {
                    // Carácter normal, agregar al string actual
                    currentString.append(c);
                }
            }

            return currentString.toString();
        }
}
