package com.jilani.ds.avp.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.jilani.ds.utils.Utils;

public class KthSmallestNumber {

	public static void main(String[] args) {

		int[] arr = { 7, 10, 4, 3, 20, 15 };
		int k = 3;

		Utils.printArray(arr);
		System.out.println();
		KthSmallestNumber app = new KthSmallestNumber();

		for (int i = 1; i <= arr.length; i++) {
			System.out.println(i + "th smallest = " + app.kthSmallest(arr, i));
		}

		System.out.println();
		for (int i = 1; i <= arr.length; i++) {
			System.out.println(i + "th largest = " + app.kthLargest(arr, i));
		}

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
		
		for ( int i=0; i < arr.length; i++) {
			maxHeap.add(arr[i]);
			if ( maxHeap.size() > k)
				maxHeap.poll();
		}
		
		return maxHeap.peek();
	}

	int kthLargest(int[] arr, int k) {
		int res = -1;
		if (k <= 0 || k > arr.length)
			return res;

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for ( int i=0; i < arr.length; i++) {
			minHeap.add(arr[i]);
			if ( minHeap.size() > k )
				minHeap.poll();
		}
		
		return minHeap.peek();
	}

}
