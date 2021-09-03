package com.datastructures.java.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SieveOfErathonesePrime {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String value = br.readLine();
		int valLong = Integer.parseInt(value);
		int valDoubleSrt = (int) Math.sqrt(valLong);

		System.out.println(valDoubleSrt);
		boolean[] primeNumbers = new boolean[valLong];
		for(int i=0;i<primeNumbers.length;i++) {
			int j=2;
			while(true) {
				if(i%j==0) {
					if(i!=j) {
						primeNumbers[i]=true;
					}
					break;
				}else {
					if(j>valDoubleSrt) {
						break;
					}else {
						j++;
					}
				}
			}
		}
		
		for(int k=2;k<primeNumbers.length;k++) {
			if(primeNumbers[k]==false) {
				System.out.print(k+", b ");
			}
		}
	}
	

}
