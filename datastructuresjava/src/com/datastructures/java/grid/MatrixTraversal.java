package com.datastructures.java.grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixTraversal {

	/*
	 * mat: Pointer to the starting of mXn matrix i, j: Current position of the
	 * robot (For the first call use 0,0) m, n: Dimentions of given the matrix pi:
	 * Next index to be filed in path array path[0..pi-1]: The path traversed by
	 * robot till now (Array to hold the path need to have space for at least m+n
	 * elements)
	 */
	private static void printMatrix(String mat[][], int m, int n, int i, int j, String path[], int idx) {
		path[idx] = mat[i][j];
		int sumAll = 0;
		// Reached the bottom of the matrix so we are left with
		// only option to move right
		if (i == m - 1) {
			for (int k = j + 1; k < n; k++) {
				path[idx + k - j] = mat[i][k];
			}
			//if (!Arrays.asList(path).contains("x")) {
				for (int l = 0; l < idx + n - j; l++) {
					if(path[l].contains("x"))
						path[l] = "-100";
					sumAll += Integer.parseInt(path[l]);
				}
				sumAllPaths.add(sumAll);
			//}
			return;
		}
		if (j == n - 1) {
			for (int k = i + 1; k < m; k++) {
				path[idx + k - i] = mat[k][j];
			}
			//if (!Arrays.asList(path).contains("x")) {
				for (int l = 0; l < idx + m - i; l++) {
					if(path[l].contains("x"))
						path[l] = "-100";
					sumAll += Integer.parseInt(path[l]);
				}
				sumAllPaths.add(sumAll);
			//}
			return;
		}
		printMatrix(mat, m, n, i + 1, j, path, idx + 1);
		printMatrix(mat, m, n, i, j + 1, path, idx + 1);
		//printMatrix(mat, m, n, i + 1, j + 1, path, idx + 1);
	}

	static List<Integer> sumAllPaths = new ArrayList<Integer>();

	// Driver code
	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		String mat[][] = { { "e", "2", "3" }, { "4", "x", "6" }, { "2", "0", "s" } };
		int maxLengthOfPath = m + n - 1;
		sumAllPaths.clear();
		printMatrix(reverseMatrix(mat), m, n, 0, 0, new String[maxLengthOfPath], 0);
		Arrays.sort(sumAllPaths.toArray());
		System.out.println("Sum all:" + sumAllPaths.get(0));
	}

	private static String[][] reverseMatrix(final String[][] matrix) {
		final String[][] rev_matrix = new String[matrix[0].length][matrix[1].length];
		int rev_row = matrix[0].length - 1;
		for (int row = 0; row < matrix[0].length; row++) {
			int rev_col = matrix[1].length - 1;
			for (int col = 0; col < matrix[1].length; col++) {
				if (matrix[row][col] == "e" || matrix[row][col] == "s") {
					matrix[row][col] = "0";
				}
				rev_matrix[rev_row][rev_col] = matrix[row][col];
				rev_col--;
			}
			rev_row--;
		}
		return rev_matrix;
	}
}
