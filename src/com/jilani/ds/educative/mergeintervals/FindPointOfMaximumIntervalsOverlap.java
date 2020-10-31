package com.jilani.ds.educative.mergeintervals;

import java.util.Arrays;

public class FindPointOfMaximumIntervalsOverlap {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 10, 5, 5 };
		int dept[] = { 4, 5, 12, 9, 12 };
		int n = arr.length;
		int max = findPointOfMaxOverlap(arr, dept, n);
		System.out.println(" Point of max overlap = " + max);
	}

	static int findPointOfMaxOverlap(int[] arr, int[] dept, int N) {

		if (N < 1)
			return N;

		Arrays.sort(arr);
		Arrays.sort(dept);

		int i = 0;
		int j = 0;
		int cnt = 0;
		int time = arr[0];
		int max = Integer.MIN_VALUE;

		while (i < N && j < N) {
			if (arr[i] <= dept[j]) {
				cnt++;
				if (max < cnt) {
					time = arr[i];
					max = cnt;
				}
				i++;
			} else {
				cnt--;
				j++;
			}
		}

		System.out.println(" Max Guest at any point of time = " + max + " Time = " + time);
		return time;
	}

}
