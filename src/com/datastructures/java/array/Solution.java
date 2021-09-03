package com.datastructures.java.array;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		int[] sumHourGlassArr = new int[16];
		int size = 0;
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 6; col++) {
				try {
					int subHourGlass = getSubHourGlass(arr, row, col);
					if (subHourGlass != 0) {
						sumHourGlassArr[size++] = subHourGlass;
					}
				} catch (ArrayIndexOutOfBoundsException exce) {
				}
			}
		}
		Arrays.sort(sumHourGlassArr);
		return sumHourGlassArr[sumHourGlassArr.length - 1];
	}

	static int getSubHourGlass(int[][] arr, int row, int col) throws ArrayIndexOutOfBoundsException {
		int[][] subHourGlassArr = new int[3][3];
		int newrow = 0;
		for (int subrow = row; subrow < row + 3; subrow++) {
			int newcol = 0;
			for (int subcol = col; subcol < col + 3; subcol++) {
				try {
					subHourGlassArr[newrow][newcol] = arr[subrow][subcol];
				} catch (ArrayIndexOutOfBoundsException exce) {
					return 0;
				}
				newcol++;
			}
			newrow++;
		}
		int sumHourGlass = 0;
		for (int new_row = 0; new_row < 3; new_row++) {
			for (int new_col = 0; new_col < 3; new_col++) {
				if (new_row == 1 && new_col == 0) {
					sumHourGlass = sumHourGlass + 0;
				} else if (new_row == 1 && new_col == 2) {
					sumHourGlass = sumHourGlass + 0;
				} else {
					sumHourGlass = sumHourGlass + subHourGlassArr[new_row][new_col];
				}
			}
		}
		return sumHourGlass;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}

		int result = hourglassSum(arr);
		System.out.println(result);
		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		// bufferedWriter.close();

		scanner.close();
	}
}
