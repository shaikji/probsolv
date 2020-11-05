package com.jilani.ds.educative.twopointer;

import java.util.Stack;

class BackspaceCompare {

	public static void main(String[] args) {
		System.out.println(compare("xy#z", "xzz#"));
		System.out.println(compare("xy#z", "xyz#"));
		System.out.println(compare("xp#", "xyz##"));
		System.out.println(compare("xywrrmp", "xywrrmu#p"));
		
		System.out.println();
		
		System.out.println(compare2("xy#z", "xzz#"));
		System.out.println(compare2("xy#z", "xyz#"));
		System.out.println(compare2("xp#", "xyz##"));
		System.out.println(compare2("xywrrmp", "xywrrmu#p"));
		
		System.out.println();
		
		System.out.println(compare3("xy#z", "xzz#"));
		System.out.println(compare3("xy#z", "xyz#"));
		System.out.println(compare3("xp#", "xyz##"));
		System.out.println(compare3("xywrrmp", "xywrrmu#p"));

	}

	public static boolean compare(String str1, String str2) {

		if (str1 == null && str2 == null)
			return true;

		Stack<Character> stack1 = new Stack();
		Stack<Character> stack2 = new Stack();

		for (char ch : str1.toCharArray()) {
			if (ch == '#') {
				stack1.pop();
			} else {
				stack1.push(ch);
			}
		}

		for (char ch : str2.toCharArray()) {
			if (ch == '#') {
				stack2.pop();
			} else {
				stack2.push(ch);
			}
		}

		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			if (stack1.pop() != stack2.pop())
				return false;
		}
		if (!stack1.isEmpty() || !stack2.isEmpty())
			return false;

		return true;
	}

	// Two pointer approach

	public static boolean compare2(String str1, String str2) {

		if (str1 == null && str2 == null)
			return true;

		String s1 = getProcessedString(str1);
		String s2 = getProcessedString(str2);

		return s1.equals(s2);
	}

	static String getProcessedString(String str) {

		if (str == null || str.length() == 0)
			return str;

		char[] processed = str.toCharArray();

		int i = 0;
		for (int j = 0; j < str.length(); j++) {
			if (str.charAt(j) == '#') {
				i--;
			} else {
				processed[i] = str.charAt(j);
				i++;
			}
		}

		return new String(processed, 0, i);
	}
	
	public static boolean compare3(String str1, String str2) {

		if (str1 == null && str2 == null)
			return true;

		int index1 = str1.length()-1;
		int index2 = str2.length()-1;
		
		while ( index1 >= 0 && index2 >= 0) {
			
			int i1 = getNextValidIndex(str1, index1);
			int i2 = getNextValidIndex(str2, index2);
			
			// Reached end of both strings- they are equal
			if ( i1 < 0 && i2 < 0)
				return true;
			// One string reached end early - they are not equal
			if ( i1 < 0 || i2 < 0)
				return false;
			// They are not equal
			if (str1.charAt(i1) != str2.charAt(i2))
				return false;
			
			index1 = i1 -1;
			index2 = i2 -1;
		}
		return true;
	}
	
	private static int getNextValidIndex(String s, int i) {
		
		int cnt = 0;
		while ( i >= 0 ) {
			char ch = s.charAt(i);
			if ( ch == '#')
				cnt++;
			else if ( cnt > 0) {
				cnt--;
			} else {
				break;
			}
			i--;
		}
		return i;
	}
}
