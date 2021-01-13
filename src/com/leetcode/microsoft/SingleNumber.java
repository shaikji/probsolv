package com.leetcode.microsoft;

class SingleNumber {

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 1, 1, 2, 3, 3, 2, 7 }));
	}

	public static int singleNumber(int[] nums) {
		int res = 0;
		for (int n : nums) {
			res = res ^ n;
		}
		return res;
	}
}