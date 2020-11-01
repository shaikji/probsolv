package com.jilani.ds.educative.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumWithZero {

	public static void main(String[] args) {

		List<List<Integer>> triplets = findTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 });
		System.out.println(triplets);

		List<List<Integer>> triplets2 = findTriplets(new int[] { -5, 2, -1, -2, 3 });
		System.out.println(triplets2);
	}

	static List<List<Integer>> findTriplets(int[] arr) {

		List<List<Integer>> triplets = new ArrayList();

		// First Step: Sort the array
		Arrays.sort(arr);

		for (int i = 0; i < arr.length - 2; i++) {
			// Find a pair with sum -arr[i] starting at index i+1

			// Skip duplicates to avoid duplicate triplets
			if (i > 0 && arr[i] == arr[i - 1])
				continue;

			findPairWithSum(arr, -arr[i], i + 1, triplets);
		}

		return triplets;
	}

	static void findPairWithSum(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {

		int right = arr.length - 1;

		while (left < right) {

			if (arr[left] + arr[right] == targetSum) {
				triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
				left++;
				right--;
				// Move left and right to point to proper non duplicates
				// You cannot move this to end
				// This loop should be executed when left++ is done.
				while (left < right && arr[left] == arr[left - 1])
					left++;
				// This loop should be executed when right-- is done.
				while (left < right && arr[right] == arr[right + 1])
					right--;
			} else if (arr[left] + arr[right] < targetSum) {
				left++;
			} else {
				right--;
			}

		}

	}
}
