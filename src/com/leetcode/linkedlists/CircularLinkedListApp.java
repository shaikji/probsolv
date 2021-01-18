package com.leetcode.linkedlists;

public class CircularLinkedListApp {

	public static void main(String[] args) {

		CircularLinkedList list = new CircularLinkedList();
		for ( int i=1; i <=10; i++)
			list.insert(i);
		list.printList();

		
	}

}
