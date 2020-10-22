package com.jilani.ds.avp.heaps;

import java.util.PriorityQueue;

public class ConnectRopes {

	public static void main(String[] args) {

		int[] ropes = { 1, 2, 3, 4, 5 };
		ConnectRopes app = new ConnectRopes();
		System.out.println(" Min cost = " + app.connectRopes(ropes));
	}

	int connectRopes(int[] ropes) {

		if (ropes == null || ropes.length == 0)
			return -1;

		PriorityQueue<Integer> minheap = new PriorityQueue();
		
		for (int rope: ropes)
			minheap.add(rope);
		
		while ( minheap.size() >= 2 ) {
			minheap.add(minheap.poll() + minheap.poll());
		}
		return minheap.poll();
	}
}
