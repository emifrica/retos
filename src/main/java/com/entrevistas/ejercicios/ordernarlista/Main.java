package com.entrevistas.ejercicios.ordernarlista;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        SortService service = new SortService();

        int[] numeros = {8, 4, 2, 9, 6};

        int[] asc =  service.sort(numeros, "Asc");
        int[] desc =  service.sort(numeros, "Desc");

        System.out.println(Arrays.toString(asc));
        System.out.println(Arrays.toString(desc));
    }
}
