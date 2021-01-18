package com.leetcode.linkedlists;

public interface List {
	
	boolean insertBegin(int data);
	boolean insert(int data);
	boolean insertAtPosition(int pos, int data);
	boolean insertAfter(int val, int data);
	boolean insertBefore(int val, int data);
}
