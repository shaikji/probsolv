package com.jilani.ds.educative.twopointer;

import com.jilani.ds.utils.Utils;

public class RemoveDuplicates {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 3, 3, 6, 9, 9 };
		Utils.printArray(arr);
		System.out.println(" After removing duplicates ");
		int len = removeDuplicates(arr);
		for ( int i=0; i < len; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	static int removeDuplicates(int[] arr) {

		if (arr == null || arr.length == 0)
			return 0;

		int i = 0;
		
		for ( int j=1; j < arr.length; j++) {
			if ( arr[j] != arr[i]) {
				i++;
				arr[i] = arr[j];
			}
		}
		return i+1;
	}
}
