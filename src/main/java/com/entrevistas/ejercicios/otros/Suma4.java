package com.entrevistas.ejercicios.otros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Suma4 {

    public static void main(String[] args) {
        int[] numeros1 = {1, 0, -1, 0, -2,2 };
        int[] numeros2 = {2,2,2,2,2,2};

        System.out.println(fourSum(numeros1,0));
        System.out.println(fourSum(numeros2, 8));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;

        Arrays.sort(nums);
        int longitud = nums.length;

        for (int i = 0; i < longitud - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // evitar duplicados en i

            // Optimización: suma mínima posible con i
            long minWithI = (long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (minWithI > target) break;

            // Optimización: suma máxima posible con i
            long maxWithI = (long) nums[i] + nums[longitud - 1] + nums[longitud - 2] + nums[longitud - 3];
            if (maxWithI < target) continue;

            for (int j = i + 1; j < longitud - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // evitar duplicados en j

                // Optimización: suma mínima posible con i y j
                long minWithIJ = (long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (minWithIJ > target) break;

                // Optimización: suma máxima posible con i y j
                long maxWithIJ = (long) nums[i] + nums[j] + nums[longitud - 1] + nums[longitud - 2];
                if (maxWithIJ < target) continue;

                int left = j + 1;
                int right = longitud - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // saltar duplicados para left y right
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
