package com.jilani.ds.educative.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckForOverlappingIntervals {

	public static void main(String[] args) {

		List<Interval> intervals = new ArrayList();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(2, 5));
		intervals.add(new Interval(7, 9));
		System.out.println(" Original intervals");
		System.out.println(intervals);
		System.out.println();

		System.out.println(" Intervals Overlapping? : " + areOverlapping(intervals));

	}

	static boolean areOverlapping(List<Interval> intervals) {

		Collections.sort(intervals, (a, b) -> a.start - b.start);

		int end = intervals.get(0).end;

		for (int i = 1; i < intervals.size(); i++) {

			Interval current = intervals.get(i);
			// No overlap
			if (end > current.start)
				return true;
			end = Math.max(end, current.end);
		}

		return false;
	}

	static class Interval {

		int start;
		int end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public String toString() {
			return "[ " + start + "," + end + "]";
		}
	}

}

/*
 * Given a set of intervals, find out if any two intervals overlap.
 * 
 * Example:
 * 
 * Intervals: [[1,4], [2,5], [7,9]] Output: true Explanation: Intervals [1,4]
 * and [2,5] overlap
 */
