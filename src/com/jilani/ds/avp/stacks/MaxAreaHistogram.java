package com.jilani.ds.avp.stacks;

import java.util.Stack;

import com.jilani.ds.utils.Utils;

public class MaxAreaHistogram {

	public static void main(String[] args) {

		int[] heights = { 6, 2, 5, 4, 5, 1, 6 };

		MaxAreaHistogram app = new MaxAreaHistogram();
		Utils.printArray(heights);
		int max = app.mah(heights);
		System.out.println(" Max Area Histogram = " + max);
	}

	// Max Area Histogram

	int mah(int[] heights) {

		if (heights == null || heights.length == 0)
			return 0;

		int[] nsl = nseInLeft(heights);
		int[] nsr = nseInRight(heights);

		int max = Integer.MIN_VALUE;
		int n = heights.length;

		for (int i = 0; i < n; i++) {
			max = Math.max(max, heights[i] * (nsr[i] - nsl[i] - 1));
		}

		return max;
	}

	int[] nseInLeft(int[] arr) {

		int[] nsl = new int[arr.length];

		Stack<Integer> stack = new Stack();

		for (int i = 0; i < nsl.length; i++) {

			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
				stack.pop();
			nsl[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}
		return nsl;
	}

	int[] nseInRight(int[] arr) {

		int[] nsl = new int[arr.length];

		Stack<Integer> stack = new Stack();

		for (int i = nsl.length - 1; i >= 0; i--) {

			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
				stack.pop();
			nsl[i] = stack.isEmpty() ? nsl.length : stack.peek();
			stack.push(i);
		}
		return nsl;
	}

}
