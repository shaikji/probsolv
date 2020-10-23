package com.jilani.ds.avp.binarysearch;

import com.jilani.ds.utils.Utils;

public class SearchAnElementInANearlySortedArray {

	public static void main(String[] args) {

		SearchAnElementInANearlySortedArray app = new SearchAnElementInANearlySortedArray();

		int[] arr = { 5, 10, 30, 20, 40 };
		Utils.printArray(arr);
		System.out.println(" index = " + app.binsearch(arr, 5));
		System.out.println(" index = " + app.binsearch(arr, 10));
		System.out.println(" index = " + app.binsearch(arr, 30));
		System.out.println(" index = " + app.binsearch(arr, 20));
		System.out.println(" index = " + app.binsearch(arr, 40));
		System.out.println(" index = " + app.binsearch(arr, 12));


	}

	int binsearch(int[] arr, int x) {

		if (arr == null || arr.length == 0)
			return -1;
		return binsearchutil(arr, 0, arr.length - 1, x);
	}

	int binsearchutil(int[] arr, int l, int r, int x) {

		while (l <= r) {
			int mid = l + (r - l) / 2;
			
			if ( x == arr[mid])
				return mid;
			if ( mid-1 >= l && arr[mid-1] == x)
				return mid-1;
			if ( mid+1 <= r && arr[mid+1] == x )
				return mid + 1;

			if (x < arr[mid])
				r = mid - 2;
			else
				l = mid + 2;
		}
		return -1;
	}

}
