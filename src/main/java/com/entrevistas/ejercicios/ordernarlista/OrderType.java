package com.entrevistas.ejercicios.ordernarlista;

public enum OrderType {

    ASC,
    DESC;

    public static OrderType from(String value){
        if (value == null){
            throw new IllegalArgumentException("Order can not be null");
        }

        return switch (value.toUpperCase()){
            case "ASC" -> ASC;
            case "DESC" ->  DESC;
            default -> throw new IllegalArgumentException("Invalid Order Type");
        };
    }
}
