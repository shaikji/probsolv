package com.jilani.ds.educative.fastnslowpointer;

class FindLengthOfLinkedListCycle {

	public static int getLoopLength(ListNode head) {

		if (head == null)
			return 0;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println(" Loop exists ");

				int len = 0;
				do {
					len++;
					fast = fast.next;
				} while (fast != slow);

				return len;
			}

		}

		return 0;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		System.out.println("LinkedList has cycle: " + FindLengthOfLinkedListCycle.getLoopLength(head));

		head.next.next.next.next.next.next = head.next.next;
		System.out.println("LinkedList has cycle: " + FindLengthOfLinkedListCycle.getLoopLength(head));

		head.next.next.next.next.next.next = head.next.next.next;
		System.out.println("LinkedList has cycle: " + FindLengthOfLinkedListCycle.getLoopLength(head));
	}

	static class ListNode {
		int value = 0;
		ListNode next;

		ListNode(int value) {
			this.value = value;
		}
	}
}