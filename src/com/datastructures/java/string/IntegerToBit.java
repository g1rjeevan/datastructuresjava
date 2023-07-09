package com.datastructures.java.string;

public class IntegerToBit {


    public static void main(String[] args) {
        System.out.println(setBits(6));
        System.out.println("***********");
        System.out.println(setBits(8));
    }

    static int setBits(int N) {
        int s = 0;
        while(N>1){
            System.out.println(N);
            System.out.println(s);
            if(N%2==1){
                s++;
            }
            N = N/2;
        }
        s++;
        return s;
    }
}
