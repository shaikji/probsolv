package com.jilani.ds.avp.binarysearch;

public class MinimumDifferenceElementInSortedArray {

	public static void main(String[] args) {
		
		MinimumDifferenceElementInSortedArray app = new MinimumDifferenceElementInSortedArray();
		int[] arr = { 4,6,7,10};
		int key = 9;
		
		System.out.println(" Min diff element = " + app.findMinDiffElement(arr, key));
	
	}

	int findMinDiffElement(int[] arr, int key) {
		
		if ( arr == null || arr.length == 0 )
			return -1;
		int n = arr.length;
		int index = binsearch(arr, 0, n-1, key);
		
		if ( index != -1)
			return arr[index];
		
		int floor = floor(arr,0, n-1, key);
		int ceil = ceil(arr,0, n-1, key);
		
		if ( Math.abs(floor-key) < Math.abs(ceil-key))
			return floor;
		else
			return ceil;
	}
	
	int binsearch(int[] arr, int l, int r, int x) {

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
	
	int floor(int[] arr, int l, int r, int x) {

		int floor = -1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == x) {
				return arr[mid];
			} else if (x < arr[mid]) {
				r = mid - 1;
			} else {
				floor = arr[mid];
				l = mid + 1;
			}
		}
		return floor;
	}
	
	int ceil(int[] arr, int l, int r, int x) {

		int ceil = -1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == x) {
				return arr[mid];
			} else if (x < arr[mid]) {
				ceil = arr[mid];
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return ceil;
	}
}
