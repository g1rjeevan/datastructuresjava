package com.datastructures.java.grid;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SamsungChessMarch {

    public static void main(String[] args) throws Exception {
        long s = System.currentTimeMillis();
        // System.setIn(new FileInputStream("/workspaces/java/in.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String arr[][] = new String[n][n];
            for (int m = 0; m < n; m++) {
                String each_line = br.readLine();
                String[] spiltted_each_line = each_line.split(" ");
                for (int l = 0; l < spiltted_each_line.length; l++) {
                    if (spiltted_each_line[l].equalsIgnoreCase("e") || spiltted_each_line[l].equalsIgnoreCase("s"))
                        arr[m][l] = "0";
                    else
                        arr[m][l] = spiltted_each_line[l];
                }
            }
            if (arr.length <= 1)
                System.out.println(0 + " " + 0);
            else {
                CustomArrayList sumAllPaths = new CustomArrayList();
                int m = arr.length;
                int nj = arr[0].length;
                int maxLengthOfPath = m + nj - 1;
                sumAllPaths.clear();
                printMatrix(arr, m, nj, 0, 0, new String[maxLengthOfPath], 0, sumAllPaths);
                Integer[] sumAllPathArr = new Integer[sumAllPaths.size()];
                sumAllPaths.toArray(sumAllPathArr);
                sort(sumAllPathArr);
                int max_path_sum = 0;
                if (sumAllPathArr.length > 0)
                    max_path_sum = sumAllPathArr[0];
                System.out.println(max_path_sum + " " + countOccurrences(sumAllPathArr, max_path_sum));
            }
            System.gc();
        }
        System.out.println(System.currentTimeMillis() - s);
    }

    static void sort(Integer arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, i, 0);
        }
    }

    static void heapify(Integer arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] < arr[largest])
            largest = l;
        if (r < n && arr[r] < arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    private static void printMatrix(String mat[][], int m, int n, int i, int j, String path[], int idx,
                                    CustomArrayList sumAllPaths) {
        path[idx] = mat[i][j];
        int sumAll = 0;
        if (i == m - 1) {
            for (int k = j + 1; k < n; k++) {
                path[idx + k - j] = mat[i][k];
            }
            if (!Arrays.asList(path).contains("x") && path.length > 0) {
                for (int l = 0; l < idx + n - j; l++) {
                    sumAll += Integer.parseInt(path[l]);
                }
                sumAllPaths.add(sumAll);
            }
            return;
        }
        if (j == n - 1) {
            for (int k = i + 1; k < m; k++) {
                path[idx + k - i] = mat[k][j];
            }
            if (!Arrays.asList(path).contains("x") && path.length > 0) {
                for (int l = 0; l < idx + m - i; l++) {
                    sumAll += Integer.parseInt(path[l]);
                }
                sumAllPaths.add(sumAll);
            }
            return;
        }
        printMatrix(mat, m, n, i + 1, j, path, idx + 1, sumAllPaths);
        printMatrix(mat, m, n, i, j + 1, path, idx + 1, sumAllPaths);
        printMatrix(mat, m, n, i + 1, j + 1, path, idx + 1, sumAllPaths);
    }

    static int countOccurrences(final Integer arr[], final int x) {
        int count = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] == x) {
                count++;
            } else if (arr[i] > x) {
                break;
            }
        }
        return count;
    }

    static class CustomArrayList {
        private Object[] data;
        private int count = 0;
        private int FIXED_SIZE = 10;

        public CustomArrayList() {
            data = new Object[this.FIXED_SIZE];
        }

        public void add(Object obj) {
            if (data.length - count <= data.length / 2)
                this.reSizeArray();
            data[count++] = obj;
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
                return (T[]) Arrays.copyOf(data, count, a.getClass());
            System.arraycopy(data, 0, a, 0, count);
            if (a.length > count)
                a[count] = null;
            return a;
        }
    }
}
