package com.jilani.ds.avp.slidingwindow;

import java.util.HashMap;

// This is same as MaxLenSubstring with Atmost K distinct characters
// In this problem K = 2;

public class FruitsIntoBasket {

	public static void main(String[] args) {
		
		char[] fruits = {'A','B','C','A','C'};
		
		int K=2;
		
		int maxlen = findMaxLen(fruits, K);
		
		System.out.println(" Max Len of substring with Atmost K distinct characters = " + maxlen);

	}

	static int findMaxLen(char[] fruits, int K) {
		
		if ( fruits == null || fruits.length == 0 || K <= 0)
			return 0;
		
		int windowStart = 0;
		int maxlen = 0;
		HashMap<Character, Integer> map = new HashMap();
		for ( int windowEnd=0; windowEnd < fruits.length; windowEnd++) {
			char c = fruits[windowEnd];
			map.put(c, map.getOrDefault(c, 0)+1);
			
			while ( map.size() > K) {
				char left = fruits[windowStart];
				map.put(left, map.get(left)-1);
				if ( map.get(left) == 0)
					map.remove(left);
				windowStart++;
			}
			
			maxlen = Math.max(maxlen, windowEnd-windowStart+1);
		}
		
		return maxlen;
	}
}
