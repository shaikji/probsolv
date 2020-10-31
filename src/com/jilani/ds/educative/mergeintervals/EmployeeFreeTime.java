package com.jilani.ds.educative.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {

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

	public static void main(String[] args) {

		testCase1();
		System.out.println();
		testCase2();
		System.out.println();

		testCase3();
		System.out.println();
		testCase4();
		System.out.println();

		testCase5();
		System.out.println();
		testCase6();
		System.out.println();
	}

	static void testCase1() {

		List<List<Interval>> input = new ArrayList();
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));

		for (List list : input) {
			System.out.println(list);
		}

		System.out.println(" free time");
		System.out.println(findEmployeeFreeTime(input));
	}

	static void testCase2() {

		List<List<Interval>> input = new ArrayList();
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));

		for (List list : input) {
			System.out.println(list);
		}

		System.out.println(" free time");
		System.out.println(findEmployeeFreeTime2(input));
	}

	static void testCase3() {

		List<List<Interval>> input = new ArrayList();
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4), new Interval(6, 8))));

		for (List list : input) {
			System.out.println(list);
		}

		System.out.println(" free time");
		System.out.println(findEmployeeFreeTime(input));
	}

	static void testCase4() {

		List<List<Interval>> input = new ArrayList();
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4), new Interval(6, 8))));

		for (List list : input) {
			System.out.println(list);
		}

		System.out.println(" free time");
		System.out.println(findEmployeeFreeTime2(input));
	}

	static void testCase5() {

		List<List<Interval>> input = new ArrayList();
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(2, 4))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));

		for (List list : input) {
			System.out.println(list);
		}

		System.out.println(" free time");
		System.out.println(findEmployeeFreeTime(input));
	}

	static void testCase6() {

		List<List<Interval>> input = new ArrayList();
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(2, 4))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));

		for (List list : input) {
			System.out.println(list);
		}

		System.out.println(" free time");
		System.out.println(findEmployeeFreeTime2(input));
	}

	// Sorting based. O(NLogN)
	// Space - O(N)
	static List<Interval> findEmployeeFreeTime(List<List<Interval>> input) {

		List<Interval> merged = new ArrayList();

		for (List<Interval> list : input) {
			merged.addAll(list);
		}

		Collections.sort(merged, (a, b) -> a.start - b.start);

		List<Interval> freeTime = new ArrayList();

		int end = merged.get(0).end;
		Interval current = null;

		for (int i = 1; i < merged.size(); i++) {
			current = merged.get(i);
			// If No Overlap, capture the free time.
			if (end < current.start) {
				freeTime.add(new Interval(end, current.start));
				end = current.end;
			} else {
				// Overlap
				end = Math.max(end, current.end);
			}
		}
		return freeTime;
	}

	// Min Heap based, no sorting required
	// Time - O(NLogK)
	// Space - O(K)
	static List<Interval> findEmployeeFreeTime2(List<List<Interval>> input) {

		List<Interval> freeTime = new ArrayList();

		PriorityQueue<EmpInterval> minheap = new PriorityQueue<EmpInterval>(
				(a, b) -> a.interval.start - b.interval.start);

		for (int i = 0; i < input.size(); i++) {
			List<Interval> list = input.get(i);
			minheap.add(new EmpInterval(list.get(0), i, 0));
		}

		Interval prev = null;

		while (!minheap.isEmpty()) {
			EmpInterval current = minheap.poll();

			if (prev == null) {
				int listId = current.listId;
				int elemId = current.elemId;
				// If there is an element in the current list, then add it to min heap.
				if (elemId < input.get(listId).size() - 1) {
					minheap.add(new EmpInterval(input.get(listId).get(elemId + 1), listId, elemId + 1));
				}
				prev = current.interval;
			} else {

				// Prev interval exists: Check for overlap

				// If no overlap, add the freetime
				if (prev.end < current.interval.start) {
					freeTime.add(new Interval(prev.end, current.interval.start));
				} else {
					prev.end = Math.max(prev.end, current.interval.end);
				}
				prev = current.interval;
				// Now add the next one to the list
				int listId = current.listId;
				int elemId = current.elemId;
				// If there is an element in the current list, then add it to min heap.
				if (elemId < input.get(listId).size() - 1) {
					minheap.add(new EmpInterval(input.get(listId).get(elemId + 1), listId, elemId + 1));
				}

			}
		}

		return freeTime;

	}

	static class EmpInterval {
		Interval interval;
		int listId;
		int elemId;

		EmpInterval(Interval i, int listId, int elemId) {
			this.interval = i;
			this.listId = listId;
			this.elemId = elemId;
		}
	}
}