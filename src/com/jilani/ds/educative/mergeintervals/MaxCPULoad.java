package com.jilani.ds.educative.mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxCPULoad {

	public static void main(String[] args) {

		Job[] intervals = new Job[]{ new Job(1,4,3), new Job(2,5,4), new Job(7,9,6) };

		System.out.println(" Max CPU Load = " + maxCPULoad(intervals));
		//System.out.println(" Min rooms needed = " + minRoomsV2(intervals));


	}

	static int maxCPULoad(Job[] intervals) {

		// Sort intervals based on start times
		Arrays.sort(intervals, (a, b) -> a.start - b.start);

		// Create a min heap to track 'end' times
		PriorityQueue<Job> minHeap = new PriorityQueue<>((a, b) -> (b.end - a.end));

		// Add the first interval (end time) to the heap
		minHeap.add(intervals[0]);
		int currentLoad = intervals[0].cpuload;
		int maxLoad = currentLoad;
		
		for (int i = 1; i < intervals.length; i++) {
			// If they don't overlap, remove jobs from heap. reduce current load.
			while (!minHeap.isEmpty() && minHeap.peek().end <= intervals[i].start) {
				Job tmp = minHeap.poll();
				currentLoad -= tmp.cpuload;
			}
			minHeap.add(intervals[i]);
			currentLoad += intervals[i].cpuload;
			maxLoad = Math.max(maxLoad, currentLoad);
		}

		return maxLoad;
	}

	static int minRoomsV2(int[][] intervals) {

		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];

		for (int i = 0; i < intervals.length; i++) {
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}

		Arrays.sort(start);
		Arrays.sort(end);

		int needed = 0;

		int i = 0;
		int j = 0;

		while (i < start.length) {
			// Overlap
			if (start[i] < end[j]) {
				needed++;
			} else {
				j++;
			}
			i++;
		}
		return needed;
	}
	
	static class Job{
		
		int start;
		int end;
		int cpuload;
		
		Job(int s, int e, int load){
			start =s;
			end = e;
			cpuload = load;
		}
	}

}
