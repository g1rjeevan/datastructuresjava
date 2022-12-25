package com.datastructures.java.array;

public class BestTimeToBuyStock {

    public static int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
    public static void main(String[] args) {
        int[] array = new int[]{7,1,5,3,6,4};
        System.out.println(7==maxProfit(array));
        array = new int[]{1,2,3,4,5};
        System.out.println(4==maxProfit(array));
        array = new int[]{7,6,4,3,1};
        System.out.println(0==maxProfit(array));
    }
}
