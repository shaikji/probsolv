package com.jilani.ds.avp.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString {

	public static void main(String[] args) {
		
		String text = "aabdec";
		String pattern = "abc";
		System.out.println(" Min len Substring = " + minLenSubstring(text, pattern));
		
		text = "abdbca";
		pattern = "abc";
		System.out.println(" Min len Substring = " + minLenSubstring(text, pattern));
		
		text = "adcad";
		pattern = "abc";
		System.out.println(" Min len Substring = " + minLenSubstring(text, pattern));
		
	}
	
	static String minLenSubstring(String text, String pat) {
		
		if ( text == null || pat == null)
			return "";
		
		Map<Character, Integer> map = new HashMap();
		
		for ( int i=0; i < pat.length(); i++) {
			char ch = pat.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		int start = 0;
		int minlen = Integer.MAX_VALUE;
		int matched = 0;
		String ans = "";
		for ( int end =0; end < text.length(); end++) {	
			char right = text.charAt(end);
			if ( map.containsKey(right)) {
				map.put(right, map.get(right) -1);
				if ( map.get(right) == 0 )
					matched++;
			}
			if ( matched == map.size()) {
				while( matched == map.size()) {
					if ( end-start+1 < minlen) {
						minlen = end-start+1;
						ans = text.substring(start, end+1);
					}
					char left = text.charAt(start);
					if ( map.containsKey(left)) {
						if ( map.get(left) == 0) {
							matched--;
						}
						map.put(left, map.get(left) + 1);
					} 
					start++;
				}
			}
		}
		
		return ans;
	}

}
