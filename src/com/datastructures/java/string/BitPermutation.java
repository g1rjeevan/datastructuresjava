package com.datastructures.java.string;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BitPermutation {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("/workspaces/java/inBitPermutations.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		BitPermutations bitPermutation = new BitPermutations();
		for (int i = 0; i < t; i++) {
			String row_col = br.readLine();
			String row_binary = Integer.toBinaryString(Integer.parseInt(row_col));
			Arrays.parallelSort(row_binary.toCharArray());
			System.out.println(bitPermutation.permutations(row_binary.toString()));
		}
	}

	private static class BitPermutations {
		int i = 0;
		List<Integer> bitPermValue = new ArrayList<Integer>();

		private void permutations(String res, String set, int n) {
			if (res.length() == set.length() && res.length() == n) {
				bitPermValue.add(Integer.parseInt(res, 2));
			}
			for (int j = 0; j < set.length(); j++) {
				if ((i & 1 << j) == 0) {
					i |= 1 << j;
					permutations(res + set.charAt(j), set, n);
					i &= ~(1 << j);
				}
			}
		}

		private long permutations(String str) {
			int n = str.length();
			if (n != 1 && str != "1") {
				for (int i = (1 << n); i > 1; i--) {
					String s = "";
					for (int j = 0; j < n; j++) {
						if ((i & 1 << j) != 0) {
							s += str.charAt(j);
						}
					}
					permutations("", s, n);
				}
			} else {
				bitPermValue.add(Integer.parseInt(str, 2));
			}

			i = 0;
			long sumSet = new HashSet<>(bitPermValue).stream().mapToInt(Integer::intValue).sum();
			bitPermValue.clear();
			return sumSet;
		}
	}
}
