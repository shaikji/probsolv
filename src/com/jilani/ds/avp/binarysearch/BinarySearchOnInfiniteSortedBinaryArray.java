package com.jilani.ds.avp.binarysearch;

public class BinarySearchOnInfiniteSortedBinaryArray {

	public static void main(String[] args) {

		BinarySearchOnInfiniteSortedBinaryArray app = new BinarySearchOnInfiniteSortedBinaryArray();

		int[] arr = new int[1000];
		for ( int i=0; i < 1000; i++) {
			if ( i < 200)
				arr[i] = 0;
			else
				arr[i] = 1;
		}
		System.out.println(" index = " + app.binsearchInfiniteBinary(arr));

	}

	int binsearchInfiniteBinary(int[] arr) {

		if (arr == null || arr.length == 0)
			return -1;
		
		int i=0; 
		int j=1;
		
		while ( j < arr.length && arr[j] < 1) {
			i = j;
			j = 2 * j;
		}
		
		if ( j >= arr.length)
			return -1;
		
		return binsearchutil(arr, i, j);
	}

	int binsearchutil(int[] arr, int l, int r) {

		int first = -1;
		
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == 1) {
				first = mid;
				r = mid-1;
			} else {
				l = mid + 1;
			}
		}
		return first;
	}

}
