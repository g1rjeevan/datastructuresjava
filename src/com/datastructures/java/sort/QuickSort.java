package com.datastructures.java.sort;

import java.util.*;

public class QuickSort {

    public static void main(String[] args) {
        Random r = new Random();
        int last = 10;
        List<Integer> array = new ArrayList<>(last);
        while (last>=0) {
            array.add(last+r.nextInt(10) + 1);
            last--;
        }
        int[] ar = new int[]{14,11,12,13,16,6,14,9,8,3,1};//array.stream().mapToInt(t -> t).toArray();
        //array.stream().mapToInt(t -> t).toArray();
        Arrays.stream(ar).forEach(v->System.out.print(v+","));
        System.out.println();
        QuickSort quickSort = new QuickSort();
        Arrays.stream(quickSort.getQuickSort(ar, 0, ar.length-1)).forEach(v->System.out.print(v+","));
        ar = new int[]{0,3,7,2,5,8,4,6,0,1};
        Arrays.stream(ar).forEach(v->System.out.print(v+","));
        System.out.println();
        Arrays.stream(quickSort.getQuickSort(ar, 0, ar.length-1)).forEach(v->System.out.print(v+","));
    }

    public static int partition(int[] array, int l, int h){
        int pivot = array[l];
        System.out.println("pivot::"+pivot+",l::"+l+",h::"+h);
        int i=l, j=h;
        System.out.println("i::"+i+",j::"+j);
        Arrays.stream(array).forEach(v->System.out.print(v+","));
        System.out.println();
        while (i<j){
            while(array[i]<=pivot&&i<=h-1){
                i++;
            }
            while (array[j]>pivot&&j>=l+1){
                j--;
            }
            if(i<j){
                swap(array,i,j);
            }
        }
        swap(array, l, j);
        Arrays.stream(array).forEach(v->System.out.print(v+","));
        System.out.println();
        return j;
    }

    public static void swap(int[] array, int a, int b){
        System.out.println("in swap a::"+a+",b::"+b);
        int swap = array[a];
        array[a] = array[b];
        array[b] = swap;
    }

    public static int[] getQuickSort(int[] array, int l, int h){
        System.out.println("l::"+l);
        System.out.println("h::"+h);
        if(l<h){
            int j = partition(array, l, h);
            System.out.println("partition j::"+j);
            getQuickSort(array, l, j-1);
            getQuickSort(array, j+1, h);
        }
        return array;
    }
}
