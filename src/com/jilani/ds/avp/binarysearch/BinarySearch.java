package com.jilani.ds.avp.binarysearch;

public class BinarySearch {

	public static void main(String[] args) {

		BinarySearch app = new BinarySearch();

		int[] arr = { 1, 2, 3, 4, 5 };
		int x = 2;
		System.out.println(" index = " + app.binsearch(arr, x));

	}

	int binsearch(int[] arr, int x) {

		if (arr == null || arr.length == 0)
			return -1;
		return binsearchutil(arr, 0, arr.length - 1, x);
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
