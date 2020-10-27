package com.jilani.ds.avp.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllPatternPermutationsInAString {

	public static void main(String[] args) {

		String text = "abbcabc";
		String pattern = "abc";

		List<Integer> indices = patternExists(text, pattern);

		System.out.println(" Indices of '" + pattern + "' in text '" + text + "'");
		System.out.println(indices);
	}

	static List<Integer> patternExists(String text, String pattern) {

		List<Integer> indices = new ArrayList();

		if (text == null || pattern == null)
			return indices;

		Map<Character, Integer> map = new HashMap();

		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int matched = 0;
		int start = 0;

		for (int end = 0; end < text.length(); end++) {
			char right = text.charAt(end);

			if (map.containsKey(right)) {
				map.put(right, map.get(right) - 1);

				if (map.get(right) == 0)
					matched++;
			}

			if (matched == map.size())
				indices.add(start);

			if ((end - start + 1) == pattern.length()) {
				char left = text.charAt(start);
				if (map.containsKey(left)) {
					if (map.get(left) == 0) {
						matched--;
					}
					map.put(left, map.get(left) + 1);
				}
				start++;
			}

		}

		return indices;
	}
}

/*
 * 
 * 1. Prepare a pattern Map 2. For every character in 'text' a. If character is
 * found in map reduce the count in pattern map increment the matched if count
 * == 0; else don't increment matched.
 * 
 * b. If All characters are matched ( matched == pattern.length ) return true;
 * // or capture the index
 * 
 * c. if window size == pattern.length if the 'left' character is found in
 * pattern if the count of left char == 0 then increment matched--; // reset
 * matching. increment its count in pattern map start++;
 * 
 * 
 */
