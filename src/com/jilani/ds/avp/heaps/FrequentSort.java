package com.jilani.ds.avp.heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.jilani.ds.utils.Utils;

public class FrequentSort {

	public static void main(String[] args) {

		FrequentSort app = new FrequentSort();

		int[] arr = { 1, 1, 1, 3, 2, 2, 4 };
		int k = 2;
		Utils.printArray(arr);
		app.topKFrequentNumbers(arr, k);
		Utils.printArray(arr);

	}

	void topKFrequentNumbers(int[] arr, int k) {

		if (k <= 0)
			return;
		
		Map<Integer, Integer> freqMap = new HashMap();
		for ( int i: arr)
			freqMap.put(i, freqMap.getOrDefault(i, 0) + 1); 

		PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(new Comparator<Pair>() {
			public int compare(Pair o1, Pair o2) {
				return o2.freq - o1.freq;
			}
		});

		int index = 0;
		for (int elem: freqMap.keySet())
			maxHeap.add(new Pair(freqMap.get(elem), elem));
		
		while ( maxHeap.size() > 0 ) {
			Pair p = maxHeap.poll();
			for ( int i=0; i< p.freq; i++) {
				arr[index++] = p.val;
			}
		}
	}

	static class Pair {
		int freq;
		int val;

		Pair(int dist, int val) {
			this.freq = dist;
			this.val = val;
		}
	}

}
