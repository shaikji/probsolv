package com.jilani.ds.avp.binarysearch;

import com.jilani.ds.utils.Utils;

public class NextAlphabetOfAGivenCharInSortedArray {

	public static void main(String[] args) {

		NextAlphabetOfAGivenCharInSortedArray app = new NextAlphabetOfAGivenCharInSortedArray();

		char[] arr = { 'a', 'b', 'f' ,'l', 'z' };
		Utils.printArray(arr);
		char x = 'c';
		System.out.println(" Next alphabet of " + x + " = " + app.ceil(arr, x));

	}

	char ceil(char[] arr, char x) {

		if (arr == null || arr.length == 0)
			return '#';
		return ceilutil(arr, 0, arr.length - 1, x);
	}

	char ceilutil(char[] arr, int l, int r, char x) {

		char ceil = '#';

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (x < arr[mid]) {
				ceil = arr[mid];
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return ceil;
	}

}
