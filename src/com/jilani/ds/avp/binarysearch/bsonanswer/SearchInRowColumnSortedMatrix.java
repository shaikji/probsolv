package com.jilani.ds.avp.binarysearch.bsonanswer;

public class SearchInRowColumnSortedMatrix {

	public static void main(String[] args) {

		int[][] matrix = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		
		for ( int i=1; i <= 60; i++) {
			Pair p = findIndex(matrix, i); 
			System.out.println(" Index of " + i +" = " + p.x + ", " + p.y);
		}
	
	}
	
	static Pair findIndex(int[][] matrix, int x) {
		
		if ( matrix == null || matrix.length == 0 )
			return new Pair(-1,-1);
		
		int m = matrix.length;
		int n = matrix[0].length;
		int i=0;
		int j = n-1;
		Pair p = new Pair(-1,-1);
		
		while ( i >= 0 && i < m && j >=0 && j < n ) {
			
			if ( x == matrix[i][j]) {
				p.x = i;
				p.y = j;
				return p;
			} else if ( x < matrix[i][j]) {
				j--; 
			} else {
				i++;
			}
		}
		
		return p;
	}
	
	
	
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
