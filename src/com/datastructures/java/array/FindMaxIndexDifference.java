package com.datastructures.java.array;

public class FindMaxIndexDifference {

    public static void main(String[] args) {
        System.out.println(maxIndexDiff(new int[]{34, 8, 10, 3, 2, 80, 30, 33, 1},9));
        System.out.println(maxIndexDiff(new int[]{70, 83, 82, 39, 81},5));
        System.out.println(maxIndexDiff(new int[]{82, 63, 44, 74, 82, 99, 82},7));
        System.out.println(maxIndexDiff(new int[]{35, 98, 95, 94, 75, 8,
                47, 28, 75, 91, 28, 83, 72, 54, 67, 9, 34},17));
    }

    static int maxIndexDiff(int[] a, int N) {
        int max_diff = -1;
        int[] LMin = new int[N];
        int[] RMax = new int[N];
        RMax[N-1] = a[N-1];
        for(int j=N-2;j>=0;j--){
            RMax[j] = getMax(a[j], RMax[j+1]);
        }
        LMin[0] = a[0];
        for(int i=1;i<N;i++){
            LMin[i] = getMin(a[i], LMin[i-1]);
        }
        int i=0;
        int j=0;
        while(i<N&&j<N){
            if(LMin[i]<=RMax[j]){
                max_diff = getMax(max_diff, j-i);
                j++;
            }else{
                i++;
            }
        }

        return max_diff;

    }

    static int getMax(int x, int y){
        return Math.max(x, y);
    }

    static int getMin(int x, int y){
        return Math.min(x, y);
    }

}
