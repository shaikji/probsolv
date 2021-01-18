package com.leetcode.microsoft;

class CheckForPalindromeString {
	public static void main(String[] args) {
		CheckForPalindromeString app = new CheckForPalindromeString();
		System.out.println(app.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(app.isPalindrome("race a car"));

	}

	public boolean isPalindrome(String s) {
		for (int i = 0, j = s.length() - 1; i < j;) {
			if (!Character.isLetterOrDigit(s.charAt(i))) {
				i++;
				continue;
			}
			if (!Character.isLetterOrDigit(s.charAt(j))) {
				j--;
				continue;
			}
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
				return false;
			i++;
			j--;
		}
		return true;
	}
}