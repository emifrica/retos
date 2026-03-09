package com.entrevistas.ejercicios.ordernarlista;

@FunctionalInterface
public interface EstrategiaSort {
    boolean compare(int a, int b);
}
