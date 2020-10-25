package com.jilani.ds.avp.binarysearch.bsonanswer;

public class AllocatePagesOfBook {

	public static void main(String[] args) {

		int[] books = { 10, 20, 30, 40 };
		int s = 2;
		System.out.println(" Min # of Pages per student = " + allocatePages(books, s));
	}

	static int allocatePages(int[] books, int s) {

		int max = 0;
		int sum = 0;

		for (int elem : books) {
			max = Math.max(max, elem);
			sum += elem;
		}

		return binsearch(books, max, sum, s);
	}

	static int binsearch(int[] books, int l, int r, int s) {

		int ans = -1;

		while (l <= r) {

			int mid = l + (r - l) / 2;

			int n = partition(books, mid);

			if (n == s) {
				ans = mid;
				r = mid - 1;
			} else if (n > s) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return ans;
	}

	static int partition(int[] arr, int sum) {

		int n = 1;
		int currSum = 0;

		for (int i = 0; i < arr.length; i++) {
			if (currSum + arr[i] > sum) {
				n++;
				currSum = arr[i];
			} else {
				currSum += arr[i];
			}
		}

		return n;
	}

}
