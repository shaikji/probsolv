package com.jilani.ds.avp.slidingwindow;

import java.util.HashMap;

public class NoRepeatSubstring {

	public static void main(String[] args) {
		
		String str = "aabccbb";
		int maxlen = norepeatSubstring(str);
		System.out.println(" Longest substring length with no repeationg characters = " + maxlen);
	}
	
	static int norepeatSubstring(String str) {
		
		if ( str == null || str.length() == 0 )
			return 0;
		
		HashMap<Character, Integer> map = new HashMap();
		
		int windowStart = 0;
		int maxlen = 0;
		
		for ( int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char right = str.charAt(windowEnd);
			
			if (map.containsKey(right)) {
				int idx = map.get(right);
				windowStart = Math.max(windowStart, idx+1);
			} 
			map.put(right, windowEnd);
			maxlen = Math.max(maxlen, windowEnd-windowStart+1);
		}
		
		return maxlen;
		
	}

}
