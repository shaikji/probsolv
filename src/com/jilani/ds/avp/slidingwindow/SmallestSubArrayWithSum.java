package com.jilani.ds.avp.slidingwindow;

public class SmallestSubArrayWithSum {

	public static void main(String[] args) {
		
		int[] arr = {2, 1, 5, 2, 3, 2};
		int S = 7;
		int minlen = subArrayLength(arr, S);
		System.out.println(" Min Len of sub array with given sum " + S +" = " + minlen);
	}
	
	static int subArrayLength(int[] arr, int S) {
		
		if ( arr == null || arr.length == 0 )
			return -1;
		
		int windowStart = 0;
		int sum = 0;
		int minlen = Integer.MAX_VALUE;
		
		for ( int windowEnd=0; windowEnd < arr.length; windowEnd++) {
			sum += arr[windowEnd];
			
			while ( sum >= S) {
				minlen = Math.min(minlen, windowEnd-windowStart +1 );
				sum -= arr[windowStart];
				windowStart++;
			}
		}
		
		return minlen;
		
	}

}
