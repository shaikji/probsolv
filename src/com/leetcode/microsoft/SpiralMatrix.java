package com.leetcode.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SpiralMatrix {

	public static void main(String[] args) {

		// int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		// int[][] matrix = { { 1, 2, 3}, { 5, 6, 7}, { 9, 10, 11} };

		solve(new int[][] { { 1 } });
		solve(new int[][] { { 1, 2 } });
		solve(new int[][] { { 1, 2, 3 } });
		solve(new int[][] { { 1 } });
		solve(new int[][] { { 1 }, { 2 } });
		solve(new int[][] { { 1 }, { 2 }, { 3 } });
		solve(new int[][] { { 1, 2 }, { 3, 4 } });
		solve(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		solve(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } });

	}

	static void solve(int[][] matrix) {
		SpiralMatrix app = new SpiralMatrix();
		List<Integer> list = app.spiralOrder(matrix);
		app.printMatrix(matrix);
		System.out.println();
		System.out.println(" Spiral Matrix");
		System.out.println(list);
		System.out.println("");
		System.out.println("--------");
		System.out.println();
	}

	static void printMatrix(int[][] matrix) {
		for (int[] row : matrix)
			System.out.println(Arrays.toString(row));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> spiral = new ArrayList();
		if (matrix == null)
			return spiral;

		int row_start = 0;
		int row_end = matrix.length - 1;
		int col_start = 0;
		int col_end = matrix[0].length - 1;
		int dir = 0;

		while (row_start <= row_end && col_start <= col_end) {

			if (dir == 0) {
				for (int c = col_start; c <= col_end; c++)
					spiral.add(matrix[row_start][c]);
				row_start++;
				dir = 1;
			} else if (dir == 1) {
				for (int r = row_start; r <= row_end; r++)
					spiral.add(matrix[r][col_end]);
				col_end--;
				dir = 2;
			} else if (dir == 2) {
				for (int c = col_end; c >= col_start; c--)
					spiral.add(matrix[row_end][c]);
				row_end--;
				dir = 3;
			} else {
				for (int r = row_end; r >= row_start; r--)
					spiral.add(matrix[r][col_start]);
				col_start++;
				dir = 0;
			}

		}
		return spiral;
	}

	/*
	 * public List<Integer> spiralOrder(int[][] matrix) { List<Integer> spiral = new
	 * ArrayList(); int m = matrix.length; int n = matrix[0].length; int row_start =
	 * 0; int row_end = m - 1; int col_start = 0; int col_end = n - 1;
	 * 
	 * while (col_start <= col_end && row_start <= row_end) {
	 * 
	 * for (int c = col_start; c <= col_end; c++) {
	 * spiral.add(matrix[row_start][c]); } row_start++;
	 * 
	 * for (int r = row_start; r <= row_end; r++) { spiral.add(matrix[r][col_end]);
	 * } col_end--;
	 * 
	 * if (row_start <= row_end) { for (int c = col_end; c >= col_start; c--) {
	 * spiral.add(matrix[row_end][c]); } row_end--; }
	 * 
	 * if (col_start <= col_end) { for (int r = row_end; r >= row_start; r--) {
	 * spiral.add(matrix[r][col_start]); } col_start++; } } return spiral; }
	 */
}