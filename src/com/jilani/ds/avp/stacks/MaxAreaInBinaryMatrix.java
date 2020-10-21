package com.jilani.ds.avp.stacks;

import java.util.Stack;

import com.jilani.ds.utils.Utils;

public class MaxAreaInBinaryMatrix {

	public static void main(String[] args) {

		int[][] matrix = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };

		MaxAreaInBinaryMatrix app = new MaxAreaInBinaryMatrix();
		int max = app.maxArea(matrix);
		System.out.println(" Max Area = " + max);
	}

	int maxArea(int[][] matrix) {

		if (matrix == null || matrix.length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;

		int[] row = new int[n];

		for (int i = 0; i < matrix[0].length; i++)
			row[i] = matrix[0][i];
		
		Utils.printArray(row);

		int mah = findMaxAreaHistogram(row);

		for (int i = 1; i < m; i++) {

			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row[j] = 0;
				} else {
					row[j] = row[j] + 1;
				}
			}
			
			Utils.printArray(row);


			// row is ready; now find mah
			mah = Math.max(mah, findMaxAreaHistogram(row));

		}
		return mah;

	}

	// Max Area Histogram

	int findMaxAreaHistogram(int[] heights) {

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
