package com.jilani.ds.avp.binarysearch;

public class BinarySearchUnknownOrder {

	public static void main(String[] args) {

		BinarySearchUnknownOrder app = new BinarySearchUnknownOrder();

		int[] arr = { 5, 4, 3, 2, 1 };
		int x = 2;
		System.out.println(" index = " + app.binsearch(arr, x));

		int[] arr2 = { 1, 2, 3, 4, 5 };
		int y = 2;
		System.out.println(" index = " + app.binsearch(arr2, y));

	}

	int binsearch(int[] arr, int x) {

		if (arr == null || arr.length == 0)
			return -1;

		if (arr[0] <= arr[arr.length - 1])
			return binsearchutil(arr, 0, arr.length - 1, x);
		else
			return binsearchutilrev(arr, 0, arr.length - 1, x);
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

	int binsearchutilrev(int[] arr, int l, int r, int x) {

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == x)
				return mid;
			else if (x < arr[mid])
				l = mid + 1;
			else
				r = mid - 1;
		}
		return -1;
	}

}
