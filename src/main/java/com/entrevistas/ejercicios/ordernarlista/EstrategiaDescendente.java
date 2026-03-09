package com.entrevistas.ejercicios.ordernarlista;

public class EstrategiaDescendente implements EstrategiaSort{
    @Override
    public boolean compare(int a, int b) {
        return a > b;
    }
}
