package com.datastructures.java.grid;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Optional;

public class KingMarchDP {

    public static void main(String[] args) throws Exception {
        long s = System.currentTimeMillis();
        System.setIn(new FileInputStream("/workspaces/java/in.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][n];
            for (int m = 0; m < n; m++) {
                String each_line = br.readLine();
                String[] spiltted_each_line = each_line.split(" ");
                for (int l = 0; l < spiltted_each_line.length; l++) {
                    if (spiltted_each_line[l].equalsIgnoreCase("x"))
                        arr[m][l] = -2;
                    else if (!spiltted_each_line[l].equalsIgnoreCase("s")
                            && !spiltted_each_line[l].equalsIgnoreCase("e")
                            && !spiltted_each_line[l].equalsIgnoreCase("x"))
                        arr[m][l] = Integer.parseInt(spiltted_each_line[l]);
                    else
                        arr[m][l] = 0;
                }
            }
            doit(arr, arr[0].length);
        }

        Optional<String> ate = Optional.of("test");
        System.gc();
        System.out.println(System.currentTimeMillis() - s);
    }

    static void doit(int a[][], int n) {
        int[][] dp = new int[n][n];
        int[][] path = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 0;
                path[i][j] = 0;
            }
        }
        path[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (a[i][0] != -2) {
                dp[i][0] = dp[i - 1][0] + a[i][0];
                path[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            if (a[0][i] != -2) {
                dp[0][i] = dp[0][i - 1] + a[0][i];
                path[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][j] != -2) {
                    int x = dp[i - 1][j];
                    int y = dp[i][j - 1];
                    int z = dp[i - 1][j - 1];
                    int x1 = path[i - 1][j];
                    int y1 = path[i][j - 1];
                    int z1 = path[i - 1][j - 1];
                    int m = 0;
                    if (x > m && x1 != 0) {
                        m = x;
                    }
                    if (y > m && y1 != 0) {
                        m = y;
                    }
                    if (z > m && z1 != 0) {
                        m = z;
                    }
                    if (x == m && x1 != 0) {
                        dp[i][j] = m + a[i][j];
                        path[i][j] = path[i][j] + x1;
                    }
                    if (y == m && y1 != 0) {
                        dp[i][j] = m + a[i][j];
                        path[i][j] = path[i][j] + y1;
                    }
                    if (z == m && z1 != 0) {
                        dp[i][j] = m + a[i][j];
                        path[i][j] = path[i][j] + z1;
                    }
                }
            }
        }
        System.out.println(dp[n - 1][n - 1] + " " + path[n - 1][n - 1]);

    }
}
