package com.datastructures.java.grid;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixPaths {
    public static void main(String[] args) {
        PrintMatrixPaths cmp = new PrintMatrixPaths();
        int[][] matrix = {{0, 2, 3},
                {4, -1, 6},
                {7, 8, 0}};
        //matrix =reverseMatrix(matrix);
        List<List<Integer>> printMatrixPaths = cmp.printMatrixPaths(matrix);
        System.out.println("Paths: ");
        for (List<Integer> list : printMatrixPaths) {
            System.out.println(list);
        }
    }

    private static int[][] reverseMatrix(final int[][] matrix) {
        final int[][] rev_matrix = new int[matrix[0].length][matrix[1].length];
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

    public List<List<Integer>> printMatrixPaths(int[][] matrix) {
        List<List<Integer>> list = new ArrayList<>();
        matrixPathsHelper(list, new ArrayList<Integer>(), matrix, 0, 0);
        return list;
    }

    private void matrixPathsHelper(List<List<Integer>> list, List<Integer> paths, int[][] matrix, int row, int column) {

        // base case
        if (row == matrix.length - 1) {
            ArrayList<Integer> pathsTemp = new ArrayList<>(paths);
            for (int i = column; i < matrix[0].length; i++) {
                pathsTemp.add(matrix[row][i]);
            }
            list.add(pathsTemp);
            return;
        }

        // base case
        if (column == matrix[0].length - 1) {
            ArrayList<Integer> pathsTemp = new ArrayList<>(paths);
            for (int i = row; i < matrix.length; i++) {
                pathsTemp.add(matrix[i][column]);
            }
            list.add(pathsTemp);
            return;
        }

        // Add to list
        paths.add(matrix[row][column]);

        // Explore
        // go down
        matrixPathsHelper(list, paths, matrix, row + 1, column);

        // go right
        matrixPathsHelper(list, paths, matrix, row, column + 1);

        // Remove from list : backtrack
        paths.remove(paths.size() - 1);

    }
}
