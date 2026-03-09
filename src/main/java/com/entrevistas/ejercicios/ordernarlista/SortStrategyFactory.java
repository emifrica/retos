package com.entrevistas.ejercicios.ordernarlista;

public class SortStrategyFactory {

    public static EstrategiaSort getStrategy(OrderType orderType){
        return switch (orderType){
            case ASC -> new EstrategiaAscendente();
            case DESC ->  new EstrategiaDescendente();
        };
    }
}
