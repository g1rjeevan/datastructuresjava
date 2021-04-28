package com.datastructures.java.string;

import java.io.*;
import java.util.*;
import java.lang.*;

public class CoronavirusCandidateCode {

    public static void main(String args[] ) throws Exception {
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(System.in));
        String vComposition = "coronavirus";//reader.readLine();
        if(Objects.nonNull(vComposition)){
            int size = 1;//Integer.parseInt(reader.readLine());
            String[] vals = {"onarous"};
            for(int i=0;i<size;i++){
                vals[i]="onarous";
            }
            char[] vCompositionChar = vComposition.toCharArray();
            for(String val:vals){
                System.out.println(testSubsequence(val, vCompositionChar));
            }
        }
    }

    public static String testSubsequence(final String val, final char[] vCompositionChar){
        char[] valChar = val.toCharArray();
        boolean foundFirstChar= false;
        for(char valC: valChar){
            boolean found = false;
            for(int i=0;i<vCompositionChar.length;i++){
                if(vCompositionChar[i]==valC){
                    foundFirstChar = true;
                    found = true;
                }
            }
            if(!found){
                return "NEGATIVE";
            }
        }

        if(foundFirstChar){
            return "POSTITIVE";
        }else{
            return "NEGATIVE";
        }

    }

}
