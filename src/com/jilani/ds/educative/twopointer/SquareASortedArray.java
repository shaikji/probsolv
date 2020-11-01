package com.jilani.ds.educative.twopointer;

import com.jilani.ds.utils.Utils;

public class SquareASortedArray {

	public static void main(String[] args) {

		int[] arr = { -2, -1, 0, 2, 3 };
		Utils.printArray(arr);
		System.out.println(" Squares of a sorted Array ");
		int[] squares = squareArray(arr);
		Utils.printArray(squares);
	}

	static int[] squareArray(int[] arr) {

		if (arr == null || arr.length == 0)
			return arr;
		
		int[] squares = new int[arr.length];

		int i = 0;
		int j = arr.length - 1;
		int k = j;

		while (i <= j) {
			if (arr[i] * arr[i] > arr[j] * arr[j]) {
				squares[k] = arr[i] * arr[i];
				i++;
			} else {
				squares[k] = arr[j] * arr[j];
				j--;
			}
			k--;
		}
		return squares;

	}
}
