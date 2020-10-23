package com.jilani.ds.avp.binarysearch;

public class BinarySearchOnInfiniteSortedArray {

	public static void main(String[] args) {

		BinarySearchOnInfiniteSortedArray app = new BinarySearchOnInfiniteSortedArray();

		int[] arr = new int[1000];
		for ( int i=0; i < 1000; i++) {
			arr[i] = 2 * i;
		}
		
		int x = 678;
		System.out.println(" index = " + app.binsearchInfinite(arr, x));

	}

	int binsearchInfinite(int[] arr, int x) {

		if (arr == null || arr.length == 0)
			return -1;
		
		int i=0; 
		int j=1;
		
		while ( j < arr.length && arr[j] < x) {
			i = j;
			j = 2 * j;
		}
		
		if ( j >= arr.length)
			return -1;
		
		return binsearchutil(arr, i, j, x);
	}

	int binsearchutil(int[] arr, int l, int r, int x) {

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == x)
				return mid;
			else if (x < arr[mid])
				r = mid - 1;
			else
				l = mid + 1;
		}
		return -1;
	}

}
