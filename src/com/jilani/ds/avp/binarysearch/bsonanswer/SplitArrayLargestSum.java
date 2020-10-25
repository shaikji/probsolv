package com.jilani.ds.avp.binarysearch.bsonanswer;

public class SplitArrayLargestSum {

	public static void main(String[] args) {

		int[] arr = { 7, 2, 5, 10, 8 };
		int m = 2;

		int ans = findMinLargestSum(arr, m);
		System.out.println(" Min Largest sum = " + ans);
	}

	static int findMinLargestSum(int[] arr, int m) {

		if (arr == null || arr.length == 0 || m <= 0)
			return -1;

		int max = 0;
		int sum = 0;
		int best = 0;

		for (int elem : arr) {
			max = Math.max(max, elem);
			sum += elem;
		}

		// Sum varies from max to sum

		int l = max;
		int r = sum;

		while (l <= r) {
			int mid = l + (r - l) / 2;

			int num = split(arr, mid);

			if (num <= m) {
				best = mid;
				r = mid - 1;
			} else if (num > m) {
				l = mid + 1;
			}
		}

		return best;
	}

	static int split(int[] arr, int S) {

		int currSum = 0;
		int num = 1;

		for (int i = 0; i < arr.length; i++) {

			if (currSum + arr[i] > S) {
				num++;
				currSum = arr[i];
			} else {
				currSum += arr[i];
			}
		}
		return num;

	}

}

/*
 * 
 * Leetcode #410. Split Array Largest Sum --------------------------------------
 * 
 * 
 * Given an array nums which consists of non-negative integers and an integer m,
 * you can split the array into m non-empty continuous subarrays.
 * 
 * Write an algorithm to minimize the largest sum among these m subarrays.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [7,2,5,10,8], m = 2 Output: 18 Explanation: There are four ways
 * to split nums into two subarrays. The best way is to split it into [7,2,5]
 * and [10,8], where the largest sum among the two subarrays is only 18. Example
 * 2:
 * 
 * Input: nums = [1,2,3,4,5], m = 2 Output: 9 Example 3:
 * 
 * Input: nums = [1,4,4], m = 3 Output: 4
 * 
 * 
 */
