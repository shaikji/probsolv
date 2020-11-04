package com.jilani.ds.educative.twopointer;

public class CountSubArraysWithProductLessThanTarget {

	public static void main(String[] args) {
		System.out.println(countSubarrays(new int[] { 1, 2, 3, 4 }, 10));
		System.out.println(countSubarrays(new int[] { 1, 9, 2, 8, 6, 3, 4 }, 100));
		System.out.println(countSubarrays(new int[] { 5, 3, 2 }, 16));
		System.out.println(countSubarrays(new int[] { 100, 200 }, 100));
		System.out.println(countSubarrays(new int[] { 100, 200 }, 101));
	}

	static int countSubarrays(int[] arr, int targetProduct) {

		// Use sliding window approach: 
		// At each index calculate how many the element contributes and add it to the count.
		
		int windowStart = 0;
		int product = 1;
		int count = 0;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

			product = product * arr[windowEnd];
			while (product >= targetProduct && windowStart <= windowEnd) {
				product = product / arr[windowStart];
				windowStart++;
			}
			count += (windowEnd - windowStart + 1);
		}
		return count;
	}

}

// Time - O(n)
// Space - O(1)
