package com.jilani.ds.educative.mergeintervals;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MaxCPULoad {

	public static void main(String[] args) {

		Job[] intervals = new Job[] { new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6) };

		System.out.println(" Max CPU Load = " + maxCPULoad(intervals));
		
		System.out.println(" Min rooms needed = " + findMaxCPULoad(Arrays.asList(intervals)));

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

	public static int findMaxCPULoad(List<Job> jobs) {

		if (jobs == null || jobs.size() == 0)
			return -1;

		int currLoad = jobs.get(0).cpuload;
		int end = jobs.get(0).end;
		int maxLoad = currLoad;
		Job currJob = null;

		for (int i = 1; i < jobs.size(); i++) {
			currJob = jobs.get(i);
			// Overlapping
			if (end > currJob.start) {
				currLoad += currJob.cpuload;
				end = Math.max(end, currJob.end);
			} else {
				currLoad = currJob.cpuload;
				end = currJob.end;
			}
			maxLoad = Math.max(maxLoad, currLoad);
		}
		return maxLoad;
	}

	static class Job {

		int start;
		int end;
		int cpuload;

		Job(int s, int e, int load) {
			start = s;
			end = e;
			cpuload = load;
		}
	}

}
