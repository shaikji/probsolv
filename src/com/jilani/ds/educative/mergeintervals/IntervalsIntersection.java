package com.jilani.ds.educative.mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalsIntersection {

	public static void main(String[] args) {

		Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
		Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
		
		Interval[] common = findIntersection(input1, input2);
		
		printIntervals(input1);
		printIntervals(input2);
		printIntervals(common);


	}
	
	static Interval[] findIntersection( Interval[] list1, Interval[] list2) {
		
		int i =0; 
		int j = 0;
		
		List<Interval> result = new ArrayList();
		
		while ( i < list1.length && j < list2.length) {
			
			
			if ( doesOverlap(list1[i], list2[j])) {
				int a = Math.max(list1[i].start, list2[j].start);
				int b = Math.min(list1[i].end, list2[j].end);
				result.add(new Interval(a,b));
			} 
			
			if ( list1[i].end <= list2[j].end)
				i++;
			else
				j++;
		}
		
		return result.toArray(new Interval[result.size()]);
	}
	
	static boolean doesOverlap(Interval i1, Interval i2) {
		
		if ( i1.start > i2.start) {
			Interval tmp = i1;
			i1 = i2;
			i2 = tmp;
		}
		
		if ( i1.end < i2.start)
			return false;
		return true;
	}
	
	static void printIntervals(Interval[] intervals) {
		
		for ( Interval i: intervals)
			System.out.print(i+ " ");
		System.out.println();
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
