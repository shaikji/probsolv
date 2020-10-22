package com.jilani.ds.avp.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.jilani.ds.utils.Utils;

public class KSmallestNumbers {

	public static void main(String[] args) {

		int[] arr = { 7, 10, 4, 3, 20, 15 };
		int k = 3;

		Utils.printArray(arr);
		System.out.println();
		KSmallestNumbers app = new KSmallestNumbers();

		List<Integer> ksmaller = app.getKSmallerElements(arr, k);
		System.out.println(" k smaller elements = " + ksmaller);
		System.out.println();
		List<Integer> klarger = app.getKLargerElements(arr,k);
		System.out.println(" k larger elements = " + klarger);


	}

	// Elements are distinct.
	List<Integer> getKSmallerElements(int[] arr, int k) {
		List<Integer> res = new ArrayList();
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
		
		while ( maxHeap.size() > 0 )
			res.add(maxHeap.poll());
		
		return res;
	}

	List<Integer> getKLargerElements(int[] arr, int k) {
		List<Integer> res = new ArrayList();
		if (k <= 0 || k > arr.length)
			return res;

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for ( int i=0; i < arr.length; i++) {
			minHeap.add(arr[i]);
			if ( minHeap.size() > k )
				minHeap.poll();
		}
		
		while ( minHeap.size() > 0)
			res.add(minHeap.poll());
		
		return res;
	}

}
