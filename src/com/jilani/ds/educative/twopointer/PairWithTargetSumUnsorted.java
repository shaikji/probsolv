package com.jilani.ds.educative.twopointer;

import java.util.Arrays;
import java.util.HashMap;

import com.jilani.ds.utils.Utils;

// Find pair with target sum if array is sorted.
// If the array is not sorted, use HashMap approach O(n) extra space.

public class PairWithTargetSumUnsorted {

	public static void main(String[] args) {

		int[] arr = {2,4,6,1,3};
		int targetSum = 6;
		Utils.printArray(arr);
		System.out.println(" Pair Indexes =  " + Arrays.toString(findPairWithSum(arr, targetSum)));
	}

	// Array is not sorted, so use HashMap approach
	
	static int[] findPairWithSum(int[] arr, int targetSum) {

		if (arr == null || arr.length == 0)
			return new int[] { -1, -1 };

		HashMap<Integer, Integer> map = new HashMap();
		
		for (int i=0; i < arr.length; i++) {
			if ( map.containsKey(targetSum - arr[i])) {
				return new int[] { map.get(targetSum-arr[i]), i };
			}
			map.put(arr[i],i);
		}
		// For single element, there is no pair.so return -1.
		return new int[] { -1, -1 };

	}
}
