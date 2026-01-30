package com.entrevistas.ejercicios;

/*
 * Crea una función que calcule y retorne cuántos días hay entre dos cadenas
 * de texto que representen fechas.
 * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 * - La función recibirá dos String y retornará un Int.
 * - La diferencia en días será absoluta (no importa el orden de las fechas).
 * - Si una de las dos cadenas de texto no representa una fecha correcta se
 *   lanzará una excepción.
 */

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DiasTranscurridos {

    public static void main(String[] args) {
        String fecha1 = "14/12/1969";
        String fecha2 = "29/01/2026";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Period periodo = Period.between(LocalDate.parse(fecha1, formatter), LocalDate.parse(fecha2, formatter)) ;
        long totalDias = periodo.getYears() * 365 + periodo.getMonths() * 30 + periodo.getDays();

        long cronoDias = ChronoUnit.DAYS.between(LocalDate.parse(fecha1, formatter), LocalDate.parse(fecha2, formatter));

        System.out.println("Dias transcurridos entre " + fecha1 + " y " + fecha2  + " ---> " + totalDias);

        System.out.println("Dias transcurridos entre " + fecha1 + " y " + fecha2  + " ---> " + cronoDias);


    }



}
