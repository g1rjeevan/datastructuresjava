package com.datastructures.java.string;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

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

/*    50
    9
    ambiguous
    3
    set
    5
    uouae
    1
    a
    7
    rhythms
    7
    egilops
    6
    eunoia
    9
    strengths
    9
    spoonfeed
    9
    ouenouaou
    10
    scraunched
    11
    catchphrase
    11
    dysrhythmia
    12
    twyndyllyngs
    13
    breakthroughs
    16
    unprosperousness
    15
    overimaginative
    17
    unimaginativeness
    17
    punctoschmidtella
    17
    straightforwardly
    18
    strengthlessnesses
    19
    saippuakivikauppias
    20
    chrononhotonthologos
    20
    ultrarevolutionaries
    23
    ussolzewiechinogammarus
    27
    honorificabilitudinitatibus
    45
    pneumonoultramicroscopicsilicovolcanoconiosis
    4
    oraf
    5
    eauoe
    1
    r
    5
    ueevo
    2
    lq
    3
    ogg
    1
    p
    3
    ufa
    5
    ikaxr
    1
    e
    39
    qthmkbrnhktplfnhwjyldqnfpstyhmqvlsgrcjq
    4
    mzuu
    2
    io
    24
    uabqnhkxezzibvisoebqxkoi
    1
    h
    25
    wayidupavotezavuzeloqeqax
    2
    ef
    19
    cocqeaveankukpupdgk
    13
    brqnvknzqkmzj
    8
    eauoeiuz
    38
    itatapecuvotelibohixovefirucevexiyepog
    22
    iueiaeuuaeiaeaaoouuaoa
    40
    toyibawsnahytbtzmtrfopizpmfkrmscbamyvako*/


    //OutPut
/*    8
            3
            0
            0
            0
            15
            3
            3
            4
            3
            5
            9
            1
            0
            4
            14
            105
            120
            13
            8
            12
            27
            41
            57
            42
            351
            105
            6
            0
            0
            3
            0
            1
            0
            3
            6
            0
            0
            1
            0
            15
            0
            300
            1
            14
            0
            1
            703
            0
            43*/
}
