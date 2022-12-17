package com.datastructures.java.string;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShortestUSSInString {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/workspaces/java/inUSS.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = bufferedReader.read();
        for (int i = 0; i < t; i++) {
            String inputCase = bufferedReader.readLine();
            findUSS(inputCase);
        }
    }

    private static void findUSS(String inputCase) {
        for (int i = 0; i < inputCase.length(); i++) {
            final String ogInputCase = inputCase;
            int uniqueCount = 0;
            for (int j = 0; j < inputCase.length(); j++) {
                if (j + i <= inputCase.length() - 1) {

                }
                final String subString = ogInputCase.substring(j, j + i);
                final String[] reInputCase = ogInputCase.replaceAll(subString, "").split("");

            }
        }
    }

}
