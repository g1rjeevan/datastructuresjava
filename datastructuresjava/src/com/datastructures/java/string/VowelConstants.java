package com.datastructures.java.string;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class VowelConstants {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("/workspaces/java/inVowalConstants.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String inputStringCount = br.readLine();
            String inputString = br.readLine();
            char[] inputStringArr = inputString.toCharArray();
            int[] inputBitCom = new int[inputStringArr.length];
            for (int k = 0; k < inputStringArr.length; k++) {
                char inputChar = inputStringArr[k];
                if (inputChar == 97 || inputChar == 101 || inputChar == 105 || inputChar == 111 || inputChar == 117)
                    inputBitCom[k] = 1;
                else
                    inputBitCom[k] = 0;
            }
            //System.out.print(inputString + " " + inputStringCount + " ");
            //Arrays.stream(inputBitCom).forEach(System.out::print);

            int count = 0;
            int checkCount = 0;
            for (int j = 1; j < inputBitCom.length; j++) {
                if (inputBitCom[j - 1] != inputBitCom[j]) {
                    count++;
                    checkCount++;
                } else {
                    if (checkCount > 1) {
                        if (j > checkCount) {
                            j = j - checkCount;
                        } else {
                            j = checkCount - j;
                        }
                    }
                    checkCount = 0;
                }
            }
            System.out.println(count);
        }
    }
}
