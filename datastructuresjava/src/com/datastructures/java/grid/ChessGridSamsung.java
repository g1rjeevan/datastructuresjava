package com.datastructures.java.grid;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ChessGridSamsung {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(System.currentTimeMillis());
		System.setIn(new FileInputStream("/workspaces/java/in.txt"));
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		CustomArrayList two_dim_list = new CustomArrayList();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(sc.nextLine());
			String arr[][] = new String[n][n];
			for (int m = 0; m < n; m++) {
				String each_line = sc.nextLine();
				String[] spiltted_each_line = each_line.split(" ");
				for (int l = 0; l < spiltted_each_line.length; l++) {
					if (spiltted_each_line[l] == "e" || spiltted_each_line[l] == "s")
						arr[m][l] = "0";
					else
						arr[m][l] = spiltted_each_line[l];
				}

			}
			two_dim_list.add(arr);
		}
		for (int str_i = 0; str_i < two_dim_list.size(); str_i++) {
			String[][] arrTwoD = (String[][]) two_dim_list.get(str_i);
			if (arrTwoD.length <= 1)
				System.out.println(0 + " " + 0);
			else
				pathMains(reverseMatrix(arrTwoD));
		}
		System.out.println(System.currentTimeMillis());
		sc.close();
	}

	private static String[][] reverseMatrix(final String[][] matrix) {
		final String[][] rev_matrix = new String[matrix[0].length][matrix[1].length];
		int rev_row = matrix[0].length - 1;
		for (int row = 0; row < matrix[0].length; row++) {
			int rev_col = matrix[1].length - 1;
			for (int col = 0; col < matrix[1].length; col++) {
				rev_matrix[rev_row][rev_col] = matrix[row][col];
				rev_col--;
			}
			rev_row--;
		}
		return rev_matrix;
	}

	static CustomArrayList route_ag = new CustomArrayList();

	public static void printPaths(String[][] mat, CustomArrayList route, int i, int j) {
		int M = mat.length;
		int N = mat[0].length;
		route.add(mat[i][j]);
		if (i == M - 1 && j == N - 1) {
			if (!route.contains("x")) {
				route_ag.add(Arrays.toString(route.toArray()).replace("[", "").replace("]", "").replace(",", "")
						.replace(" ", ""));
			}
		} else {
			if (i + 1 < M)
				printPaths(mat, route, i + 1, j);
			if (j + 1 < N)
				printPaths(mat, route, i, j + 1);
			if (i + 1 < M && j + 1 < N)
				printPaths(mat, route, i + 1, j + 1);
		}
		route.remove(route.size() - 1);
	}

	public static void pathMains(String[][] mat) {
		CustomArrayList route = new CustomArrayList();
		printPaths(mat, route, 0, 0);
		int[] sum_arr = new int[route_ag.size()];
		int count = 0;
		for (int str_i = 0; str_i < route_ag.size(); str_i++) {
			String routes = (String) route_ag.get(str_i);
			int sum = 0;
			String[] sum_char = routes.split("");
			for (int i = 0; i < sum_char.length; i++) {
				if (sum_char[i].contentEquals("") || sum_char[i].contentEquals("s") || sum_char[i].contentEquals("e"))
					sum_char[i] = "0";
				sum = sum + Integer.parseInt(sum_char[i]);
			}
			sum_arr[count++] = sum;
		}
		Arrays.sort(sum_arr);
		int max_path_sum = 0;
		if (sum_arr.length > 0)
			max_path_sum = sum_arr[sum_arr.length - 1];
		System.out.println(max_path_sum + " " + countOccurrences(sum_arr, sum_arr.length, max_path_sum));
		route_ag.clear();
	}

	static int countOccurrences(final int arr[], final int n, final int x) {
		int ind = binarySearch(arr, 0, n - 1, x);
		if (ind == -1)
			return 0;
		int count = 1;
		int left = ind - 1;
		while (left >= 0 && arr[left] == x) {
			count++;
			left--;
		}
		int right = ind + 1;
		while (right < n && arr[right] == x) {
			count++;
			right++;
		}
		return count;
	}

	static int binarySearch(final int arr[], final int l, final int r, final int x) {
		if (r < l)
			return -1;
		int mid = l + (r - l) / 2;
		if (arr[mid] == x)
			return mid;
		if (arr[mid] > x)
			return binarySearch(arr, l, mid - 1, x);
		return binarySearch(arr, mid + 1, r, x);
	}

	static class CustomArrayList {
		private Object[] data;
		private int count = 0;
		private int FIXED_SIZE = 10;

		public CustomArrayList() {
			data = new Object[this.FIXED_SIZE];
		}

		public Object get(int index) {
			if (index < count)
				return data[index];
			else
				throw new ArrayIndexOutOfBoundsException();
		}

		public void add(Object obj) {
			if (data.length - count <= data.length / 2)
				this.reSizeArray();
			data[count++] = obj;
		}

		public Object remove(int index) {
			if (index < count) {
				Object obj = data[index];
				int temp = index;
				data[index] = null;
				while (temp < count) {
					data[temp] = data[temp + 1];
					data[temp + 1] = null;
					temp++;
				}
				count--;
				return obj;
			} else
				throw new ArrayIndexOutOfBoundsException();
		}

		public void reSizeArray() {
			data = Arrays.copyOf(data, data.length * 2);
		}

		public int size() {
			return count;
		}

		public boolean contains(Object o) {
			return indexOf(o) >= 0;
		}

		public int indexOf(Object o) {
			return indexOfRange(o, 0, count);
		}

		int indexOfRange(Object o, int start, int end) {
			Object[] es = data;
			if (o == null) {
				for (int i = start; i < end; i++)
					if (es[i] == null)
						return i;
			} else
				for (int i = start; i < end; i++)
					if (o.equals(es[i]))
						return i;
			return -1;
		}

		public Object[] toArray() {
			return Arrays.copyOf(data, count);
		}

		public void clear() {
			final Object[] es = data;
			for (int to = count, i = count = 0; i < to; i++)
				es[i] = null;
		}
		
		@SuppressWarnings("unchecked")
	    public <T> T[] toArray(T[] a) {
	        if (a.length < count)
	            // Make a new array of a's runtime type, but my contents:
	            return (T[]) Arrays.copyOf(data, count, a.getClass());
	        System.arraycopy(data, 0, a, 0, count);
	        if (a.length > count)
	            a[count] = null;
	        return a;
	    }
	}
}
