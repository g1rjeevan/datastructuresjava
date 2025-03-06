package com.datastructures.java.array;

public class MaximizeStockProfit {

    public static void main(String[] args) {
        MaximizeStockProfit maximizeStockProfit = new MaximizeStockProfit();
//        maximizeStockProfit.maximumProfit(
//                new int[]{2, 4, 7, 5, 4, 3, 2, 1},
//                new int[]{3, 6, 8, 7, 6, 5, 3, 1},
//                10);
        //Input: present = [5,4,6,2,3], future = [8,5,4,3,5], budget = 10
        System.out.println(maximizeStockProfit.maximumProfit(
                new int[]{5,4,6,2,3},
                new int[]{8,5,4,3,5},
                10));
    }

    public int maximumProfit(int[] present, int[] future, int budget) {
        int n = present.length;
        int[] f = new int[budget + 1];
        for (int i = 0; i < n; ++i) {
            int a = present[i], b = future[i];
            for (int j = budget; j >= a; --j) {
                f[j] = Math.max(f[j], f[j - a] + b - a);
            }
        }
        return f[budget];
    }

}
