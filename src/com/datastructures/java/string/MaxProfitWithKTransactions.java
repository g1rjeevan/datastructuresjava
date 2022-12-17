package com.datastructures.java.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxProfitWithKTransactions {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputOG = br.readLine();
        System.out.println(inputOG);
        inputOG = inputOG.replace("[", "").replace("]", "").replace(" ", "");
        String[] shareValuesArr = inputOG.split(",");
        int[] prices = new int[shareValuesArr.length - 1];
        for (int i = 0; i < prices.length; i++)
            prices[i] = Integer.valueOf(shareValuesArr[i]);
        int transactionalInt = Integer.valueOf(shareValuesArr[shareValuesArr.length - 1]);
        long v = System.currentTimeMillis();
        System.out.println(maxProfitWithKTransactionsOnkTOnS(prices, transactionalInt));

        System.out.println(System.currentTimeMillis() - v);
        v = System.currentTimeMillis();
        System.out.println(maxProfitWithKTransactionsOnkTOnk(prices, transactionalInt));

        System.out.println(System.currentTimeMillis() - v);
    }

    // O(nk) time | O(n) space
    public static int maxProfitWithKTransactionsOnkTOnS(int[] prices, int k) {
        if (prices.length == 0) {
            return 0;
        }
        int[] evenProfits = new int[prices.length];
        int[] oddProfits = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            evenProfits[i] = 0;
            oddProfits[i] = 0;
        }
        for (int t = 1; t < k + 1; t++) {
            int maxThusFar = Integer.MIN_VALUE;
            int[] currentProfits = new int[prices.length];
            int[] previousProfits = new int[prices.length];
            if (t % 2 == 1) {
                currentProfits = oddProfits;
                previousProfits = evenProfits;
            } else {
                currentProfits = evenProfits;
                previousProfits = oddProfits;
            }
            for (int d = 1; d < prices.length; d++) {
                maxThusFar = Math.max(maxThusFar, previousProfits[d - 1] - prices[d - 1]);
                currentProfits[d] = Math.max(currentProfits[d - 1], maxThusFar + prices[d]);
            }
        }
        return k % 2 == 0 ? evenProfits[prices.length - 1] : oddProfits[prices.length - 1];
    }

    // O(nk) time | O(nk) space
    public static int maxProfitWithKTransactionsOnkTOnk(int[] prices, int k) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] profits = new int[k + 1][prices.length];
        for (int t = 1; t < k + 1; t++) {
            int maxThusFar = Integer.MIN_VALUE;
            for (int d = 1; d < prices.length; d++) {
                maxThusFar = Math.max(maxThusFar, profits[t - 1][d - 1] - prices[d - 1]);
                profits[t][d] = Math.max(profits[t][d - 1], maxThusFar + prices[d]);
            }
        }
        return profits[k][prices.length - 1];
    }

}
