package com.jilani.ds.avp.slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithSameLettersAfterReplacement {

	public static void main(String[] args) {
		
		String str = "abbcb";
		int K=1;
		int maxlen = longestSubstringAfterReplacement(str, K);
		System.out.println(" Longest substring with same letters after " + K +" replacements = " + maxlen);
	}
	
	static int longestSubstringAfterReplacement(String str, int K) {
		
		if ( str == null || str.length() == 0 )
			return 0;
		
		HashMap<Character, Integer> map = new HashMap();
		
		int windowStart = 0;
		int maxlen = 0;
		int maxfreq = 0;
		
		for ( int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char right = str.charAt(windowEnd);
			map.put(right, map.getOrDefault(right, 0) + 1);
			
			
			maxfreq = Math.max(maxfreq, map.get(right));
			
			if ( (windowEnd - windowStart + 1 - maxfreq) > K) {
				char left = str.charAt(windowStart);
				map.put(left, map.get(left)-1);
				windowStart++;
			}  
			maxlen = Math.max(maxlen, windowEnd-windowStart+1);
		}
		
		return maxlen;
		
	}

}
