package com.jilani.ds.educative.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {

		List<Interval> intervals = new ArrayList();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(5, 7));
		intervals.add(new Interval(8, 12));
		System.out.println(" Original intervals");
		System.out.println(intervals);
		System.out.println();
		System.out.println(" Merged intervals");
		System.out.println(insertIntervalOptimized(intervals, new Interval(4, 6)));

		System.out.println("---------------------");
		List<Interval> intervals2 = new ArrayList();
		intervals2.add(new Interval(1, 3));
		intervals2.add(new Interval(5, 7));
		intervals2.add(new Interval(8, 12));
		System.out.println(" Original intervals");
		System.out.println(intervals2);
		System.out.println();
		System.out.println(" Merged intervals");
		System.out.println(insertIntervalOptimized(intervals, new Interval(4, 10)));

		System.out.println("---------------------");
		List<Interval> intervals3 = new ArrayList();
		intervals3.add(new Interval(2, 3));
		intervals3.add(new Interval(5, 7));
		System.out.println(" Original intervals");
		System.out.println(intervals3);
		System.out.println();
		System.out.println(" Merged intervals");
		System.out.println(insertIntervalOptimized(intervals3, new Interval(1, 4)));

	}

	// insert interval optimized. If the given intervals are already sorted, then we
	// can optimize
	static List<Interval> insertIntervalOptimized(List<Interval> intervals, Interval newInterval) {

		if (intervals == null)
			return Arrays.asList(newInterval);
		System.out.println(" New interval added = " + newInterval);
		int i = 0;
		Interval interval;
		List<Interval> result = new ArrayList();

		// Add all the non overlapping intervals before the new Interval
		while (i < intervals.size() && intervals.get(i).end <= newInterval.start) {
			result.add(new Interval(intervals.get(i).start, intervals.get(i).end));
			i++;
		}

		// Process the overlapping intervals
		int m_start =newInterval.start;
		int m_end = newInterval.end;
		
		while ( i < intervals.size() && intervals.get(i).start <= newInterval.end  ) {
			m_start = Math.min(m_start, intervals.get(i).start);
			m_end = Math.max(m_end, intervals.get(i).end);
			i++;
		}
	
		// Add the merged inteval
		result.add(new Interval(m_start, m_end));
		
		// Add the remaining non-overlapping intervals
		while (i < intervals.size()) {
			result.add(new Interval(intervals.get(i).start, intervals.get(i).end));
			i++;
		}

		return result;

	}

	static List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {

		if (intervals == null)
			return Arrays.asList(newInterval);

		intervals.add(newInterval);
		System.out.println(" New interval added = " + newInterval);
		return merge(intervals);
	}

	static List<Interval> merge(List<Interval> intervals) {

		if (intervals.size() < 2)
			return intervals;

		List<Interval> mergedList = new ArrayList();
		Collections.sort(intervals, (a, b) -> a.start - b.start);
		Interval last = intervals.get(0);
		mergedList.add(new Interval(last.start, last.end));

		for (int i = 1; i < intervals.size(); i++) {
			last = mergedList.get(mergedList.size() - 1);
			Interval current = intervals.get(i);
			// If there is NO overlap, add it to the list
			if (last.end <= current.start) {
				mergedList.add(new Interval(current.start, current.end));
			} else {
				last.end = Math.max(last.end, current.end);
			}
		}

		return mergedList;
	}

	static class Interval {

		int start;
		int end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public String toString() {
			return "[" + start + "," + end + "]";
		}
	}
}

/*
 * 
 * 
 * Given a list of intervals, merge all the overlapping intervals to produce a
 * list that has only mutually exclusive intervals.
 * 
 * Example 1:
 * 
 * Intervals: [[1,4], [2,5], [7,9]] Output: [[1,5], [7,9]] Explanation: Since
 * the first two intervals [1,4] and [2,5] overlap, we merged them into one
 * [1,5].
 * 
 * 
 */
