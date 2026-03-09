package com.entrevistas.ejercicios.ordernarlista;

public class SortService {

    public int[] sort(int[] numeros, String orden){
        OrderType orderType = OrderType.from(orden);
        EstrategiaSort estrategiaSort = SortStrategyFactory.getStrategy(orderType);
        QuickSorter sorter = new QuickSorter(estrategiaSort);
        return sorter.sort(numeros);

    }
}
