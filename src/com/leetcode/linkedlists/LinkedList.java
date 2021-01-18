package com.leetcode.linkedlists;

public class LinkedList implements List {

	ListNode head;

	public LinkedList() {
		head = null;
	}

	@Override
	public boolean insertBegin(int data) {

		if (head == null) {
			head = new ListNode(data);
			return true;
		}

		ListNode node = new ListNode(data);
		node.next = head;
		head = node;
		return true;
	}

	@Override
	public boolean insert(int data) {

		if (head == null) {
			head = new ListNode(data);
			return true;
		}

		ListNode curr = head;

		while (curr.next != null)
			curr = curr.next;

		curr.next = new ListNode(data);
		return true;
	}

	@Override
	public boolean insertAtPosition(int pos, int data) {

		if (pos < 1) {
			System.out.println(" Invalid Position");
			return false;
		} else if (pos == 1)
			return insertBegin(data);

		// else insert at the given position.

		ListNode curr = head;
		for (int cnt = 1; cnt < pos - 1; cnt++) {
			curr = curr.next;
			if (curr == null) {
				System.out.println(" Invalid pos");
				return false;
			}
		}
		ListNode node = new ListNode(data);
		node.next = curr.next;
		curr.next = node;
		return true;
	}

	@Override
	public boolean insertAfter(int val, int data) {

		ListNode curr = head;

		while (curr != null) {
			if (curr.data == val)
				break;

			curr = curr.next;
		}

		if (curr == null) {
			System.out.println(" Node not found");
			return false;
		}
		ListNode node = new ListNode(data);
		node.next = curr.next;
		curr.next = node;
		return true;
	}

	@Override
	public boolean insertBefore(int val, int data) {
		return false;
	}

	public void printList() {

		if (head == null) {
			System.out.println(" List is empty");
			return;
		}
		ListNode curr = head;
		while (curr.next != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println(curr.data);
	}

}
