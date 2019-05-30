package com.datastructures.java.array;

public class InsertElementInArray {

	public static void main(String[] args) {
		int[] array = new int[0];
		print(array);
		array = appendAtEnd(array, 45);
		print(array);
		array = appendAtEnd(array, 54);
		print(array);
		array = appendAtStart(array, 85);
		print(array);
		array = appendAtStart(array, 754);
		print(array);
		array = appendAtStart(array, 43);
		print(array);
		array = appendAtEnd(array, 7254);
		print(array);
		print(array);
		array = updateAtStart(array, 73);
		print(array);
		array = updateAtEnd(array, 34);
		print(array);
		array = appendAtIndex(array, 11, 3);
		print(array);
		array = appendAtIndex(array, 12, 4);
		print(array);
		array = updateAtIndex(array, 13, 3);
		print(array);
		array = updateAtIndex(array, 14, 4);
		print(array);

	}

	public static int[] appendAtEnd(final int[] array, final int val) {
		final int[] new_array = new int[array.length + 1];
		if (array.length > 0) {
			for (int old_i = 0; old_i <= array.length - 1; old_i++)
				new_array[old_i] = array[old_i];
		}
		new_array[array.length] = val;
		return new_array;
	}

	public static int[] appendAtStart(final int[] array, final int val) {
		final int[] new_array = new int[array.length + 1];
		new_array[0] = val;
		if (array.length > 0) {
			for (int old_i = 0; old_i <= array.length - 1; old_i++)
				new_array[old_i + 1] = array[old_i];
		}
		return new_array;
	}

	public static int[] appendAtIndex(final int[] array, final int val, final int index) {
		final int[] new_array = new int[array.length + 1];
		int changedIndex = 0;
		for (int i = 0; i <= array.length - 1; i++) {
			if (i == index) {
				new_array[index] = val;
				changedIndex = 1;
			}
			new_array[i + changedIndex] = array[i];

		}
		return new_array;
	}

	public static int[] updateAtStart(final int[] array, final int val) {
		array[0] = val;
		return array;
	}

	public static int[] updateAtEnd(final int[] array, final int val) {
		array[array.length - 1] = val;
		return array;
	}

	public static int[] updateAtIndex(final int[] array, final int val, final int index) {
		array[index] = val;
		return array;
	}

	public static void print(final int[] array) {
		for (int i : array)
			System.out.print(i + " ");
		System.out.println();
	}

}
