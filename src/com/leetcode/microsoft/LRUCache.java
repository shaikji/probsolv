package com.leetcode.microsoft;

import java.util.HashMap;

class LRUCache {
    
    HashMap<Integer, DLLNode> map;
    DLLNode head;
    int capacity;
    int currSize;
    DLLNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
        currSize = 0;
    }
    
    public int get(int key) {
        DLLNode node = map.get(key);
        if ( node == null)
            return -1;
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        DLLNode node = map.get(key);
        if (node == null){
            node = new DLLNode(key, value);
            if (currSize == capacity){
                int k = removeLast();
                map.remove(k);
            } else{
                currSize++;    
            }
            addFirst(node);
            map.put(key, node);
            
        } else {
            moveToHead(node);
            node.val = value;
        }
    }
    
    void addLast(DLLNode node){
        if ( head == null)
            head = node;
        tail.next = node;
        node.prev = tail;
        tail = node;
    }
    
     void addFirst(DLLNode node){
        if ( head == null){
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }
    
    int removeLast(){
        if ( tail == null)
            return -1;
        if ( head == tail) {
        	int ret = head.key;
            head = tail = null;
            return ret;
        }
        DLLNode prev = tail.prev;
        prev.next = null;
        tail.prev = null;
        int res = tail.key;
        tail = prev;
        return res;
    }
    
    void moveToHead(DLLNode node){
        
        if ( node.prev == null){
            return;
        }
        if ( node == tail ) {
        	tail = node.prev;
        }
        node.prev.next = node.next;
        if ( node.next != null)
            node.next.prev = node.prev;
        
        node.next = head;
        head.prev = node;
        node.prev = null;
        head = node;
    }
    
    static class DLLNode{
        int val;
        int key;
        DLLNode next;
        DLLNode prev;
        DLLNode(int key, int val){
        	this.key = key;
            this.val = val;
        }
    }
    public static void main(String[] args) {
		/*LRUCache obj = new LRUCache(2);
		obj.put(1, 1);
		obj.put(2, 2);
		System.out.println(obj.get(1));
		obj.put(3, 3);
		System.out.println(obj.get(2));
		obj.put(4, 4);
		System.out.println(obj.get(1));
		System.out.println(obj.get(3));
		System.out.println(obj.get(4));*/
		
    	LRUCache obj = new LRUCache(1);
		obj.put(2, 1);
		System.out.println(obj.get(2));
		obj.put(3, 2);
		System.out.println(obj.get(2));
		System.out.println(obj.get(3));
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */