package com.jilani.ds.educative.twopointer;

import java.util.*;

class TripletWithSmallerSum {
	
	public static void main(String[] args) {
		System.out.println(" count of triplets with smaller sum = " + searchTriplets(new int[] {-1, 0, 2, 3}, 3));
		System.out.println(" count of triplets with smaller sum = " + searchTriplets(new int[] {-1, 4, 2, 1, 3}, 5));

	}

	public static int searchTriplets(int[] arr, int target) {
		int count = 0;

		if (arr == null || arr.length < 3)
			return count;

		Arrays.sort(arr);

		for (int i = 0; i < arr.length - 2; i++) {
			count += findTriplets(arr, i, target, i + 1);
		}
		return count;
	}

	private static int findTriplets(int[] arr, int i, int target, int left) {
		int tripletSum = 0;
		int right = arr.length - 1;
		int count = 0;
		
		while (left < right) {
			tripletSum = arr[i] + arr[left] + arr[right];
			if (tripletSum < target) {
				count += (right - left);
				left++;
				// You dont need to reset right to arr.length-1 as this wont be an answer.
			} else {
				right--;
			}
		}

		return count;
	}
}