package com.entrevistas.ejercicios.poligono;

public class Triangulo implements Poligono {

    public Double base;
    public Double altura;

    public Triangulo(Double base, Double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return (base * altura) / 2;
    }

    @Override
    public void imprime() {
        System.out.println("El area del triangulo es : " + area());
    }
}
