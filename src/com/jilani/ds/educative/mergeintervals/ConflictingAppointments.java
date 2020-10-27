package com.jilani.ds.educative.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConflictingAppointments {

	public static void main(String[] args) {

		List<Interval> intervals = new ArrayList();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(2, 5));
		intervals.add(new Interval(7, 9));
		System.out.println(" Original intervals");
		System.out.println(intervals);
		System.out.println();
		System.out.println(" Meetings conflicting?: " + areOverlapping(intervals));

		
		List<Interval> intervals2 = new ArrayList();
		intervals2.add(new Interval(6, 7));
		intervals2.add(new Interval(2, 4));
		intervals2.add(new Interval(8, 12));
		System.out.println(" Original intervals");
		System.out.println(intervals2);
		System.out.println();
		System.out.println(" Meetings conflicting?: " + areOverlapping(intervals2));

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
 * Given an array of intervals representing ‘N’ appointments, find out if a
 * person can attend all the appointments.
 * 
 * Example 1:
 * 
 * Appointments: [[1,4], [2,5], [7,9]] Output: false Explanation: Since [1,4]
 * and [2,5] overlap, a person cannot attend both of these appointments. Example
 * 2:
 * 
 * Appointments: [[6,7], [2,4], [8,12]] Output: true Explanation: None of the
 * appointments overlap, therefore a person can attend all of them. Example 3:
 * 
 * Appointments: [[4,5], [2,3], [3,6]] Output: false Explanation: Since [4,5]
 * and [3,6] overlap, a person cannot attend both of these appointments.
 */
