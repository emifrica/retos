package com.entrevistas.ejercicios.ordernarlista;

public class EstrategiaAscendente implements EstrategiaSort {
    @Override
    public boolean compare(int a, int b) {
        return a < b;
    }
}
