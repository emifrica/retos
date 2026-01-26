package com.entrevistas.ejercicios.poligono;

public class Rectangulo implements Poligono{

    public Double base;
    public Double altura;

    public Rectangulo(Double base, Double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return base * altura;
    }

    @Override
    public void imprime() {
        System.out.println("El area del rectangulo es es : " + area());
    }
}
