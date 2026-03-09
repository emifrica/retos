package com.entrevistas.ejercicios;

/*
 * Simula el funcionamiento de una máquina expendedora creando una operación
 * que reciba dinero (array de monedas) y un número que indique la selección
 * del producto.
 * - El programa retornará el nombre del producto y un array con el dinero
 *   de vuelta (con el menor número de monedas).
 * - Si el dinero es insuficiente o el número de producto no existe,
 *   deberá indicarse con un mensaje y retornar todas las monedas.
 * - Si no hay dinero de vuelta, el array se retornará vacío.
 * - Para que resulte más simple, trabajaremos en céntimos con monedas
 *   de 5, 10, 50, 100 y 200.
 * - Debemos controlar que las monedas enviadas estén dentro de las soportadas.
 */

import java.util.Arrays;
import java.util.List;

public class MaquinaExpendedora {

    static List<Producto> productos = List.of(new Producto(1,"Refresco",25),
            new Producto(2,"Pan",30),
            new Producto(3,"Chicle",25),
            new Producto(4,"Papitas",20));

    public static void main(String[] args) {

        int[] dinero1 = {5,5,10,10,10,5};
        int[] dinero2 ={5,5,10,10};
        int[] dinero3 = {5,5,10,10,10,5,50};
        int[] dinero4 = {200};

        Cambio res1 =comprar(1, dinero1);
        System.out.print(res1.nombre());
        Arrays.stream(res1.vuelto()).forEach(num -> System.out.print(" " + num));
        System.out.println();

        Cambio res2 =comprar(2, dinero2);
        System.out.print(res2.nombre());
        Arrays.stream(res2.vuelto()).forEach(num -> System.out.print(" " + num));
        System.out.println();

        Cambio res3 =comprar(3, dinero3);
        System.out.print(res3.nombre());
        Arrays.stream(res3.vuelto()).forEach(num -> System.out.print(" " + num));
        System.out.println();

        Cambio res4 =comprar(5, dinero4);
        System.out.print(res4.nombre());
        Arrays.stream(res4.vuelto()).forEach(num -> System.out.print(" " + num));
        System.out.println();

        Cambio res5 =comprar(4, dinero4);
        System.out.print(res5.nombre());
        Arrays.stream(res5.vuelto()).forEach(num -> System.out.print(" " + num));
    }

    private static Cambio comprar(int indice, int[] dinero) {

        Producto prod = buscaProducto(indice);
        if (prod.id() == 0){
            return (new Cambio("Producto NO existe", dinero));
        }

        int totalDinero = Arrays.stream(dinero).reduce(0, Integer::sum);

        if (totalDinero < prod.precio()){
            return (new Cambio("Dinero insuficiente", dinero));
        }

        int[] cambio = calculaCambio(prod.precio(), totalDinero);

        return new Cambio(prod.Nombre(), cambio);
    }

    private static int[] calculaCambio(int precio, int totalDinero) {
        if (precio == totalDinero){
            return new int[] {};
        }
        int vuelto  = totalDinero - precio;

        int cien = vuelto / 100;
        int cienCambio =  vuelto % 100;
        int cincuenta = cienCambio / 50;
        int cincuentaCambio = cienCambio % 50;
        int diez = cincuentaCambio / 10;
        int diezCambio = cincuentaCambio % 10;
        int cinco =  diezCambio / 5;

        int indice = 0;

        int[] resultado = new int[cien + cincuenta + diez + cinco];

        for(int i = 1; i <= cien; i++ ){
            resultado[indice] = 100;
            indice++;
        }

        for(int i = 1; i <= cincuenta; i++ ){
            resultado[indice] = 50;
            indice++;
        }

        for(int i = 1; i <= diez; i++ ){
            resultado[indice] = 10;
            indice++;
        }

        for(int i = 1; i <= cinco; i++ ){
            resultado[indice] = 5;
            indice++;
        }
        return resultado;
    }

    private static Producto buscaProducto(int indice) {

        for(Producto producto : productos){
            if (producto.id() == indice)
                return producto;
        }

        return new Producto(0, "XXX", 0);
    }


}
