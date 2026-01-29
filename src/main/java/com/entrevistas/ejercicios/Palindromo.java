package com.entrevistas.ejercicios;

/*
 * Escribe una función que reciba un texto y retorne verdadero o
 * falso (Boolean) según sean o no palíndromos.
 * Un Palíndromo es una palabra o expresión que es igual si se lee
 * de izquierda a derecha que de derecha a izquierda.
 * NO se tienen en cuenta los espacios, signos de puntuación y tildes.
 * Ejemplo: Ana lleva al oso la avellana.
 */

public class Palindromo {

    public static void main(String[] args) {
        String palindromo = "La ruta natural";
        System.out.println(" La frase ===> " + palindromo+ "  es un palindromo ? " + validapalindromo(palindromo));
    }

    private static boolean validapalindromo(String palindromo) {
        int izq = 0;
        boolean bandera = true;

        String sinEspacio = palindromo.toLowerCase().replaceAll(" ","");
        int der = sinEspacio.length() -1;

        char[] letras = sinEspacio.toCharArray();

        do{
            if (!(letras[izq] == letras[der])) {
                bandera = false;
                break;
            }
            izq++;
            der--;
        }while (izq <= der);
        return bandera;
    }

}

