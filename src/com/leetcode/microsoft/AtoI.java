package com.leetcode.microsoft;

class AtoI {

	public static void main(String[] args) {
		AtoI app = new AtoI();
		System.out.println(app.myAtoi("42"));
		System.out.println(app.myAtoi("   -42"));
		System.out.println(app.myAtoi("4193 with words"));
		System.out.println(app.myAtoi("words and 987"));
		System.out.println(app.myAtoi("-91283472332"));

	}

	public int myAtoi(String s) {

		if (s.isEmpty())
			return 0;

		int sign = 1;
		int result = 0;
		int n = s.length();
		int i = 0;

		while (i < n && s.charAt(i) == ' ')
			i++;

		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			sign = s.charAt(i) == '-' ? -1 : 1;
			i++;
		}

		while (i < n && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {

			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (s.charAt(i) - '0') > 7))
				return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

			result = result * 10 + s.charAt(i++) - '0';
		}

		return sign * result;

	}
}