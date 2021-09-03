package com.datastructures.java.grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ShortestPath {
	static List<String> route_ag = new ArrayList<String>();
	static List<String> route;

	// Recursive function to get all shortest routes in a rectangular grid
	// that start at the cell(i,j) and end at the last cell(M-1,N-1).
	public static void printPaths(String[][] mat, List<String> route, int i, int j) {
		int M = mat.length;
		int N = mat[0].length;

		// include current cell in route
		route.add(mat[i][j]);

		// if last cell is reached
		if (i == M - 1 && j == N - 1) {
			if (!route.contains("X")) {
				route_ag.add(Arrays.toString(route.toArray()).replace("S", "").replace("E", "").replace("[", "")
						.replace("]", "").replace(",", "").replace(" ", ""));
			}

			// System.out.println(Arrays.toString(route.toArray()));
		} else {
			// move down
			if (i + 1 < M)
				printPaths(mat, route, i + 1, j);

			// move right
			if (j + 1 < N)
				printPaths(mat, route, i, j + 1);

			// move diagonally
			if (i + 1 < M && j + 1 < N)
				printPaths(mat, route, i + 1, j + 1);
		}

		// backtrack - remove current cell from route
		route.remove(route.size() - 1);
	}

	// Print all shortest routes in a rectangular grid
	public static void printPaths(String[][] mat) {
		// list to store current route
		route = new ArrayList<>();

		// start from the first 3=13,4=25, cell (0, 0)
		printPaths(mat, route, 0, 0);

	}

	public static void main(String[] args) { 
		String[][] mat = {
				{"E","2","3"},{"2","X","2"},{"1","2","S"}
		};

		printPaths(mat);
		int[] sum_arr = new int[route_ag.size()];
		int count = 0;
		for (String routes : route_ag) {
			int sum = 0;
			String[] sum_char = routes.split("");
			for (int i = 0; i < sum_char.length; i++) {
				sum = sum + Integer.parseInt(sum_char[i]);
			}
			sum_arr[count++] = sum;
			System.out.println(routes);
		}
		Arrays.parallelSort(sum_arr);
		int max_path_sum = 0;
		if(sum_arr.length>0) {
			max_path_sum = sum_arr[sum_arr.length - 1];
		} 
		System.out.println(max_path_sum + " " + countOccurrences(sum_arr,sum_arr.length,max_path_sum));
	}

	// Returns number of times x
	// occurs in arr[0..n-1]
	static int countOccurrences(int arr[], int n, int x) {
		int ind = binarySearch(arr, 0, n - 1, x);

		// If element is not present
		if (ind == -1)
			return 0;

		// Count elements on left side.
		int count = 1;
		int left = ind - 1;
		while (left >= 0 && arr[left] == x) {
			count++;
			left--;
		}

		// Count elements
		// on right side.
		int right = ind + 1;
		while (right < n && arr[right] == x) {
			count++;
			right++;
		}

		return count;
	}

	static int binarySearch(int arr[], int l, int r, int x) {
		if (r < l)
			return -1;

		int mid = l + (r - l) / 2;

// If the element is present  
// at the middle itself 
		if (arr[mid] == x)
			return mid;

// If element is smaller than  
// mid, then it can only be  
// present in left subarray 
		if (arr[mid] > x)
			return binarySearch(arr, l, mid - 1, x);

// Else the element can 
// only be present in 
// right subarray 
		return binarySearch(arr, mid + 1, r, x);
	}
}