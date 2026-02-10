package com.entrevistas.ejercicios.otros;
/*
You are climbing a staircase. It takes n steps to reach the top. Each time you can either climb 1 or 2 steps.
In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

    public static void main(String[] args) {

        int n = 4;
        System.out.println("Maneras de subir : " + n + " pasos " + climbingStairs(n));
    }

    private static int climbingStairs(int n){
        if ( n == 1) return 1;
        if ( n == 2) return 2;

        int previo1 = 2; // maneras de alcanzar 2 pasos
        int previo2 = 1; // maneras de alcanzar 1 pasos
        int actual = 0;

        for (int  i = 3; i <= n; i++){
            actual = previo1 + previo2;
            previo2 = previo1;
            previo1 = actual;
        }
        return actual;
    }
}
