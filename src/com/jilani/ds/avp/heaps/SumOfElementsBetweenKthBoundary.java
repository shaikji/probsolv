package com.jilani.ds.avp.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.jilani.ds.utils.Utils;

public class SumOfElementsBetweenKthBoundary {

	public static void main(String[] args) {

		int[] arr = { 7, 10, 4, 3, 20, 15 };
		int k1 = 3;
		int k2 = 6;

		Utils.printArray(arr);
		System.out.println();
		SumOfElementsBetweenKthBoundary app = new SumOfElementsBetweenKthBoundary();

		System.out.println(" sum of elements between 3rd and 6th largest = " + app.sumBetweenBoundaries(arr, k1, k2));

	}

	int sumBetweenBoundaries(int[] arr, int k1, int k2) {

		int k1thSmallest = kthSmallest(arr, k1);
		int k2thSmallest = kthSmallest(arr, k2);
		
		int sum = 0;

		for (int elem : arr) {
			if (elem > k1thSmallest && elem < k2thSmallest)
				sum += elem;
		}
		return sum;
	}

	// Elements are distinct.
	int kthSmallest(int[] arr, int k) {
		int res = -1;
		if (k <= 0 || k > arr.length)
			return res;

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
		});

		for (int i = 0; i < arr.length; i++) {
			maxHeap.add(arr[i]);
			if (maxHeap.size() > k)
				maxHeap.poll();
		}

		return maxHeap.peek();
	}

}
