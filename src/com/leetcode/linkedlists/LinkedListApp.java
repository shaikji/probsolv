package com.leetcode.linkedlists;

public class LinkedListApp {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		for ( int i=1; i <=10; i++)
			list.insert(i);
		list.printList();

		/*
		 * for ( int i=10; i <= 15; i++) list.insertBegin(i); list.printList();
		 */
		
		list.insertAtPosition(2, 99);
		list.printList();
		
		list.insertAtPosition(20, 99);
		list.printList();
		list.insertAtPosition(1, 88);
		list.printList();
	}

}
