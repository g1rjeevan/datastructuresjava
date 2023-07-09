package com.datastructures.java.array;

import java.util.ArrayList;
import java.util.Arrays;

public class FindSubArrayGivenSum {

    public static void main(String[] args) {
        subareaSum(new int[]{1, 2, 3, 7, 5}, 5, 12).forEach(System.out::println);
        subareaSum(new int[]{1, 2, 3, 7, 4}, 3, 11).forEach(System.out::println);
    }


    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subareaSum(int[] arr, int n, int s) {

        int start = 0;
        int end = 0;
        int addition = 0;
        ArrayList<Integer> responseData = new ArrayList<>();

        while(end<n){

            addition += arr[end];
            System.out.println("Addition: "+ addition);
            if(addition == s){
                System.out.println("addition == s start: "+ start);
                System.out.println("addition == s end: "+ end);
                responseData.addAll(Arrays.asList(start + 1, end + 1));
                return responseData;
            }else if(addition < s){
                end++;
                System.out.println("addition < s end: "+ end);
            }
            if(addition > s){
                System.out.println("addition > s start: "+ start);
                addition -= arr[start];
                addition -= arr[end];
                start++;
                System.out.println("addition > s addition: "+ addition);
            }

        }
        responseData.add(-1);
        return responseData;

    }
}
