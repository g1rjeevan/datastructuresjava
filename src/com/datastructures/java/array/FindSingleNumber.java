package com.datastructures.java.array;

import java.util.Arrays;

public class FindSingleNumber {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 3, 2, 1, 4})));
        System.out.println(Arrays.toString(singleNumber(new int[]{18,24, 24, 21, 10, 29, 8, 10, 29, 18})));
    }

    public static int[] singleNumber(int[] nums) {
        nums =  cyclicSort(nums);
        int counter=nums.length;
        for(int n=0;n<nums.length;n++){
            for(int m=n+1;m<nums.length;m++){
                if(nums[n]-nums[m]==0){
                    nums[n] = 0;
                    nums[m] = 0;
                    counter-=2;
                    break;
                }
            }
        }
        int[] res = new int[counter];
        int i=0;
        for(int n: nums){
            if(n!=0){
                res[i] = n;
                i++;
            }
        }
        return res;
    }
    //[11, 2, 5, 1, 3, 5, 8, 1, 10]
    static int[] cyclicSort(int[] nums){
        int counterSkip = 0;
        int lowestValue = Integer.MAX_VALUE;
        int lowestValueIndex = 0;
        for(int i=0;i<nums.length-1;){
            if(nums[i]>nums[i+1]){
                int swap = nums[i+1];
                nums[i+1] = nums[i];
                nums[i] = swap;
                counterSkip++;
                if(lowestValue>nums[i]){
                    lowestValue=nums[i];
                    lowestValueIndex = i;
                }
            }else if(nums[i]<nums[i+1]&&counterSkip>0){
                i=0;
                counterSkip=0;
                if(nums[lowestValueIndex]<nums[i]){
                    int swap = nums[i];
                    nums[i] = nums[lowestValueIndex];
                    nums[lowestValueIndex] = swap;
                }
            }else{
                i++;
            }
        }
        return nums;
    }

}
