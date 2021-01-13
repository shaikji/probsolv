package com.leetcode.microsoft;

public class Relation {

	// Person with 2 is celebrity
	static int graph[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

	// Returns true if a knows
	// b, false otherwise
	static boolean knows(int a, int b) {
		boolean res = (graph[a][b] == 1) ? true : false;
		return res;
	}

}
