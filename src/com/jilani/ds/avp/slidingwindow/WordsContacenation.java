package com.jilani.ds.avp.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordsContacenation {

	public static void main(String[] args) {

		String text = "catfoxcat";
		String[] words = { "cat", "fox" };
		List<Integer> indices = getConcatenatedIndices(text, words);
		System.out.println(" List of indices of word concatenation are");
		System.out.println(indices);
		System.out.println();
		String text2 = "catcatfoxfox";
		String[] words2 = { "cat", "fox" };
		List<Integer> indices2 = getConcatenatedIndices(text2, words2);
		System.out.println(" List of indices of word concatenation are");
		System.out.println(indices2);
	}

	static List<Integer> getConcatenatedIndices(String text, String[] words) {

		List<Integer> indexList = new ArrayList();

		if (text == null || words == null || words.length == 0)
			return indexList;

		// pre processing: Maintain a frequency of words
		
		HashMap<String, Integer> wordFreqMap = new HashMap();
		
		for (String word: words) {
			wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
		}
		
		// For all possible indices of 'i' check if we can find the concatenated string
		// of words in the text
		// If so, add the index to the result.
		
		int wordsCount = words.length; 
		int wordLength = words[0].length();
		
		for ( int i=0; i <= text.length() - wordsCount * wordLength; i++) {
			
			HashMap<String, Integer> seen = new HashMap();
			
			int j =0;
			for ( ; j <wordsCount; j++) {
				
				int nextWordIndex = i + j * wordLength; 
				String s = text.substring(nextWordIndex, nextWordIndex+ wordLength);
				
				if ( !wordFreqMap.containsKey(s)) {
					break;
				}
				
				seen.put(s, seen.getOrDefault(s,0)+1);
				
				if (seen.get(s) > wordFreqMap.get(s)) {
					break;
				}
			}
			// Found all the words. Note the index
			if ( j == wordsCount) {
				indexList.add(i);
			}
		}
		
		return indexList;

	}

}
