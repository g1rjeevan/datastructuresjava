package com.datastructures.java.string;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{3,0,-2,-1,1,2};
        System.out.println(new ThreeSum().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> trips = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int a = nums[i];
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int b = nums[j];
                int c = nums[k];
                int sum = a+b+c;
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else {
                    Integer[] s = new Integer[]{a,b,c};
                    trips.add(Arrays.asList(s));
                    j++;
                    k--;
                }
            }
        }
        return trips;
    }
}
