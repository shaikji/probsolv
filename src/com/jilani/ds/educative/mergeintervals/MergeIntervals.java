package com.jilani.ds.educative.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {

		List<Interval> intervals = new ArrayList();
		intervals.add(new Interval(1,4));
		intervals.add(new Interval(2,5));
		intervals.add(new Interval(7,9));
		System.out.println(" Original intervals");
		System.out.println(intervals);
		System.out.println();
		System.out.println(" Merged intervals");
		System.out.println(merge(intervals));
		
		System.out.println("---------------------");
		List<Interval> intervals2 = new ArrayList();
		intervals2.add(new Interval(6,7));
		intervals2.add(new Interval(2,4));
		intervals2.add(new Interval(5,9));
		System.out.println(" Original intervals");
		System.out.println(intervals2);
		System.out.println();
		System.out.println(" Merged intervals");
		System.out.println(merge(intervals2));
		
		System.out.println("---------------------");
		List<Interval> intervals3 = new ArrayList();
		intervals3.add(new Interval(1,4));
		intervals3.add(new Interval(2,6));
		intervals3.add(new Interval(3,5));
		System.out.println(" Original intervals");
		System.out.println(intervals3);
		System.out.println();
		System.out.println(" Merged intervals");
		System.out.println(merge(intervals3));
		
	}
	
	static List<Interval> merge(List<Interval> intervals){
		
		if ( intervals.size() < 2 )
			return intervals;
		
		List<Interval> mergedList = new ArrayList();
		Collections.sort(intervals, (a,b) -> a.start - b.start );
		
		Interval last = intervals.get(0);
		int start = last.start;
		int end = last.end;
		
		mergedList.add(new Interval(start, end));

		for ( int i=1; i < intervals.size(); i++) {
			Interval current = intervals.get(i);
			// If there is NO overlap, add it to the list
			if ( end <= current.start) {
				start = current.start;
				end = current.end;
				mergedList.add(new Interval(start, end));
			} else {
				// found overlap
				end = Math.max(end, current.end);
			}			
		}
		
		return mergedList;
	}

	
	static class Interval{
		
		int start;
		int end;
		
		Interval(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		public String toString() {
			return "["+ start +"," + end + "]";
		}
	}
}
