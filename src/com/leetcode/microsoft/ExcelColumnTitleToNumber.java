package com.leetcode.microsoft;

import java.util.HashMap;

public class ExcelColumnTitleToNumber {

	public static void main(String[] args) {
		System.out.println(columnTitleToNumber("YZ"));
		System.out.println(columnTitleToNumber("AA"));
		System.out.println(columnTitleToNumber("AZC"));
		System.out.println(columnTitleToNumber("C"));
		System.out.println(columnTitleToNumber("Z"));
		System.out.println(columnTitleToNumber("ZZZ"));
	}

	static int columnTitleToNumber(String title) {
		HashMap<Character, Integer> map = new HashMap();
		for (int i = 0; i < 26; i++) {
			map.put((char) ('A' + i), i + 1);
		}
		int result = 0;
		for (int i = 0; i < title.length(); i++) {
			result = result * 26 + map.get(title.charAt(i));
		}
		return result;
	}
}
