package com.entrevistas.ejercicios.otros;

import java.util.HashMap;
import java.util.Map;

public class CuentaYDi {

    public static void main(String[] args) {
        int numero = 8;
        System.out.println(countAndSay(numero));
    }

    public static String countAndSay(int n) {

        String inicio = "1";
        String resultado = "";

        if (inicio.equals(String.valueOf(n)))
            return inicio;

        for( int i = 1; i < n; i++){
            resultado = (resultado.isEmpty() ? generaCadena(inicio): generaCadena(resultado) );
        }

        return resultado;
    }

    public static String generaCadena(String cad){
        StringBuffer res = new StringBuffer();
        Map<Character, Integer> cuentaNumeros = new HashMap<>();
        int longitudCadena = cad.length() - 1;

        for(int i = 0; i <= longitudCadena; i++){
            char caracter = cad.charAt(i);
            if (cuentaNumeros.isEmpty()) {
                cuentaNumeros.put(caracter, cuentaNumeros.getOrDefault(caracter, 0) + 1);
            } else {
                if (cuentaNumeros.containsKey(caracter)){
                    cuentaNumeros.put(caracter, cuentaNumeros.getOrDefault(caracter, 0) + 1);
                } else {
                    // pasar al stringbuffer
                    cuentaNumeros.forEach( (k, v) -> {
                        res.append(v).append(k);
                    });
                    // vaciar mapa
                    cuentaNumeros.clear();
                    // agregar a mapa
                    cuentaNumeros.put(caracter, cuentaNumeros.getOrDefault(caracter, 0) + 1);
                }
            }

            if ( i == longitudCadena )
                res.append(cuentaNumeros.get(caracter)).append(caracter);

        }
        return res.toString();
    }
}
