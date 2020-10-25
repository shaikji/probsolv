package com.jilani.ds.avp.binarysearch.bsonanswer;

import java.util.Arrays;

public class AggressiveCowProblem {

	public static void main(String[] args) {
		
		int[] positions = {1,2,8,4,9};
		int N = positions.length; // # of positions
		int C = 3; // # of cows 

		int maxDistance = getMaxDistance(positions, N, C);
		System.out.println(" Max dist = " + maxDistance);
	}
	
	static int getMaxDistance(int[] positions, int N, int C) {
		
		if ( positions == null || positions.length == 0 || C <= 0)
			return -1;
		
		int best = 0;
		
		// Sort the positions
		
		Arrays.sort(positions);
	
		// Place the cows.
		// Min Gap = 1 ( place cow1 in first position )
		// Max Gap = LastPos - firstPos = arr[arr.length-1] - arr[0]
		
		int l = positions[0]; // minGAp
		int r = positions[N-1]; // maxGap
		// apply binary search
		
		while ( l <= r ) {
			int gap = l + (r-l)/2; // Mid
			
			// Check if you can place the cows in positions without problem
			
			int prev = positions[0]; // Place the cow in first position
			int cnt = 1;
			for ( int i=1; i < N; i++) {
				if (positions[i] - prev >= gap) {
					// place the cow and reset prev
					cnt++;
					prev = positions[i];
				} 
			}
			
			if ( cnt >= C) {
				best = gap;
				l = gap + 1;
			} else {
				r = gap -1;
			}
		}
		return best;
	}

}


/* Problem Statement 


AGGRCOW - Aggressive cows
#binary-search
Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).

His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
Input
t – the number of test cases, then t test cases follows.
* Line 1: Two space-separated integers: N and C
* Lines 2..N+1: Line i+1 contains an integer stall location, xi
Output
For each test case output one integer: the largest minimum distance.
Example
Input:

1
5 3
1
2
8
4
9
Output:

3
Output details:

FJ can put his 3 cows in the stalls at positions 1, 4 and 8,
resulting in a minimum distance of 3.

*/