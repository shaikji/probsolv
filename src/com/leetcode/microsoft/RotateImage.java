package com.leetcode.microsoft;

class RotateImage {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		MyUtils.printMatrix(matrix);
		RotateImage app = new RotateImage();
		app.rotate(matrix);
		MyUtils.printMatrix(matrix);
	}

	public void rotate(int[][] matrix) {

		if (matrix == null)
			return;
		int n = matrix.length;
		int temp;
		// Step 1:Transpose a matrix
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// Step 2: Reverse each row

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = temp;
			}
		}
	}

}