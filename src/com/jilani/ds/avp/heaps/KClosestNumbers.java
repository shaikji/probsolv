package com.jilani.ds.avp.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.jilani.ds.utils.Utils;

public class KClosestNumbers {

	public static void main(String[] args) {

		KClosestNumbers app = new KClosestNumbers();

		int[] arr = { 5, 6, 7, 8, 9 };
		int k = 3;
		int x = 7;
		Utils.printArray(arr);
		List<Integer> closest = app.kClosestNumbers(arr, k, x);
		System.out.println(closest);

	}

	List<Integer> kClosestNumbers(int[] arr, int k, int x) {

		List<Integer> res = new ArrayList();

		if (k <= 0)
			return res;

		PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(new Comparator<Pair>() {

			public int compare(Pair o1, Pair o2) {
				return o2.dist - o1.dist;
			}
		});

		for (int i = 0; i < arr.length; i++) {
			maxHeap.add(new Pair(Math.abs(arr[i] - x), arr[i]));
			if (maxHeap.size() > k)
				maxHeap.poll();
		}

		while (maxHeap.size() > 0) {
			res.add(maxHeap.poll().val);
		}
		return res;
	}

	static class Pair {
		int dist;
		int val;

		Pair(int dist, int val) {
			this.dist = dist;
			this.val = val;
		}
	}

}
