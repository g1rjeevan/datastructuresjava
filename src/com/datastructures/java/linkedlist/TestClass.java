package com.datastructures.java.linkedlist;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(System.getProperty("user.dir")+"/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] arr_arr = br.readLine().trim().split(" ");
			int[] arr = new int[n];
			for (int i_arr = 0; i_arr < arr_arr.length; i_arr++) {
				arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
			}

			int[] out_ = solve(arr);
			wr.print(out_[0]);
			for (int i_out_ = 1; i_out_ < out_.length; i_out_++) {
				wr.print(" " + out_[i_out_]);
			}
			wr.println();
		}
		wr.close();
		br.close();
	}

	static int[] solve(int[] arr) {
		int pair = 0;
		final List<Integer> inputIntegers = new ArrayList<>();
		for (int i : arr)
			inputIntegers.add(i);
		final List<Integer> dupIntegers = new ArrayList<>(inputIntegers);
		if (arr.length > 2) {
			final int end_value = (int) inputIntegers.get(inputIntegers.size() - 1);
			int i = 1;
			for (int pos = 1; pos < inputIntegers.size(); pos++) {
				final int a = (int) inputIntegers.get(pos - 1);
				boolean remove = false;
				while (!remove && end_value != i) {
					int b = (2 * a) + i;
					if (inputIntegers.contains(b)) {
						dupIntegers.remove(dupIntegers.indexOf(b));
						dupIntegers.remove(dupIntegers.indexOf(a));
						pair++;
						remove = true;
						break;
					}
					i++;
				}
				i = 0;
			}
		} else if (arr.length == 2) {
			final int a = inputIntegers.get(0);
			final int b = inputIntegers.get(1);
			if (b >= a) {
				pair++;
				dupIntegers.remove(dupIntegers.indexOf(b));
				dupIntegers.remove(dupIntegers.indexOf(a));
			}
		}
		return new int[] { pair, dupIntegers.size() };
	}
}