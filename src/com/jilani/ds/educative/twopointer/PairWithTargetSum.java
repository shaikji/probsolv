package com.jilani.ds.educative.twopointer;

import java.util.Arrays;

import com.jilani.ds.utils.Utils;

public class PairWithTargetSum {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 6 };
		int targetSum = 6;
		Utils.printArray(arr);
		System.out.println(" Pair Indexes =  " + Arrays.toString(findPairWithSum(arr, targetSum)));
	}

	static int[] findPairWithSum(int[] arr, int targetSum) {

		if (arr == null || arr.length == 0)
			return new int[] { -1, -1 };

		int i = 0;
		int j = arr.length - 1;

		while (i < j) {

			if (arr[i] + arr[j] == targetSum) {
				return new int[] { i, j };
			} else if (arr[i] + arr[j] < targetSum) {
				i++;
			} else {
				j--;
			}
		}

		// For single element, there is no pair.so return -1.
		return new int[] { -1, -1 };

	}
}
