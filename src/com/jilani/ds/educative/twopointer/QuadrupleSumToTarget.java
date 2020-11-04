package com.jilani.ds.educative.twopointer;

import java.util.*;

class QuadrupleSumToTarget {

	public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
		List<List<Integer>> quadruplets = new ArrayList<>();

		if (arr == null || arr.length < 4) {
			return quadruplets;
		}

		for (int i = 0; i < arr.length - 3; i++) {
			if (i > 0 && arr[i] == arr[i - 1])
				continue;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] == arr[j - 1])
					continue;

				int sum = target - arr[i] - arr[j];
				searchPair(arr, arr[i], arr[j], sum, j + 1, quadruplets);
			}
		}

		return quadruplets;
	}

	static void searchPair(int[] arr, int first, int second, int targetSum, int left, List<List<Integer>> quadruplets) {
		int right = arr.length - 1;
		int currSum = 0;

		while (left < right) {
			currSum = arr[left] + arr[right];

			if (currSum == targetSum) {
				quadruplets.add(Arrays.asList(first, second, left, right));
				left++;
				right--;

				while (left < right && arr[left] == arr[left - 1])
					left++;

				while (left < right && arr[right] == arr[right + 1])
					right--;
			} else if (currSum < targetSum) {
				left++;
			} else {
				right--;
			}
		}
	}
}