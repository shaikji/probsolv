package com.jilani.ds.avp.stacks;

import java.util.Stack;

import com.jilani.ds.utils.Utils;

public class StockSpanProblem {

	public static void main(String[] args) {
		
		StockSpanProblem app = new StockSpanProblem();
		
		int[] stocks = {100, 80, 60, 70, 60, 75, 85};
		
		Utils.printArray(stocks);
		int[] span = app.stockspan(stocks);
		Utils.printArray(span);
	}
	
	int[] stockspan(int[] stocks) {
		
		if ( stocks == null || stocks.length == 0 )
			return stocks;
		int n = stocks.length;
		int[] span = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i=0; i < n; i++) {
			while ( !stack.isEmpty() && stocks[stack.peek()] <= stocks[i])
				stack.pop();
			span[i] = stack.isEmpty() ? i + 1: i-stack.peek();
			stack.push(i);
		}
		return span;
	}
	

}
