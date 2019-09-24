package com.datastructures.java.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
class Men{
	public int number;
}

class A1 {
    public int i;
    protected int j;
}  


class B2 extends A1 {
    int j;

    void display() {
        super.j = 3;
        super.i = 10;
        System.out.println(i + " " + j);
    }
}
 
public class SolutionMain {

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String S = sc.next();
//		SolutionMain s = new SolutionMain();
//		s.solution(S);
//	}
//
//	public void solution(String S) {
//		String[] playerPos = S.split("");
//		int count = 1;
//		for (int i = 1; i < playerPos.length; i++) {
//			if (playerPos[i - 1].equals("1") && playerPos[i].equals("1")) {
//				count++;
//				if (count >= 6) {
//					System.out.println("YES");
//					return;
//				}
//			} else {
//				count = 0;
//			}
//		}
//
//
//		count = 1;
//		for (int i = 1; i < playerPos.length; i++) {
//			if (playerPos[i - 1].equals("0") && playerPos[i].equals("0")) {
//				count++;
//				if (count >= 7) {
//					System.out.println("YES");
//					return;
//				}
//			} else {
//				count = 0;
//			}
//		}
//		
//		System.out.println("NO");	
//
//	}
//	public static void main(String[] args) throws InterruptedException {
//		Scanner sc = new Scanner(System.in);
//		int X = sc.nextInt();
//		int Y = sc.nextInt();
//		SolutionMain s = new SolutionMain();
//		s.solution(X, Y);
//	}
//
//	public void solution(int X, int Y) {
//		int cX = swapNumber(X);
//		int cY = swapNumber(Y);
//		List<Integer> sumList = new ArrayList<>();
//		sumList.add(cX + cY);
//		sumList.add(X + Y);
//		sumList.add(cX + Y);
//		sumList.add(X + cY);
//		Collections.sort(sumList);
//		Integer.parseInt(s)
//		System.out.println(sumList.get(0)+" "+sumList.get(sumList.size()-1));
//		
//	}
//
//	public Integer swapNumber(int X) {
//		String[] cXArray = String.valueOf(X).split("");
//		for (int i = 0; i < cXArray.length; i++) {
//			if (cXArray[i].equals("6")) {
//				cXArray[i] = "5";
//			} else if (cXArray[i].equals("5")) {
//				cXArray[i] = "6";
//			}
//		}
//		StringBuilder builder = new StringBuilder();
//		for(String s : cXArray) {
//		    builder.append(s);
//		}
//		String xC = builder.toString();
//		return Integer.parseUnsignedInt(xC);
//	}
	
	public void doIt(int i,Men p) {
		i=5;
		p.number = 8;
	}
	
	public static void main(String[] args) throws InterruptedException {
		B2 obj = new B2();
        obj.i = 1;
        obj.j = 2;   
        obj.display(); 
		
		int x=0;
		Men p =new Men();
		new SolutionMain().doIt(x,p);
		System.out.println(x+" "+p.number);
//		List<String> inputByLine = new ArrayList<String>();
//		try {
//			// Get the object of DataInputStream
//			InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
//			BufferedReader br = new BufferedReader(isr);
//			String line = br.readLine(); 
//	            String s= br.readLine();  
//	            String[] sss = s.split(" ");
//	            for(String sse: sss){
//	                inputByLine.add(sse);
//	            }
//			int size = 0;
//			List<Integer> sumInt = new ArrayList<>();
//
//			for (int i = 0; i < inputByLine.size(); i++) {
//				
//					int ss = Integer.parseInt(inputByLine.get(i));
//					sumInt.add(ss);
//			}
//			Collections.sort(sumInt);
//			Set<Integer> sumHash = new LinkedHashSet<>();
//			for (int i = 0; i < sumInt.size(); i++) {
//				sumHash.add((int) sumInt.get(i));
//			}
//			int sumHasInt = 0;
//			for (Integer sum : sumHash) {
//				sumHasInt += sum;
//			}
//			System.out.println(sumHasInt);
//			isr.close();
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
	}
}
