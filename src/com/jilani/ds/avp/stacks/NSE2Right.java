package com.jilani.ds.avp.stacks;

import java.util.Stack;

import com.jilani.ds.utils.Utils;

public class NSE2Right {

	public static void main(String[] args) {
		
		int[] arr = {2,1,5,7,3,11,6,5};
		NSE2Right app = new NSE2Right();
		Utils.printArray(arr);
		int[] nge = app.nse2right(arr);
		Utils.printArray(nge);
	}
	
	int[] nse2right(int[] arr) {
		
		if ( arr == null || arr.length == 0 )
			return arr;
		int n = arr.length;
		
		int[] res = new int[n];
		Stack<Integer> stack = new Stack();
		
		for ( int i=n-1; i >=0; i--) {
			
			while ( !stack.isEmpty() && stack.peek() >= arr[i])
				stack.pop();
			res[i] = stack.isEmpty() ? -1: stack.peek();
			stack.push(arr[i]);
		}
		
		return res;
	}

}
