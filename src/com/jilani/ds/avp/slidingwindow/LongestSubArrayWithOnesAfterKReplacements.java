package com.jilani.ds.avp.slidingwindow;

public class LongestSubArrayWithOnesAfterKReplacements {

	public static void main(String[] args) {

		int[] arr = { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 };
		int K = 2;
		int maxlen = findMaxLength(arr, K);
		System.out.println(" Longest sub array with 1s after " + K + " replacements allowed = " + maxlen);

		int[] arr2 = { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 };
		int K2 = 3;
		maxlen = findMaxLength(arr2, K2);
		System.out.println(" Longest sub array with 1s after " + K2 + " replacements allowed = " + maxlen);
	}

	static int findMaxLength(int[] arr, int K) {

		if (arr == null || arr.length == 0 || K <= 0)
			return 0;
		int windowStart = 0;
		int numZeroes = 0;
		int maxlen = 0;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			if (arr[windowEnd] == 0)
				numZeroes++;
			while (numZeroes > K) {
				if (arr[windowStart] == 0)
					numZeroes--;
				windowStart++;
			}
			// Window is proper now
			maxlen = Math.max(maxlen, windowEnd - windowStart + 1);
		}
		return maxlen;
	}

}
