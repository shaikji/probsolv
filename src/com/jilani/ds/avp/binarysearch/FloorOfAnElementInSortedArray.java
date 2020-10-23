package com.jilani.ds.avp.binarysearch;

import com.jilani.ds.utils.Utils;

public class FloorOfAnElementInSortedArray {

	public static void main(String[] args) {

		FloorOfAnElementInSortedArray app = new FloorOfAnElementInSortedArray();

		 int[] arr = { 2, 4, 10, 10, 10, 18, 20 };
		//int[] arr = { 10, 10, 10, 10, 10, 10, 10 };
		Utils.printArray(arr);
		int x = 19;
		System.out.println(" floor of " + x + " = " + app.floor(arr, x));

	}

	int floor(int[] arr, int x) {

		if (arr == null || arr.length == 0)
			return -1;
		return floorutil(arr, 0, arr.length - 1, x);
	}

	int floorutil(int[] arr, int l, int r, int x) {

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

}
