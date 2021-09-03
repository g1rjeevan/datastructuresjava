package com.datastructures.java.string;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class MainBitPermutation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Set<String> hashSet = new HashSet<String>();
		System.setIn(new FileInputStream("/workspaces/java/inBitPermutations.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String row_col = br.readLine();
			Set<String> hashSet = new HashSet();
			String bitSeq = Integer.toBinaryString(Integer.parseInt(row_col));
			getPermutationSum(bitSeq, 0, hashSet);
			int sum = 0;
			hashSet.add(String.valueOf(bitSeq));
			for (String s : hashSet) {
				sum += Integer.parseInt(s, 2);
			}
			System.out.println(sum);
		}
	}

	public static int getPermutationSum(String bitSeq, int sumBit, Set<String> hashSet) {
		char[] bitSeqArr = bitSeq.toCharArray();
		char[] bitSeqFirstSwap = null;
		boolean swapped = false, firstSwap = true;
		for (int i = 0; i < bitSeqArr.length - 1; i++) {

			if (bitSeqArr[i] < bitSeqArr[i + 1]) {
				bitSeqArr = swapBits(bitSeqArr, i, i + 1);
				if (firstSwap) {
					bitSeqFirstSwap = bitSeqArr.clone();
					firstSwap = false;
				}
				hashSet.add(String.valueOf(bitSeqArr));
				sumBit += Integer.parseInt(String.valueOf(bitSeqArr), 2);
				swapped = true;
			}
		}
		if (swapped) {
			swapped = false;
			return getPermutationSum(String.valueOf(bitSeqFirstSwap), sumBit, hashSet);
		} else {
			return sumBit;
		}
	}

	public static char[] swapBits(char[] bitSeqArr, int i, int j) {
		char temp = bitSeqArr[i];
		bitSeqArr[i] = bitSeqArr[j];
		bitSeqArr[j] = temp;
		return bitSeqArr;
	}
}
