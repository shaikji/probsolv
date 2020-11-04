package com.jilani.ds.educative.twopointer;

import com.jilani.ds.utils.Utils;

public class DutchNationalFlag {

	public static void main(String[] args) {

		int[] arr = { 1, 0, 2, 1, 0 };
		Utils.printArray(arr);
		sort(arr);
		Utils.printArray(arr);
		System.out.println();

		int[] arr2 = { 2, 2, 0, 1, 2, 0 };
		Utils.printArray(arr2);
		sort(arr2);
		Utils.printArray(arr2);
		System.out.println();
	}

	static void sort(int[] arr) {

		if (arr == null || arr.length == 0)
			return;

		int i = 0;
		int j = arr.length - 1;

		int k = i;
		while (k <= j) {
			if (arr[k] == 0) {
				int temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
				i++;
				k++;
			} else if (arr[k] == 2) {
				int temp = arr[j];
				arr[j] = arr[k];
				arr[k] = temp;
				j--;
			} else {
				k++;
			}
		}

	}
}
