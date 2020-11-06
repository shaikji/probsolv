package com.jilani.ds.educative.fastnslowpointer;

class RearrangeList {

	public static void reorder(ListNode head) {
		
		if ( head == null || head.next == null )
			return;
		
		// Step 1: Find Mid point
		ListNode slow = head;
		ListNode fast = head;	
		while ( fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// slow is your midpoint
		// Step 2: Reverse the second half
		ListNode secondHalf = reverse(slow);
		merge(head, secondHalf);
	}
	
	private static void merge(ListNode first, ListNode second ) {
		
		ListNode p = first;
		ListNode q = second;
		ListNode pNext = null;
		ListNode qNext = null;
		
		while ( p != null && q != null) {
			pNext = p.next;
			qNext = q.next;
			p.next = q;
			q.next = pNext;
			p = pNext;
			q = qNext;
		}
		
		if ( p!= null)
			p.next = null;
	}
	
	private static ListNode reverse(ListNode head) {
		
		ListNode p = head;
		ListNode q = head;
		ListNode r = null;
		
		while ( p != null) {
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
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);
		head.next.next.next.next.next = new ListNode(12);

		RearrangeList.reorder(head);
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}

	static class ListNode {
		int value = 0;
		ListNode next;

		ListNode(int value) {
			this.value = value;
		}
	}
}