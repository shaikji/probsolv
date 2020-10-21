package com.jilani.ds.avp.stacks;

import java.util.Stack;

public class MinStackWithExtraSpace {
	
	Stack<Integer> stack = new Stack();
	Stack<Integer> minStack = new Stack();

	public static void main(String[] args) {
		
		MinStackWithExtraSpace stack = new MinStackWithExtraSpace();
		
		stack.push(4);
		System.out.println(" min = " + stack.min());
		stack.push(2);
		System.out.println(" min = " + stack.min());

		stack.push(5);
		System.out.println(" min = " + stack.min());

		stack.push(6);
		System.out.println(" min = " + stack.min());

		stack.push(1);
		System.out.println(" min = " + stack.min());

		stack.push(4);
		System.out.println(" min = " + stack.min());

		
		for ( int i=1; i<6; i++) {
			stack.pop();
			System.out.println(stack.min());
		}
		

	}
	
	
	void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek())
			minStack.push(x);
	}
	
	int pop() {
		if ( stack.isEmpty())
			return -1;
		int x = stack.pop();
		if (!minStack.isEmpty() && x == minStack.peek())
			minStack.pop();
		return x;
	}
	
	int peek() {
		if ( stack.isEmpty())
			return -1;
		return stack.peek();
	}
	
	int min() {
		if ( minStack.isEmpty())
			return -1;
		return minStack.peek();
	}

}
