package com.jilani.ds.avp.stacks;

import java.util.Stack;

import com.jilani.ds.utils.Utils;

public class NGE2Left {

	public static void main(String[] args) {
		
		int[] arr = {2,1,5,7,3,11,6,5};
		NGE2Left app = new NGE2Left();
		Utils.printArray(arr);
		int[] nge = app.nge2left(arr);
		Utils.printArray(nge);
	}
	
	int[] nge2left(int[] arr) {
		
		if ( arr == null || arr.length == 0 )
			return arr;
		int n = arr.length;
		
		int[] res = new int[n];
		Stack<Integer> stack = new Stack();
		
		for ( int i=0; i < n; i++) {
			
			while ( !stack.isEmpty() && stack.peek() >= arr[i])
				stack.pop();
			res[i] = stack.isEmpty() ? -1: stack.peek();
			stack.push(arr[i]);
		}
		
		return res;
	}

}
