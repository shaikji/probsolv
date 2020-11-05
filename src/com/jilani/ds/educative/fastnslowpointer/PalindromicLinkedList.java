package com.jilani.ds.educative.fastnslowpointer;


  
  class PalindromicLinkedList {
  
    public static boolean isPalindrome(ListNode head) {
  
      if ( head == null || head.next == null)
          return true;
  
      ListNode slow = head;
      ListNode fast = head;
      ListNode mid = null;
  
      while ( fast != null && fast.next != null){
          mid = slow;
          slow = slow.next;
          fast = fast.next.next;
      }
  
      // Prev is the mid;
  
      if ( fast != null)
          mid = mid.next;
  
      mid.next = reverse(mid.next);
  
      ListNode curr = head;
      ListNode curr2 = mid.next;
      boolean flag = true;
  
      while (curr2  != null){
          if (curr.value != curr2.value){
              flag = false;
              break;
          }
          curr2 = curr2.next;
          curr = curr.next;
      }
      mid.next = reverse(mid.next);
      
      return flag;
    }
  
    static ListNode reverse(ListNode head){
  
      ListNode p = head;
      ListNode q = head;
      ListNode r = null;
  
      while ( p != null){
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