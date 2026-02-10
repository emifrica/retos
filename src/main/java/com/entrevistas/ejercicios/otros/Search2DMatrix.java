package com.entrevistas.ejercicios.otros;

public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(searchMatrix(matrix,20));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        boolean bandera = false;

        int renglon = 0;
        for(int i = 0; i <= m; i++){
            if (matrix[i][n] >= target){
                renglon = i;
                break;
            }
        }

        n = matrix[0].length - 1;
        for (int i = n; i >= 0; i-- ){
            if (matrix[renglon][i] == target){
                bandera = true;
                break;
            }
        }

        return bandera;
    }
}
