package com.datastructures.java.string;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractSocieteGeneralTest implements SocieteGeneralTest {
    public static final String inputDir = "/workspaces/java/";

    @Override
    public void input(final String inputFileText) throws IOException {

        final String inputFile = inputDir + inputFileText;

        System.setIn(new FileInputStream(inputFile));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int inputStringCount = br.read();
            String inputString = br.readLine();

        }

    }


    @Override
    public abstract void output();

}
