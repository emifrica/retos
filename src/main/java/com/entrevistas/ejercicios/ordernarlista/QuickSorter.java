package com.entrevistas.ejercicios.ordernarlista;

public class QuickSorter {

    private final EstrategiaSort estrategiaSort;


    public QuickSorter(EstrategiaSort estrategiaSort) {
        this.estrategiaSort = estrategiaSort;
    }

    public int[] sort(int[] input){
        if (input == null){
            throw new IllegalCallerException("Input can not be null");
        }

        int[] copia = input.clone();

        quicksort(copia, 0, copia.length - 1);

        return copia;
    }

    private void quicksort(int[] copia, int low, int high) {
        if (low < high){
            int indicePivote = partition(copia, low, high);
            quicksort(copia, low, indicePivote - 1);
            quicksort(copia, indicePivote + 1, high);
        }

    }

    private int partition(int[] copia, int low, int high) {
        int pivot = copia[high];
        int i = low -1;

        for( int j = low; j < high; j++){
            if (estrategiaSort.compare(copia[j], pivot)){
                i++;
                swap(copia, i,j);
            }
        }
        swap(copia, i +1, high);
        return i + 1;
    }

    private void swap(int[] copia, int i, int j){
            int temp = copia[i];
            copia[i] = copia[j];
            copia[j] = temp;
    }
}
