package com.datastructures.java.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RangeOfDiffPrimeNumber {

    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        if (size > 0) {
            String[] vals = new String[size];
            for (int i = 0; i < size; i++) {
                vals[i] = reader.readLine();
            }

            for (String val : vals) {
                String[] valArray = val.split(" ");
                if (valArray.length == 2) {
                    int x = Integer.parseInt(valArray[0]);
                    int y = Integer.parseInt(valArray[1]);
                    if (y > x) {
                        int res = getPrimeNumber(y, x, y);
                        if (res >= 0) {
                            System.out.println(res);
                        } else {
                            System.out.println(-1);
                        }
                    } else {
                        System.out.println(0);
                    }
                }
            }

        }

    }

    public static int getPrimeNumber(int valLong, int lessPrime, int greatPrime) {
        int valDoubleSrt = (int) Math.sqrt(valLong);
        boolean[] primeNumbers = new boolean[valLong + 1];
        for (int i = lessPrime; i <= greatPrime; i++) {
            int j = 2;
            while (true) {
                if (i % j == 0) {
                    if (i != j) {
                        primeNumbers[i] = true;
                    }
                    break;
                } else {
                    if (j > valDoubleSrt) {
                        break;
                    } else {
                        j++;
                    }
                }
            }
        }
        boolean initialNumberBool = false;
        int initialNumber = greatPrime;
        int lastNumber = 0;
        for (int k = lessPrime; k <= primeNumbers.length && k <= greatPrime; k++) {
            if (primeNumbers[k] == false) {
                if (!initialNumberBool) {
                    initialNumberBool = true;
                    initialNumber = k;
                }
                lastNumber = k;
            }
        }
        return lastNumber - initialNumber;
    }

}
