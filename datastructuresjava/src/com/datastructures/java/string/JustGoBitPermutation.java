package com.datastructures.java.string;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JustGoBitPermutation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("/workspaces/java/inBitPermutations.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String row_col = br.readLine();
			String bitSeq = getBinary(Integer.parseInt(row_col));
			char[] bitSeqArr = bitSeq.toCharArray();
			Arrays.sort(bitSeqArr);
			bitSeq = String.valueOf(bitSeqArr);
			String reverse = new StringBuilder(bitSeq).reverse().toString();
			System.out.println(getPermutationBetweenTwo(Integer.parseInt(bitSeq, 2), Integer.parseInt(reverse, 2),
					occuranceCount(bitSeqArr)));
		}
	}

	private static int getPermutationBetweenTwo(int bitSeq, int reverse, int occuranceCount) {
		int sumBit = bitSeq;
		while (bitSeq != reverse) {
			bitSeq++;
			String bitSeqStr = Integer.toBinaryString(bitSeq);
			char[] bitSeqArr = bitSeqStr.toCharArray();
			Arrays.sort(bitSeqArr);
			if (occuranceCount == occuranceCount(bitSeqArr)) {
				sumBit += Integer.parseInt(bitSeqStr, 2);
			}
		}
		return sumBit;
	}

	private static int occuranceCount(char[] bitSeqArr) {
		int nbOccurences = 0;
		for (int i = bitSeqArr.length - 1; i >= 0; i--) {
			if (bitSeqArr[i] == '1')
				nbOccurences++;
			else
				break;
		}
		return nbOccurences;
	}

	private static String getBinary(int n) {
		String x = "";
		while (n > 0) {
			int a = n % 2;
			x = a + x;
			n = n / 2;
		}
		return x;
	}
}
