package com.entrevistas.ejercicios;

/*
 * Crea un programa que dibuje un cuadrado o un triángulo con asteriscos "*".
 * - Indicaremos el tamaño del lado y si la figura a dibujar es una u otra.
 * - EXTRA: ¿Eres capaz de dibujar más figuras?
 */

public class DibujarCuadradoTriangulo {

    public static void main(String[] args) {
        dibuja(5,"cuadrado");
        dibuja(6,"triangulo");
    }

    private static void dibuja(int size, String figura) {

        if (figura.equals("cuadrado")){
            for(int i = 0; i <= size-1; i++){
                for(int j=0; j <= size-1; j++){
                    if ( i == 0 || j == size -1 || j == 0 || i == size -1){
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            for (int i = 0; i < size; i++) {
                System.out.println("* ".repeat(size));
            }
        } else {
            int base = size + (size - 1);
            int primero = 0;
            int ultimo = base - 1;

            for(int i = 0; i <= size - 1; i++){
                for(int j = 0; j <= base -1; j++){
                    if (i == 0){
                        System.out.print("* ");
                    } else if (j == primero){
                        System.out.print("* ");
                    } else if (j == ultimo){
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
                primero++;
                ultimo--;
            }
            for (int i = 1; i <= size; i++) {
                System.out.println("* ".repeat(i));
            }
            for (int i = 1; i <= size; i++) {
                String spaces = " ".repeat(size - i);
                String stars = "*".repeat(2 * i - 1);
                System.out.println(spaces + stars);
            }
        }
    }


}
