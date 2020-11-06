package com.jilani.ds.educative.fastnslowpointer;

class PalindromicLinkedList {

	public static boolean isPalindrome(ListNode head) {

		if (head == null || head.next == null)
			return true;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode headSecondHalf = reverse(slow);
		ListNode copyheadSecondHalf = headSecondHalf;

		while (head != null && headSecondHalf != null) {

			if (head.value != headSecondHalf.value)
				break;

			head = head.next;
			headSecondHalf = headSecondHalf.next;
		}

		reverse(copyheadSecondHalf);
		if (head == null && headSecondHalf == null)
			return true;

		return false;
	}

	static ListNode reverse(ListNode head) {

		ListNode p = head;
		ListNode q = head;
		ListNode r = null;

		while (p != null) {
			p = p.next;
			q.next = r;
			r = q;
			q = p;
		}

		return r;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(2);
		System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

		head.next.next.next.next.next = new ListNode(2);
		System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
	}

	static class ListNode {
		int value = 0;
		ListNode next;

		ListNode(int value) {
			this.value = value;
		}
	}
}