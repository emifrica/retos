package com.entrevistas.ejercicios.otros;

/*

Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.
 */

import java.util.ArrayList;
import java.util.List;

public class Combinaciones {

    public static void main(String[] args) {
        Combinaciones comb = new Combinaciones();

        // Test case 1
        System.out.println("n=4, k=2: " + comb.combine(4, 2));
        // Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]

        // Test case 2
        System.out.println("n=1, k=1: " + comb.combine(1, 1));
        // Output: [[1]]

        // Test case 3
        System.out.println("n=5, k=3: " + comb.combine(5, 3));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current,
                           int start, int n, int k) {
        // If we've collected k numbers, add to result
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try all numbers from start to n
        for (int i = start; i <= n; i++) {
            current.add(i);  // Choose i
            backtrack(result, current, i + 1, n, k);  // Explore further
            current.remove(current.size() - 1);  // Undo choice (backtrack)
        }
    }
}
