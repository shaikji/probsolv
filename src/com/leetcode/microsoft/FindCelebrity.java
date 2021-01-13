package com.leetcode.microsoft;
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class FindCelebrity extends Relation {

	public static void main(String[] args) {
		FindCelebrity app = new FindCelebrity();
		System.out.println(app.findCelebrity(4));
	}

	public int findCelebrity(int n) {

		int i = 0;
		int j = n - 1;

		while (i < j) {
			if (knows(i, j))
				i++;
			else
				j--;
		}

		for (int k = 0; k < n; k++) {
			if (k != i && (knows(i, k) || !knows(k, i)))
				return -1;
		}
		return i;
	}
}

/*
 * public int findCelebrity(int n) {
 * 
 * Stack<Integer> stack = new Stack();
 * 
 * for ( int i=0; i < n; i++){ stack.push(i); }
 * 
 * while ( stack.size() > 1 ){ int a = stack.pop(); int b = stack.pop();
 * 
 * if ( knows(a,b)){ stack.push(b); } else{ stack.push(a); } }
 * 
 * // This guy may be celebrity int c = stack.pop();
 * 
 * for ( int i=0; i < n; i++){ if ( c != i && ( knows(c,i) || !knows(i,c)))
 * return -1; } return c; }
 */
