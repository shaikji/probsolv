package com.jilani.ds.avp.binarysearch.bsonanswer;

import com.jilani.ds.utils.Utils;

public class FindPeakElement {

	public static void main(String[] args) {

		FindPeakElement app = new FindPeakElement();
		int[] arr = { 5, 10, 20, 15 };
		Utils.printArray(arr);
		System.out.println(" Peak element index = " + app.findPeak(arr));
		System.out.println(" Peak element index = " + app.findPeakIndex(arr));
		

		int[] arr2 = { 10, 20, 15, 2, 23, 90, 67 };
		Utils.printArray(arr2);
		System.out.println(" Peak element Index = " + app.findPeak(arr2));
		System.out.println(" Peak element Index = " + app.findPeakIndex(arr2));

	}

	int findPeakIndex(int[] arr) {

		if (arr == null || arr.length == 0) {
			return -1;
		}

		int l = 0;
		int r = arr.length - 1;

		while (l <= r) {

			int mid = l + (r - l) / 2;

			if (mid == 0 || mid == arr.length - 1)
				return mid;

			else if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
				return mid;
			else if (arr[mid + 1] > arr[mid])
				l = mid + 1;
			else
				r = mid - 1;
		}

		return -1;
	}

	int findPeak(int[] arr) {

		if (arr == null || arr.length == 0)
			return -1;

		return binsearch_on_answer_v2(arr, 0, arr.length - 1);
	}

	int binsearch_on_answer(int[] arr, int start, int end) {

		while (start <= end) {

			int mid = start + (end - start) / 2;

			boolean left = true;
			if (mid > 0 && arr[mid] <= arr[mid - 1])
				left = false;
			boolean right = true;
			if (mid < arr.length - 1 && arr[mid] <= arr[mid + 1])
				right = false;

			if (left && right)
				return mid;
			else if (left)
				start = mid + 1;
			else
				end = mid - 1;
		}

		return -1;
	}

	int binsearch_on_answer_v2(int[] arr, int start, int end) {

		while (start < end) {

			int mid = start + (end - start) / 2;

			if (arr[mid] > arr[mid + 1])
				end = mid;
			else
				start = mid + 1;
		}

		return start;
	}

}
