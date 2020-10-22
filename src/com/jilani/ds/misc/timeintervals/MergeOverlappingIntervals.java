package com.jilani.ds.misc.timeintervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Interval arr[] = new Interval[4];
		arr[0] = new Interval(6, 8);
		arr[1] = new Interval(1, 9);
		arr[2] = new Interval(2, 4);
		arr[3] = new Interval(4, 7);
		// mergeIntervals(arr);
		mergeIntervals2(arr);
	}

	static void mergeIntervals2(Interval[] arr) {
		if (arr == null || arr.length < 2)
			return;

		Arrays.sort(arr, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		
		int index = 0;

		for (int i = 1; i < arr.length; i++) {

			if (arr[index].end >= arr[i].start) {
				arr[index].end = Math.max(arr[index].end, arr[i].end);
				arr[index].start = Math.min(arr[index].start, arr[i].start);
			} else {
				index++;
				arr[index] = arr[i];
			}
		}

		System.out.print("The Merged Intervals are: ");
		for (int i = 0; i <= index; i++) {
			System.out.print("[" + arr[i].start + "," + arr[i].end + "]");
		}
	}

	static void mergeIntervals(Interval[] arr) {

		if (arr == null || arr.length < 2)
			return;

		Arrays.sort(arr, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		Stack<Interval> stack = new Stack();
		stack.push(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			Interval curr = arr[i];

			Interval top = stack.peek();

			if (top.end > curr.start) {
				if (top.end < curr.end)
					top.end = curr.end;
			} else {
				stack.push(curr);
			}
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

	static class Interval {
		int start;
		int end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public String toString() {
			return "(" + start + "," + end + ") ";
		}
	}

}
