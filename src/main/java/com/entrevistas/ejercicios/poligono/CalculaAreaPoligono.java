package com.entrevistas.ejercicios.poligono;

/*
 * Crea una única función (importante que sólo sea una) que sea capaz
 * de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 */

public class CalculaAreaPoligono {

    public static void main(String[] args) {
        calculaArea(new Triangulo(10D, 3D));
        calculaArea(new Cuadrado(10D));
        calculaArea(new Rectangulo(10D, 3D));
    }

    private static void calculaArea(Poligono poligono) {
        poligono.imprime();
    }
}
