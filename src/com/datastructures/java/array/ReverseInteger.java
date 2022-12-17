package com.datastructures.java.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class ReverseInteger {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = 5; //getInt(reader.readLine());
        int[] vals = {1213232, 214343, 214343, 23442, 2};
        //new int[size];
/*        for (int i = 0; i < size; i++) {
            vals[i] = getInt(reader.readLine());
        }*/

        for (int i = 0; i < size; i++) {
            System.out.println(Integer.parseInt(lastDigit(vals[i], 10, "")));
        }
    }


    private static int getInt(String input) {
        if (Objects.isNull(input)) {
            return 0;
        } else {
            return Integer.parseInt(input);
        }
    }

    // Find the last digit
    public static String lastDigit(int n, int counter, String val) {
        if (n != 0) {
            int rem = n % counter;
            n = n - rem;
            int s = 1;
            if (counter > 10) {
                s = counter / 10;
            }
            val += rem / s;
            counter *= 10;
            return lastDigit(n, counter, val);
        }
        return val;
    }

}

