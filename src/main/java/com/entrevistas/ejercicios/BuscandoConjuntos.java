package com.entrevistas.ejercicios;

/*
 * Crea una función que reciba dos array, un booleano y retorne un array.
 * - Si el booleano es verdadero buscará y retornará los elementos comunes
 *   de los dos array.
 * - Si el booleano es falso buscará y retornará los elementos no comunes
 *   de los dos array.
 * - No se pueden utilizar operaciones del lenguaje que
 *   lo resuelvan directamente.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BuscandoConjuntos {

    public static void main(String[] args) {
        int[] numeros1 = {1,2,34,45, 50, 100, 7,8, 10};
        int[] numeros2 = {1,4, 100, 10, 51, 9, 11, 15};
        boolean bandera = true;

        int[] resultado = buscaConjuntos(numeros1, numeros2, bandera);
        int[] resultado2 = buscaConjuntos(numeros1, numeros2, false);

        System.out.println( Arrays.toString(numeros1));
        System.out.println( Arrays.toString(numeros2));
        System.out.println("Resultado iguales: " + Arrays.toString(resultado));
        System.out.println("Resultado ausentes: " + Arrays.toString(resultado2));

        System.out.println("________________________________________________________");
        System.out.println("__________________   CON SET   _________________________");
        System.out.println("________________________________________________________");

        int[] ressultadoSet = conSets(numeros1, numeros2, true);
        int[] ressultadoSet1 = conSets(numeros1, numeros2, false);
        System.out.println("Resultado iguales: " + Arrays.toString(ressultadoSet));
        System.out.println("Resultado ausentes: " + Arrays.toString(ressultadoSet1));

    }

    private static int[] buscaConjuntos(int[] numeros1, int[] numeros2, boolean bandera) {
        Arrays.sort(numeros1);
        Arrays.sort(numeros2);
        int pos = 0;

        if (bandera){
            int[] res = new int[numeros1.length];
            for(int i = 0; i <= numeros1.length -1; i++){
                for(int j = 0; j <= numeros2.length -1; j++){
                    if (numeros1[i] == numeros2[j]){
                        res[pos] = numeros1[i];
                        pos++;
                    } else if (numeros1[i] < numeros2[j]) {
                        break;
                    }
                }
            }
            return Arrays.copyOf(res,res.length - (res.length -pos));

        } else {
            int[] resultado1 = obtenNumeros(numeros1, numeros2);
            int[] resultado2 = obtenNumeros(numeros2, numeros1);

            int[] resultado = new int[resultado1.length + resultado2.length];

            System.arraycopy(resultado1, 0, resultado, 0, resultado1.length);
            System.arraycopy(resultado2, 0, resultado, resultado1.length, resultado1.length-1);
            Arrays.sort(resultado);

            return resultado;
        }
    }

    private static int[] obtenNumeros(int[] numeros1, int[] numeros2) {
        boolean existe = false;
        int[] resultado = new int[numeros1.length];
        int pos = 0;

        for(int i = 0; i <= numeros1.length -1; i++){
            existe = false;
            for(int j = 0; j <= numeros2.length -1; j++){
                if (numeros1[i] == numeros2[j]){
                    existe = true;
                    break;
                }
                if (numeros1[i] < numeros2[j]){
                    break;
                }
            }
            if (!existe){
                resultado[pos] = numeros1[i];
                pos++;
            }
        }
        int[] resultadoFinal = Arrays.copyOf(resultado, resultado.length - (resultado.length - pos));
        return resultadoFinal;
    }

    private static int[] conSets(int[] numeros1, int[] numeros2, boolean bandera) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        //de arrays a set
        for(int valor : numeros1){
            setA.add(valor);
        }

        for(int valor : numeros2){
            setB.add(valor);
        }

        Set<Integer> resultadoSet = new HashSet<>();

        if (bandera){
            for (int valor : setA){
                if(setB.contains(valor)){
                    resultadoSet.add(valor);
                }
            }
        } else {
            for(int valor : setA){
                if (!setB.contains(valor)){
                    resultadoSet.add(valor);
                }
            }

            for(int valor : setB){
                if (!setA.contains(valor)){
                    resultadoSet.add(valor);
                }
            }
        }

        int[] resultado = new int [resultadoSet.size()];
        int indice = 0;
        for(int num : resultadoSet){
            resultado[indice] = num;
            indice++;
        }

        return resultado;

    }
}
