package com.jilani.ds.avp.binarysearch;

import com.jilani.ds.utils.Utils;

public class FirstAndLastOccuranceInSortedArray {

	public static void main(String[] args) {

		FirstAndLastOccuranceInSortedArray app = new FirstAndLastOccuranceInSortedArray();

		
		//int[] arr = { 2, 4, 10, 10, 10, 18, 20 };
		int[] arr = { 10, 10, 10, 10, 10, 10, 10 };
		Utils.printArray(arr);
		int x = 10;
		System.out.println(" firstOccurance of " + x + " = " + app.firstOccuranceOfX(arr, x));
		System.out.println(" lastOccurance of " + x + " = " + app.lastOccuranceOfX(arr, x));

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
