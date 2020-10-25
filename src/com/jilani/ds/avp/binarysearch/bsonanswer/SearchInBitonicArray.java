package com.jilani.ds.avp.binarysearch.bsonanswer;

import com.jilani.ds.utils.Utils;

public class SearchInBitonicArray {

	public static void main(String[] args) {
		
		SearchInBitonicArray app = new SearchInBitonicArray();
		int[] arr = {5, 10, 20,15 };
		Utils.printArray(arr);
		int x = 15;
		System.out.println(" Index of " + x + " = " + app.searchInBitonic(arr,x));

		System.out.println();
		int[] arr2 = {10, 20, 30, 40, 35, 25, 15 };
		Utils.printArray(arr2);
		x = 35;
		System.out.println(" Index of " + x + " = " +  app.searchInBitonic(arr2,x));
		
	}
	
	int searchInBitonic(int[] arr, int x) {
		
		if ( arr == null || arr.length == 0 )
			return -1;
		
		int peak = findPeakIndex(arr, 0, arr.length-1);
		
		if ( x > arr[peak])
			return -1;
		
		int left = binsearch_asc(arr, 0, peak, x);
		if ( left != -1)
			return left;
		
		return binsearch_desc(arr, peak+1, arr.length-1, x);
	}
	
	
	int findPeakIndex(int[] arr, int l, int r) {
		
		while ( l < r ) {
			
			int mid = l + (r-l)/2;
			
			if ( arr[mid] > arr[mid+1])
				r = mid;
			else
				l = mid + 1;
		}
		
		return l;
	}
	
	int binsearch_asc( int[] arr, int l, int r, int x) {
		
		while ( l <= r ) {
			
			int mid =  l + (r-l)/2;
			
			if ( arr[mid] == x)
				return mid;
			else if ( x < arr[mid])
				r = mid-1;
			else
				l = mid + 1;
		}
		return -1;
	}
	
	int binsearch_desc( int[] arr, int l, int r, int x) {
		
		while ( l <= r ) {
			
			int mid =  l + (r-l)/2;
			
			if ( arr[mid] == x)
				return mid;
			else if ( x < arr[mid])
				l = mid + 1;
			else
				r = mid - 1;
		}
		return -1;
	}

}
