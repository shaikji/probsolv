package com.jilani.educative.amazon;

import java.util.HashMap;

class LongestSubstringWithoutRepetingCharacters {
	public int lengthOfLongestSubstring(String s) {

		if (s == null || s.length() == 0)
			return 0;

		int windowStart = 0;
		char rightChar;
		int maxlen = 0;
		HashMap<Character, Integer> indexMap = new HashMap();

		for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {

			rightChar = s.charAt(windowEnd);

			if (indexMap.containsKey(rightChar)) {
				windowStart = Math.max(windowStart, indexMap.get(rightChar) + 1);
			}
			indexMap.put(rightChar, windowEnd);
			maxlen = Math.max(maxlen, windowEnd - windowStart + 1);
		}

		return maxlen;

	}
}