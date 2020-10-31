package com.jilani.ds.educative.mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms {

	public static void main(String[] args) {

		int[][] intervals = { { 1, 10 }, { 2, 7 }, { 3, 19 }, { 8, 12 }, { 10, 20 }, { 11, 30 } };

		System.out.println(" Min rooms needed = " + minRooms(intervals));
		System.out.println(" Min rooms needed = " + minRoomsV2(intervals));


	}

	static int minRooms(int[][] intervals) {

		// Sort intervals based on start times
		Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

		// Create a min heap to track 'end' times
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (b - a));

		// Add the first interval (end time) to the heap
		minHeap.add(intervals[0][1]);

		for (int i = 1; i < intervals.length; i++) {

			// overlap
			if (minHeap.peek() > intervals[i][1])
				minHeap.poll();

			minHeap.add(intervals[i][1]);
		}

		return minHeap.size();
	}
	
	static int minRoomsV2(int[][] intervals) {
		
		int[] arrivals = new int[intervals.length];
		int[] departures = new int[intervals.length];
		
		for ( int i=0; i < intervals.length; i++) {
			arrivals[i] = intervals[i][0];
			departures[i] = intervals[i][1];
		}
		
		Arrays.sort(arrivals);
		Arrays.sort(departures);
		
		int cnt = 0;
		int minRooms = 0;
		int i =0;
		int j = 0;
		
		while ( i < arrivals.length && j < departures.length)  {
			// Overlap
			if ( arrivals[i] <= departures[j]) {
				i++;
				cnt++;
			} else {
				cnt--;
				j++;
			}
			minRooms = Math.max(minRooms, cnt);
		}
		return minRooms;
	}

}
