package com.datastructures.java.sort;

import java.util.*;

public class CyclicSort {

    public static void main(String[] args) {
        Random r = new Random();
        List<Integer> array = new ArrayList(100);
        int last = 0;
        for (int a = 0; a < 100; a++) {
            last = a + r.nextInt(10) + 1;
            array.add(last);
        }
        Collections.shuffle(array, r);
        int[] arr = new int[100];
        for (int a = 0; a < array.size(); a++) {
            arr[a] = array.get(a).intValue();
        }
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    static void sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            System.out.println(String.format("correct::%n%s", correct));
            System.out.println("i::" + i);
            if (arr[correct] != arr[i]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }
    }
}
