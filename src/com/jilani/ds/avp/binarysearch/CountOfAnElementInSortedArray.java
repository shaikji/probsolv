package com.jilani.ds.avp.binarysearch;

import com.jilani.ds.utils.Utils;

public class CountOfAnElementInSortedArray {

	public static void main(String[] args) {

		CountOfAnElementInSortedArray app = new CountOfAnElementInSortedArray();

		
		int[] arr = { 2, 4, 10, 10, 10, 18, 20 };
		//int[] arr = { 10, 10, 10, 10, 10, 10, 10 };
		Utils.printArray(arr);
		int x = 10;
		int f = app.firstOccuranceOfX(arr, x);
		int l = app.lastOccuranceOfX(arr, x);
		int res = 0;
		if ( f != -1)
			res = l - f + 1;
		
		System.out.println(" Count of " + x + " in array = " + res);
	}

	int firstOccuranceOfX(int[] arr, int x) {

		if (arr == null || arr.length == 0)
			return -1;
		return firstOccurance(arr, 0, arr.length - 1, x);
	}

	int firstOccurance(int[] arr, int l, int r, int x) {

		int first = -1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == x) {
				first = mid;
				r = mid - 1;
			} else if (x < arr[mid])
				r = mid - 1;
			else
				l = mid + 1;
		}
		return first;
	}

	int lastOccuranceOfX(int[] arr, int x) {

		if (arr == null || arr.length == 0)
			return -1;
		return lastOccurance(arr, 0, arr.length - 1, x);
	}

	int lastOccurance(int[] arr, int l, int r, int x) {

		int last = -1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == x) {
				last = mid;
				l = mid +1;
			} else if (x < arr[mid])
				r = mid - 1;
			else
				l = mid + 1;
		}
		return last;
	}

}
