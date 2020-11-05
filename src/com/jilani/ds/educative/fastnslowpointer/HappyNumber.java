package com.jilani.ds.educative.fastnslowpointer;

import java.util.HashSet;
import java.util.Set;

class HappyNumber {

	public static boolean find(int num) {
		// Fast and slow approach
		int slow = num;
		int fast = num;

		do {
			slow = getNext(num);
			fast = getNext(getNext(num));
		} while (slow != fast);

		return slow == 1;
	}

	public static boolean find2(int num) {
		// // TODO: Write your code here
		Set<Integer> set = new HashSet();
		while (num > 0) {
			if (!set.add(num))
				return false;
			num = getNext(num);
			if (num == 1)
				return true;
		}
		return false;
	}

	static int getNext(int num) {
		int sum = 0;
		int digit = 0;
		while (num > 0) {
			digit = num % 10;
			sum += (digit * digit);
			num = num / 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(HappyNumber.find(23));
		System.out.println(HappyNumber.find(12));
	}
}