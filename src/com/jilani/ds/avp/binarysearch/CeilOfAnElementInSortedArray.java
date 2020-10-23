package com.jilani.ds.avp.binarysearch;

import com.jilani.ds.utils.Utils;

public class CeilOfAnElementInSortedArray {

	public static void main(String[] args) {

		CeilOfAnElementInSortedArray app = new CeilOfAnElementInSortedArray();

		 int[] arr = { 2, 4, 10, 10, 10, 18, 20 };
		//int[] arr = { 10, 10, 10, 10, 10, 10, 10 };
		Utils.printArray(arr);
		int x = 3;
		System.out.println(" ceil of " + x + " = " + app.ceil(arr, x));

	}

	int ceil(int[] arr, int x) {

		if (arr == null || arr.length == 0)
			return -1;
		return ceilutil(arr, 0, arr.length - 1, x);
	}

	int ceilutil(int[] arr, int l, int r, int x) {

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
