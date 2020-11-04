package com.jilani.ds.educative.twopointer;

import java.util.ArrayList;
import java.util.List;

public class SubArraysWithProductLessThanTarget {

	public static void main(String[] args) {
		printSubarrays(new int[] { 1, 2, 3, 4 }, 10);
		printSubarrays(new int[] { 1, 9, 2, 8, 6, 3, 4 }, 100);
		printSubarrays(new int[] { 5, 3, 2 }, 16);
		printSubarrays(new int[] { 100, 200 }, 100);
		printSubarrays(new int[] { 100, 200 }, 101);
	}
	
	static void printSubarrays(int[] arr, int targetProduct) {
		
		System.out.println(" =========== sub arrays =============");
		List<List<Integer>> res = getSubarrays(arr, targetProduct);
		System.out.println(" SubArrays count  = " + res.size());
		for ( List row: res)
			System.out.println(row);
		System.out.println("====================================");
		System.out.println();
	}

	static List<List<Integer>> getSubarrays(int[] arr, int targetProduct) {

		// Use sliding window approach: 
		// At each index calculate how many the element contributes and add it to the count.
		
		List<List<Integer>> subarrays = new ArrayList();
		
		int windowStart = 0;
		int product = 1;
		int count = 0;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

			product = product * arr[windowEnd];
			while (product >= targetProduct && windowStart <= windowEnd) {
				product = product / arr[windowStart];
				windowStart++;
			}
		
			// Add subsets
			List<Integer> row = new ArrayList();
			for ( int i = windowEnd; i >= windowStart; i--) {
				row.add(0, arr[i]);
				subarrays.add(new ArrayList<Integer>(row));
			}
		}
		return subarrays;
	}

}

// Time - O(n)
// Space - O(1)
