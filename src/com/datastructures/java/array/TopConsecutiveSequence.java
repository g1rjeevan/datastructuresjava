package com.datastructures.java.array;

import java.util.Arrays;

public class TopConsecutiveSequence {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        if(nums.length>1){
            Arrays.sort(nums);
            int maxCount = 1,checkMaxCount=1;
            for(int i=1;i<nums.length;i++){
                if(nums[i]-nums[i-1] == 1){
                    checkMaxCount++;
                }else if(nums[i] != nums[i-1]){
                    checkMaxCount =1;
                }

                if(checkMaxCount > maxCount){
                    maxCount=checkMaxCount;
                }

            }

            return maxCount;
        }
        return nums.length;
    }

    public static int[] quickSort(int[] nums, int i, int j){
        if(i<j){
            int partition = partition(nums, i , j);
            quickSort(nums, i, partition-1);
            quickSort(nums, partition+1, j);
        }
        return nums;
    }


    public static int partition(int[] nums, int l , int h){
        int i=l, j=h;
        int pivot = nums[l];
        while(i<j){

            while(nums[i]<=pivot&&i<=h-1){
                i++;
            }

            while(nums[j]>pivot&&j>=l+1){
                j--;
            }
            if(i<j){
                swap(nums,i,j);
            }

        }
        swap(nums, l, j);
        return j;
    }

    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
