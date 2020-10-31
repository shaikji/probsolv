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
		System.out.println("\n");
		int[] arr2 = { 2, 3, 3, 3, 6, 9, 9 };
		Utils.printArray(arr2);
		System.out.println(" After removing duplicates V2 ");
		int len2 = removeDuplicatesV2(arr2);
		for ( int i=0; i < len2; i++) {
			System.out.print(arr2[i]+" ");
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
	
	static int removeDuplicatesV2(int[] arr) {

		if (arr == null || arr.length == 0)
			return 0;

		int nextNonDuplicate = 1; // Index of the next non duplicate element
		
		for ( int i=1; i < arr.length; i++) {
			if ( arr[i] != arr[nextNonDuplicate-1]) {
				arr[nextNonDuplicate] = arr[i];
				nextNonDuplicate++;
			}
		}
		return nextNonDuplicate;
	}
}
