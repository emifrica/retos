package com.entrevistas.ejercicios.otros;

public class StringCompression {

    public static void main(String[] args) {
        // Test cases
        char[] chars1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] chars2 = {'a'};
        char[] chars3 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        char[] chars4 = {'a', 'a', 'a', 'b', 'b', 'a', 'a'};

        System.out.println("Test 1:");
        int len1 = compress(chars1);
        System.out.println("Length: " + len1);
        System.out.print("Compressed: [");
        for (int i = 0; i < len1; i++) {
            System.out.print("\"" + chars1[i] + "\"" + (i < len1 - 1 ? "," : ""));
        }
        System.out.println("]");

        System.out.println("\nTest 2:");
        int len2 = compress(chars2);
        System.out.println("Length: " + len2);
        System.out.print("Compressed: [");
        for (int i = 0; i < len2; i++) {
            System.out.print("\"" + chars2[i] + "\"" + (i < len2 - 1 ? "," : ""));
        }
        System.out.println("]");

        System.out.println("\nTest 3:");
        int len3 = compress(chars3);
        System.out.println("Length: " + len3);
        System.out.print("Compressed: [");
        for (int i = 0; i < len3; i++) {
            System.out.print("\"" + chars3[i] + "\"" + (i < len3 - 1 ? "," : ""));
        }
        System.out.println("]");

        System.out.println("\nTest 4:");
        int len4 = compress(chars4);
        System.out.println("Length: " + len4);
        System.out.print("Compressed: [");
        for (int i = 0; i < len4; i++) {
            System.out.print("\"" + chars4[i] + "\"" + (i < len4 - 1 ? "," : ""));
        }
        System.out.println("]");
    }

    public static int compress(char[] chars) {
        int writeIndex = 0; // Índice para escribir en el array
        int readIndex = 0;  // Índice para leer el array

        while (readIndex < chars.length) {
            char currentChar = chars[readIndex];
            int count = 0;

            // Contar caracteres consecutivos iguales
            while (readIndex < chars.length && chars[readIndex] == currentChar) {
                readIndex++;
                count++;
            }

            // Escribir el carácter actual
            chars[writeIndex++] = currentChar;

            // Escribir el count si es mayor que 1
            if (count > 1) {
                // Convertir el count a String y escribir cada dígito
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[writeIndex++] = c;
                }
            }
        }

        return writeIndex;
    }
}
