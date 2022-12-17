package com.datastructures.java.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KingMarch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<String[][]> two_dim_list = new ArrayList();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            String arr[][] = new String[n][n];
            for (int m = n - 1; m >= 0; m--) {
                String each_line = sc.nextLine();
                String[] spiltted_each_line = each_line.split(" ");
                for (int l = spiltted_each_line.length - 1; l >= 0; l--) {
                    arr[m][l] = spiltted_each_line[l];
                }
            }
            two_dim_list.add(arr);
        }

        for (String[][] arr : two_dim_list) {
            //System.out.println(numberOfPaths(arr[1].length,arr[0].length));
            int maxLengthOfPath = arr[0].length + arr[1].length - 1;
            printMatrix(arr, arr[0].length, arr[1].length, 0, 0, new String[maxLengthOfPath], 0);
        }

        String mat[][] = {{"1", "2", "3"},
                {"x", "x", "6"},
                {"3", "1", "S"}};
        int maxLengthOfPath = 3 + 3 - 1;
        printMatrix(mat, 3, 3, 0, 0, new String[maxLengthOfPath], 0);
    }


    private static void printMatrix(String mat[][], int m, int n, int i, int j, String path[], int idx) {
        path[idx] = mat[i][j];

// Reached the bottom of the matrix so we are left with 
// only option to move right 
        if (i == m - 1) {
            for (int k = j + 1; k < n; k++) {
                path[idx + k - j] = mat[i][k];
            }
            for (int l = 0; l < idx + n - j; l++) {
                System.out.print(path[l] + " ");
            }
            System.out.println();
            return;
        }

// Reached the right corner of the matrix we are left with 
// only the downward movement. 
        if (j == n - 1) {
            for (int k = i + 1; k < m; k++) {
                path[idx + k - i] = mat[k][j];
            }
            for (int l = 0; l < idx + m - i; l++) {
                System.out.print(path[l] + " ");
            }
            System.out.println();
            return;
        }
// Print all the paths that are possible after moving down 
        printMatrix(mat, m, n, i + 1, j, path, idx + 1);

// Print all the paths that are possible after moving right 
        printMatrix(mat, m, n, i, j + 1, path, idx + 1);
    }

}
