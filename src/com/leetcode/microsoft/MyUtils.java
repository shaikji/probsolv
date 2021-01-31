package com.leetcode.microsoft;

public class MyUtils {
	
	public static void printMatrix(int[][] matrix) {
		System.out.println();
		for ( int i=0; i < matrix.length; i++) {
			for ( int j=0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] +" ");
			}
			System.out.println();
		}
	}

}
