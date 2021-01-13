package com.leetcode.microsoft;

import java.util.HashMap;

public class ExcelNumberToColumnTitle {

	public static void main(String[] args) {
		System.out.println(numberToColumnTitle(27));
		System.out.println(numberToColumnTitle(1355));
		System.out.println(numberToColumnTitle(3));
		System.out.println(numberToColumnTitle(26));
		System.out.println(numberToColumnTitle(18278));
	}

	static String numberToColumnTitle2(int num) {
		StringBuffer result = new StringBuffer();
		int rem = 0;
		while ( num > 0 ) {
			rem = num % 26;
			if ( rem == 0) {
				result.append("Z");
				num = (num/26)-1;
			} else {
				result.append((char)('A' + rem-1));
				num = num/26;
			}
		}
		
		return result.reverse().toString();
	}
	
	static String numberToColumnTitle(int num) {
		StringBuffer result = new StringBuffer();
		char c;
		while ( num > 0 ) {
			c = (char)('A' + (num-1) % 26);
			result.append(c);
			num = (num-1)/26;	
		}
		
		return result.reverse().toString();
	}
}
