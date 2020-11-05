package com.jilani.ds.educative.twopointer;

class ShortestWindowSort {

	public static void main(String[] args) {
		System.out.println(sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
		System.out.println(sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
		System.out.println(sort(new int[] { 1, 2, 3 }));
		System.out.println(sort(new int[] { 3, 2, 1 }));

	}

	public static int sort(int[] arr) {

		if (arr == null || arr.length == 0)
			return -1;

		// Step 1: Position low and high to the window boundaries such that elements are
		// not in order

		int low = 0;
		int high = arr.length - 1;

		while (low < arr.length - 1 && arr[low] <= arr[low + 1])
			low++;
		// check point 1: If low reaches end, array is already sorted, so return 0;

		if (low == arr.length - 1)
			return 0;

		while (high > 0 && arr[high] >= arr[high - 1])
			high--;

		// Now low and high points to the proper boundary. This window needs to be
		// sorted.
		// However, we also need to adjust low and high so that any elements
		// in low or high may also need to be sorted.

		// Find subArray Min and max elements
		int subarrayMin = Integer.MAX_VALUE;
		int subarrayMax = Integer.MIN_VALUE;

		for (int k = low; k <= high; k++) {
			subarrayMin = Math.min(subarrayMin, arr[k]);
			subarrayMax = Math.max(subarrayMax, arr[k]);
		}
		// Include all the elements, higher than the SubArray MIN Element
		while (low > 0 && arr[low - 1] > subarrayMin)
			low--;
		// Include all the elements, lower than the subArray MAX Elements
		while (high < arr.length - 1 && arr[high + 1] < subarrayMax)
			high++;
		// Return the window.
		return high - low + 1;
	}
}