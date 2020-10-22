package com.jilani.ds.avp.heaps;

import java.util.PriorityQueue;

import com.jilani.ds.utils.Utils;

public class SortAKSortedArray {

	public static void main(String[] args) {

		SortAKSortedArray app = new SortAKSortedArray();

		int[] arr = { 6, 5, 3, 2, 8, 10, 9 };
		int k = 3;
		Utils.printArray(arr);
		System.out.println();
		app.sort(arr, k);
		Utils.printArray(arr);

	}

	// Elements are distinct.
	void sort(int[] arr, int k) {
		if (k <= 0)
			return;

		PriorityQueue<Integer> minHeap = new PriorityQueue();

		int i = 0;
		for (i = 0; i < arr.length; i++) {
			minHeap.add(arr[i]);
			if (minHeap.size() > k)
				arr[i - k] = minHeap.poll();
		}
		i = i-k;
		while (minHeap.size() > 0) {
			arr[i++] = minHeap.poll();
		}

	}
}
