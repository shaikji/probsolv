package com.jilani.ds.educative.fastnslowpointer;

class LinkedListCycleStart {

	public static ListNode findCycleStart(ListNode head) {

		if (head == null)
			return head;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				// Loop exists - find starting point

				return findStartOfLoop(head, slow);
			}
		}
		return head;
	}

	private static ListNode findStartOfLoop(ListNode head, ListNode slow) {
		while (head != slow) {
			head = head.next;
			slow = slow.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		head.next.next.next.next.next.next = head.next.next;
		System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

		head.next.next.next.next.next.next = head.next.next.next;
		System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

		head.next.next.next.next.next.next = head;
		System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
	}

	static class ListNode {
		int value = 0;
		ListNode next;

		ListNode(int value) {
			this.value = value;
		}
	}
}