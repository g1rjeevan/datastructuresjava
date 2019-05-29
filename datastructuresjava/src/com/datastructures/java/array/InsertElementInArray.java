package com.datastructures.java.array;

public class InsertElementInArray {

	public static void main(String[] args) {
		int[] array = new int[0];
		print(array);
		array = insertAtEnd(array, 45);
		print(array);
		array = insertAtEnd(array, 54);
		print(array);
	}
	
	public static int[] insertAtEnd(final int[] array, int val) {
		final int[] new_array = new int[array.length+1];
		if(array.length>0) {
			for(int old_i=0;old_i<=array.length-1;old_i++)
				new_array[old_i]=array[old_i];
		}
		new_array[array.length]=val;
		return new_array;
	}
	
	public static void print(final int[] array) {
		for(int i:array)
			System.out.print(i+" ");
		System.out.println();
	}
	
}
