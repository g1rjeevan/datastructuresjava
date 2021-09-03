package com.datastructures.java.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShortSubSegment {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            final String input = bufferedReader.readLine();
            final int ele = Integer.parseInt(bufferedReader.readLine());
            final List<String> subInputCheck = new ArrayList<>(ele);
            for (int i = 0; i < ele; i++) {
                subInputCheck.add(bufferedReader.readLine());
            }
            System.out.println(String.join(" ", subInputCheck));
            final String[] filteredInput = input.replaceAll("\\.", "").split(" ");

            final List<Integer> integers = Arrays.stream(filteredInput).map(s -> {
                final char[] chars = s.toCharArray();
                int i = 0;
                for (char c : chars) {
                    int j = c - '0';
                    i += j;
                }
                return i;
            }).collect(Collectors.toList());
            System.out.println(String.join(" ", integers.toString()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
