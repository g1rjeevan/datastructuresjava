package com.datastructures.java.grid;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class PillsAndGerms {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("/workspaces/java/inpillsandgerms.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String row_col = br.readLine();
			String[] values_row_col = row_col.split(" ");
			int row = Integer.parseInt(values_row_col[0]);
			int col = Integer.parseInt(values_row_col[1]);
			char arr[][] = new char[row][col];
			boolean xfound =false;
			for (int m = 0; m < row; m++) {
				String each_line = br.readLine();
				String[] spiltted_each_line = each_line.split("");
				for (int l = 0; l < spiltted_each_line.length; l++) {
					if(spiltted_each_line[l].charAt(0)=='x') {
						xfound=true;
					}
					arr[m][l] = spiltted_each_line[l].charAt(0);
				}
			}
			for (int _row = 0; _row < row; _row++) {
				for (int _col = 0; _col < col; _col++) {
					if (arr[_row][_col] == 'b') {
						checkandzeroify(arr, _row, _col, false, row - 1, col - 1);
					} else if (arr[_row][_col] == 'r') {
						checkandzeroify(arr, _row, _col, true, row - 1, col - 1);
					}
				}
			}
			int xcount = 0;
			for (int _row = 0; _row < row; _row++) {
				for (int _col = 0; _col < col; _col++) {
					if (arr[_row][_col] == 'x') {
						xcount++;
					}
				}
			}
			System.out.println(xcount);
		}
	}

	public static void checkandzeroify(final char[][] arr, final int row, final int col, final boolean red,
			final int main_row, final int main_col) {
		boolean col1 = (main_col >= col + 1);
		boolean row1 = (main_row >= row + 1);
		boolean col1_ = (0 <= col - 1);
		boolean row1_ = (0 <= row - 1);
		if (col1 && arr[row][col + 1] == 'x')
			arr[row][col + 1] = ' ';
		if (col1_ && arr[row][col - 1] == 'x')
			arr[row][col - 1] = ' ';
		if (row1 && arr[row + 1][col] == 'x')
			arr[row + 1][col] = ' ';
		if (row1_ && arr[row - 1][col] == 'x')
			arr[row - 1][col] = ' ';
		if (red) {
			if (col1 && row1 && arr[row + 1][col + 1] == 'x')
				arr[row + 1][col + 1] = ' ';
			if (col1_ && row1_ && arr[row - 1][col - 1] == 'x')
				arr[row - 1][col - 1] = ' ';
			if (col1_ && row1 && arr[row + 1][col - 1] == 'x')
				arr[row + 1][col - 1] = ' ';
			if (row1_ && col1 && arr[row - 1][col + 1] == 'x')
				arr[row - 1][col + 1] = ' ';
		}
	}
}
