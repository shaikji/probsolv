package com.jilani.ds.avp.slidingwindow;

import java.util.HashMap;

public class MaxLenSubStringWithAtmostKDistinctCharacters {

	public static void main(String[] args) {
		
		String str = "araaciddddcccefg";
		int K=2;
		
		int maxlen = findMaxLen(str, K);
		
		System.out.println(" Max Len of substring with Atmost K distinct characters = " + maxlen);

	}

	static int findMaxLen(String s, int K) {
		
		if ( s == null || s.length() == 0 || K <= 0)
			return 0;
		
		int windowStart = 0;
		int maxlen = 0;
		HashMap<Character, Integer> map = new HashMap();
		for ( int windowEnd=0; windowEnd < s.length(); windowEnd++) {
			char c = s.charAt(windowEnd);
			map.put(c, map.getOrDefault(c, 0)+1);
			
			while ( map.size() > K) {
				char left = s.charAt(windowStart);
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
