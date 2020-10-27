package com.jilani.ds.avp.slidingwindow;

import java.util.HashMap;

public class StringPatternPermutationMatching {

	public static void main(String[] args) {

		String text = "bcdxabcdy";
		String pattern = "bcdyabcdx";
		
		boolean exists = patternExists(text, pattern);
		System.out.println(pattern + " exists in " + text +" : " + exists);
	}

	static boolean patternExists(String text, String pattern) {
		
		if ( text == null || text.length() == 0 )
			return false;
		if (pattern == null || pattern.length() == 0)
			return true;
		if (pattern.length() > text.length())
			return false;
		
		
		// Initiallly capture freq count of pattern
		
		HashMap<Character, Integer> patternMap = new HashMap();
		
		for ( int i=0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
		}
		
		int start = 0;
		int matched = 0;
		
		for ( int end=0; end < text.length(); end++) {
			
			char right = text.charAt(end);
			
			if ( patternMap.containsKey(right)) {
				patternMap.put(right, patternMap.get(right) -1);
				if( patternMap.get(right) == 0 )
					matched++;
			}
			
			if ( matched == patternMap.size())
				return true;
			
			if ( end - start + 1 == pattern.length()) {
				
				char left = text.charAt(start);
				if (patternMap.containsKey(left)) {
					if ( patternMap.get(left) == 0 )
						matched--;
					patternMap.put(left, patternMap.get(left)-1);
				}
				start++;
			}
		}
		
		return false;
	}
}


/*

1. Prepare a pattern Map
2. For every character in 'text'
	a. If character is found in map
		reduce the count in pattern map
		increment the matched if count == 0;
		else don't increment matched.
		
	b. If All characters are matched ( matched == pattern.length )
		return true; // or capture the index
		
	c. if window size == pattern.length
		if the 'left' character is found in pattern
			if the count of left char == 0 
			then increment matched--; // reset matching.
			increment its count in pattern map
		start++;


*/
