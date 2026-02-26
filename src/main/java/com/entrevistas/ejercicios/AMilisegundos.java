package com.entrevistas.ejercicios;

/*
 * Crea una función que reciba días, horas, minutos y segundos (como enteros)
 * y retorne su resultado en milisegundos.
 */

import java.time.Duration;

public class AMilisegundos {
    
    public static void main(String[] args) {
        
        int dias = 2;
        int horas = 20;
        int minutos = 30;
        int segundos = 21 ;

        System.out.println(dias + " dias " + horas + " horas " + minutos + " minutos " + segundos + " segundos "
        + " son " + aMilisegundos(dias, horas, minutos, segundos) + " Milisegundos");

        Duration miliSegundos = Duration.ZERO
                .plusDays(dias)
                .plusHours(horas)
                .plusMinutes(minutos)
                .plusSeconds(segundos);
        System.out.println( "Milisegundos : " + miliSegundos.toMillis());

    }

    private static long aMilisegundos(int dias, int horas, int minutos, int segundos) {
        int seconds =  segundos * 1000;
        long minutes =  minutos * 60 * 1000L;
        long hours =  horas * 60 * 60 * 1000L;
        long days = dias * 24 * 60 * 60 * 1000L;

        return seconds + minutes + hours + days;
    }
}
