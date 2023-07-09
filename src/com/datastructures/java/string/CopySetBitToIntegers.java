package com.datastructures.java.string;

public class CopySetBitToIntegers {
    public static void main(String[] args) {
        System.out.println(setSetBit(44, 3, 1, 5));
        System.out.println(setSetBit(3, 9, 11, 27));
        System.out.println(setSetBit(11, 6 ,2, 9));
        System.out.println(setSetBit(43, 18469 ,11, 27));
    }

    static int setSetBit(int x, int y, int l, int r) {
        int mask = (1 << (r - l + 1));
        System.out.println("mask"+mask);
        System.out.println(setBits(mask));
        mask -= 1;
        System.out.println("mask"+mask);
        System.out.println(setBits(mask));
        mask = (mask << (l - 1));
        System.out.println("mask"+mask);
        System.out.println(setBits(mask));
        mask = mask & y;
        System.out.println("mask"+mask);
        System.out.println(setBits(mask));
        System.out.println("y"+y);
        System.out.println(setBits(y));
        x = x | mask;
        System.out.println("x"+x);
        System.out.println(setBits(x));
        return x;
    }

    static String setBits(int N) {

        return Integer.toBinaryString(N);
    }
}
