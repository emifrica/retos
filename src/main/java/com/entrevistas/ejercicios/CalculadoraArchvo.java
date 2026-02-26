package com.entrevistas.ejercicios;

/*
 * Lee el fichero "Challenge21.txt" incluido en el proyecto, calcula su
 * resultado e imprímelo.
 * - El .txt se corresponde con las entradas de una calculadora.
 * - Cada línea tendrá un número o una operación representada por un
 *   símbolo (alternando ambos).
 * - Soporta números enteros y decimales.
 * - Soporta las operaciones suma "+", resta "-", multiplicación "*"
 *   y división "/".
 * - El resultado se muestra al finalizar la lectura de la última
 *   línea (si el .txt es correcto).
 * - Si el formato del .txt no es correcto, se indicará que no se han
 *   podido resolver las operaciones.
 */

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CalculadoraArchvo {

    public static void main(String[] args) {
        String filePath = "calculadora.txt";
        try{
            var resultado = calculateFromFile(filePath);
            System.out.println("El resultado final es: " + resultado.stripTrailingZeros());
        } catch (InvalidFormatException | ArithmeticException e){
            System.out.println("No se han podido resolver las operaciones !!! " + e.getMessage());

        }
    }

    private static BigDecimal calculateFromFile(String filePath) {

        try{
            List<String> lines = Files.readAllLines(Path.of(filePath));

            if (lines.isEmpty()){
                throw new InvalidFormatException("El archivo está vacío.");
            }

            validateFormat(lines);

            BigDecimal resultado = new BigDecimal(lines.get(0).trim());

            for(int i = 1; i < lines.size(); i += 2){
                String operador = lines.get(i).trim();
                BigDecimal numeroSiguiente = new BigDecimal(lines.get(i + 1).trim());
                resultado = hazOperacion(resultado, operador, numeroSiguiente);
            }
            return resultado;
        } catch (IOException e){
            throw new RuntimeException("Error leyendo el archivo !!!");
        } catch (NumberFormatException e){
            throw new InvalidFormatException("Formato numérico inválido.");
        }
    }

    private static void validateFormat(List<String> lines) {

        if (lines.size() % 2 == 0){
            throw new InvalidFormatException("Formato ionvalido: Numero incorrecto de lineas");
        }

        for (int i = 0; i < lines.size(); i++){
            String valor = lines.get(i).trim();

            if ( i % 2 == 0){
                // es numero
                new BigDecimal(valor.trim());
            } else {
                // debe ser operador valido
                if(!valor.matches("[+\\-*/]")){
                    throw new InvalidFormatException("Operador Invalido: " + valor);
                }
            }
        }
    }

    private static BigDecimal hazOperacion(BigDecimal resultado, String operador, BigDecimal numeroSiguiente) {

        return switch (operador){
            case ("+") -> resultado.add(numeroSiguiente);
            case ("-") -> resultado.subtract(numeroSiguiente);
            case ("*") -> resultado.multiply(numeroSiguiente);
            case ("/") -> {
                if (numeroSiguiente.compareTo(BigDecimal.ZERO) == 0){
                    throw new ArithmeticException("Division por cero");
                }
                yield resultado.divide(numeroSiguiente, 10, RoundingMode.UP);
            }
            default -> throw new InvalidFormatException("Operador No Soportado");
        };
    }

}
