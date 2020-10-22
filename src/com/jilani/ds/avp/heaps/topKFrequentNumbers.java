package com.jilani.ds.avp.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.jilani.ds.utils.Utils;

public class topKFrequentNumbers {

	public static void main(String[] args) {

		topKFrequentNumbers app = new topKFrequentNumbers();

		int[] arr = { 1, 1, 1, 3, 2, 2, 4 };
		int k = 2;
		Utils.printArray(arr);
		List<Integer> topkfrequent = app.topKFrequentNumbers(arr, k);
		System.out.println(topkfrequent);

	}

	List<Integer> topKFrequentNumbers(int[] arr, int k) {

		List<Integer> res = new ArrayList();

		if (k <= 0)
			return res;
		
		Map<Integer, Integer> freqMap = new HashMap();
		
		for ( int i: arr) {
			freqMap.put(i, freqMap.getOrDefault(i, 0) + 1); 
		}

		PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(new Comparator<Pair>() {

			public int compare(Pair o1, Pair o2) {
				return o1.freq - o2.freq;
			}
		});

		for (int elem: freqMap.keySet()) {
			minHeap.add(new Pair(freqMap.get(elem), elem));
			if (minHeap.size() > k)
				minHeap.poll();
		}

		while (minHeap.size() > 0) {
			res.add(minHeap.poll().val);
		}
		// if you want to print from largest freq to smallest freq reverse it
		// If you just want to return results starting from smaller to larger frequencies
		// then there is no need to reverse.
		Collections.reverse(res);
		return res;
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
