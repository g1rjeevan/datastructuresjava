package com.datastructures.java.string;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BitPermutations {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("/workspaces/java/inBitPermutations.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Set<String> bitPermuteList = new HashSet<>();
        for (int i = 0; i < t; i++) {
            String row_binary = Integer.toBinaryString(Integer.parseInt(br.readLine()));
            bitPermuteList.add(row_binary);
            permute(row_binary, 0, row_binary.length() - 1, bitPermuteList);
            System.out.println(bitPermuteList.stream().mapToInt(str -> Integer.parseInt(str, 2)).sum());
            bitPermuteList.clear();
        }
    }

    private static void permute(String str, int l, int r, final Set<String> bitPermuteList) {
        char[] bitArr = str.toCharArray();
        if (l == r)
            bitPermuteList.add(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(bitArr, l, i);
                bitPermuteList.add(str);
                permute(str, l + 1, r, bitPermuteList);
                str = swap(bitArr, l, i);
            }
        }
    }

    public static String swap(char[] charArray, int i, int j) {
        char temp;
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    /*
     * private static void permute(String str, int l, int r) { if (l == r) {
     *
     * sumBit += Integer.parseInt(str, 2);
     *
     * } else { for (int i = l; i <= r; i++) { str = swap(str, l, i); permute(str, l
     * + 1, r); str = swap(str, l, i); } } }
     */

    /*
     * Input 24 1 7 9 3 6 15 21 31 32 47 65 52 85 305 560 189 801 451 296 202 256
     * 107 996 257
     */

    /*
     * Output 1 7 45 3 14 15 186 31 63 315 762 630 2540 28616 36828 5355 85932 35770
     * 14308 8925 511 1905 128898 4088
     */

}
