package com.datastructures.java.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TestClassArraySwapEqual {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		String[] arr_a = br.readLine().split(" ");
		int[] a = new int[n];
		for (int i_a = 0; i_a < arr_a.length; i_a++) {
			a[i_a] = arr_a[i_a].charAt(0);
		}
		String[] arr_b = br.readLine().split(" ");
		int[] b = new int[n];
		for (int i_b = 0; i_b < arr_b.length; i_b++) {
			b[i_b] = arr_b[i_b].charAt(0);
		}

		int out_ = getMinimumSwapsRequiredToMakeArrayEqual(a, b);
		System.out.println(out_);

		wr.close();
		br.close();
	}

	static int getMinimumSwapsRequiredToMakeArrayEqual(int[] a, int[] b) {
		int[] c = new int[a.length];
		int previous_index=0;
		boolean previous_occ =false;
		for (int i = 0; i < a.length; i++) {
			int a1 = a[i];
			int b1 = b[i];
			c[i] = a1 > b1 ? a1 - b1 : b1 - a1;
			if(c[i]==1&&!previous_occ) {
				previous_occ=true;
				previous_index =i;
			}else if(c[i]==1&&previous_occ) {
				
			}
		}
		int c1 = Integer.parseInt(String.valueOf(c).strip());
		System.out.println(c1);
		return 1;
	}

}
