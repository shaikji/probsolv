package com.jilani.ds.avp.stacks;

import java.util.Stack;

public class MinStack {
	
	Stack<Integer> stack = new Stack();
	int minElem = 0;
	

	public static void main(String[] args) {
		
		MinStack stack = new MinStack();
		
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
		if ( stack.isEmpty() ) {
			stack.push(x);
			minElem = x;
		} else if ( x > stack.peek())
		{
			stack.push(x);
		} else {
			stack.push(2 * x - minElem);
			minElem = x;
		}
	}
	
	int pop() {
		if ( stack.isEmpty())
			return -1;
		
		int y = stack.pop();
		if ( y < minElem) {
			int temp = minElem;
			minElem = 2 * minElem - y;
			return temp;
		} else {
			return y;
		}
	}
	
	int peek() {
		if ( stack.isEmpty())
			return -1;
		int y = stack.peek();
		if ( y >= minElem)
			return stack.peek();
		else
			return 2 * stack.peek() - minElem;
	}
	
	int min() {
		if ( stack.isEmpty())
			return -1;
		return minElem;
	}

}
