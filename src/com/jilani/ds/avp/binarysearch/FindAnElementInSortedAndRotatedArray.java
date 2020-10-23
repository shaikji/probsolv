package com.jilani.ds.avp.binarysearch;

import com.jilani.ds.utils.Utils;

public class FindAnElementInSortedAndRotatedArray {

	public static void main(String[] args) {

		FindAnElementInSortedAndRotatedArray app = new FindAnElementInSortedAndRotatedArray();
		int[] arr = { 4,5,6,7,1,2,3};

		Utils.printArray(arr);
		for ( int i = 0; i < 10; i++)
			System.out.println("Index of " + i +" = " + app.search(arr, i));
	}
	
	int search(int[] arr, int x) {
		
		if ( arr == null || arr.length == 0)
			return -1;
		
		return searchutil(arr, 0, arr.length-1, x);
	}
	
	int searchutil(int[] arr, int l, int r, int x) {
		
		while ( l <= r ) {
			
			int mid = l + (r-l)/2;
			
			if ( arr[mid] == x) {
				return mid;
			} // If left is sorted
			else if (arr[l] <= arr[mid]) {
				if ( x >= arr[l] && x < arr[mid]) {
					r = mid -1;
				} else {
					l = mid + 1;
				}
			} else {
				if ( x > arr[mid] && x <= arr[r]) {
					l = mid + 1;
				} else {
					r = mid -1;
				}
			}
			
		}
		
		return -1;
	}

}
