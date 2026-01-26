package com.entrevistas.ejercicios.poligono;

public class Cuadrado implements Poligono{

    public Double lado;

    public Cuadrado(Double lado) {
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado  * lado;
    }

    @Override
    public void imprime() {
        System.out.println("El area del cuadrado es : " + area());
    }
}
