package com.jilani.ds.avp.stacks;

import com.jilani.ds.utils.Utils;

public class RainwaterTrapping {

	public static void main(String[] args) {
		
		RainwaterTrapping app = new RainwaterTrapping();

		int[] arr = { 3, 0, 0, 2, 0, 4 };

		System.out.println(" max rain = " + app.maxRainTrapping(arr));
	}
	
	int maxRainTrapping(int[] arr) {
		
		if ( arr == null || arr.length == 0 )
			return 0;
		
		int[] leftMax = maxInLeft(arr);
		int[] rightMax = maxInRight(arr);
		
		Utils.printArray(arr);
		int sum = 0;
		for ( int i=0; i < arr.length; i++) {
			sum += (Math.min(leftMax[i], rightMax[i]) - arr[i]);
		}
		return sum;
	}

	
	// Find Max in Right, including itself
	int[] maxInRight(int[] arr) {
		int[] maxRight = new int[arr.length];
		int max = Integer.MIN_VALUE;
		for (int i = arr.length - 1; i >= 0; i--) {
			maxRight[i] = Math.max(max, arr[i]);
			max = maxRight[i];
		}
		return maxRight;
	}

	// Find Max in Left including itself
	int[] maxInLeft(int[] arr) {
		int[] maxLeft = new int[arr.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			maxLeft[i] = Math.max(max, arr[i]);
			max = maxLeft[i];
		}
		return maxLeft;
	}

}
