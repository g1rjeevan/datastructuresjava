package com.datastructures.java.string;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BitPermutations {

	static long sumBit = 0;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("/workspaces/java/inBitPermutations.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String row_col = br.readLine();
			String row_binary = Integer.toBinaryString(Integer.parseInt(row_col));
			System.out.println(permuteBit(row_binary));
			sumBit = 0;
		}
	}

	private static String permuteBit(String bitValue) {
		/*
		 * char[] bitCharValues = bitValue.toCharArray();
		 * Arrays.parallelSort(bitCharValues); Set<String> bitPermuteList = new
		 * HashSet<>(); bitPermuteList.add(String.valueOf(bitCharValues));
		 * permute(String.valueOf(bitCharValues), 0, bitCharValues.length - 1,
		 * bitPermuteList); int sumBit = 0; for (String longValue : bitPermuteList)
		 * sumBit += Integer.parseInt(longValue, 2); System.out.println(sumBit);
		 * sumBit=0;
		 */
		char[] bitCharValues_ = bitValue.toCharArray();
		Arrays.parallelSort(bitCharValues_);
		permute(String.valueOf(bitCharValues_), 0, bitCharValues_.length - 1);
		return String.valueOf(sumBit);
	}

	private static void permute(String str, int l, int r, final Set<String> bitPermuteList) {
		if (l == r)
			bitPermuteList.add(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				bitPermuteList.add(str);
				permute(str, l + 1, r, bitPermuteList);
				str = swap(str, l, i);
			}
		}
	}

	private static void permute(String str, int l, int r) {
		if (l == r) {

			sumBit += Integer.parseInt(str, 2);

		} else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
	/*
	 * Input 24 1 7 9 3 6 15 21 31 32 47 65 52 85 305 560 189 801 451 296 202 256
	 * 107 996 257
	 */

	/*
	 * Output 1 7 45 3 14 15 186 31 63 315 762 630 2540 28616 36828 5355 85932 35770
	 * 14308 8925 511 1905 128898 4088
	 */

}
