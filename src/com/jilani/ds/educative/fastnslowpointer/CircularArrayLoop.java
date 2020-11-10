package com.jilani.ds.educative.fastnslowpointer;

class CircularArrayLoop {

	public static boolean loopExists(int[] arr) {
		if (arr == null || arr.length == 0)
			return false;

		// Check for each index, if there exists a loop

		for (int i = 0; i < arr.length; i++) {

			int slow = i;
			int fast = i;
			boolean isForward = arr[i] >= 0;

			do {

				slow = getNextIndex(arr, isForward, slow);
				fast = getNextIndex(arr, isForward, fast);

				if (fast != -1)
					fast = getNextIndex(arr, isForward, fast);

			} while (slow != -1 && fast != -1 && slow != fast);

			if (slow != -1 && slow == fast)
				return true;
		}
		return false;
	}

	private static int getNextIndex(int[] arr, boolean isForward, int currentIndex) {

		boolean direction = arr[currentIndex] >= 0;

		// Check 1 - Direction should be same
		if (direction != isForward)
			return -1;

		int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;

		if (nextIndex < 0)
			nextIndex = nextIndex + arr.length;

		// Check 2 - No single point loop
		if (nextIndex == currentIndex)
			return -1; //

		return nextIndex;
	}

	public static void main(String[] args) {
		System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
		System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
		System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
	}
}