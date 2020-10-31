package com.jilani.ds.educative.mergeintervals;

import java.util.Arrays;

public class MinPlatformsForTrains {

	public static void main(String[] args) {

		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		int n = arr.length;

		int minPlatforms = findMinPlatforms(arr, dep, n);
		System.out.println(" minimum number of platforms needed =  " + minPlatforms);
	}

	static int findMinPlatforms(int[] arr, int[] dept, int N) {

		if (N < 2)
			return N;

		Arrays.sort(arr);
		Arrays.sort(dept);

		int minPlatforms = 0;
		int cnt = 0;

		int i = 0;
		int j = 0;

		while (i < N && j < N) {

			if (arr[i] <= dept[j]) {
				cnt++;
				i++;
			} else {
				cnt--;
				j++;
			}
			minPlatforms = Math.max(minPlatforms, cnt);
		}

		return minPlatforms;

	}

}
