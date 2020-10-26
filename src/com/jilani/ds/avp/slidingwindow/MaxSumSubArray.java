package com.jilani.ds.avp.slidingwindow;

public class MaxSumSubArray {

	public static void main(String[] args) {

		int[] arr = { 2, 1, 5, 1, 3, 2 };
		int K = 3;

		int maxsum = findMaxSumSubArray(arr, K);
		System.out.println(" Max sum sub array of window " + K + " = " + maxsum);
	}

	static int findMaxSumSubArray(int[] arr, int K) {

		if (arr == null || arr.length == 0 || K <= 0)
			return -1;

		int currSum = 0;
		int maxSum = 0;
		int windowStart = 0;
		
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			currSum += arr[windowEnd];
			if (windowEnd - windowStart + 1 == K) {
				maxSum = Math.max(maxSum, currSum);
				currSum -= arr[windowStart];
				windowStart++;
			}
		}

		return maxSum;
	}
}
