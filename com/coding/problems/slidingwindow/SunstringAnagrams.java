package com.coding.problems.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SunstringAnagrams {
    public static void main(String[] args) {
        String s = "abab", p = "ab";
        List<Integer> anagramStartIndices = getAnagramStartIndices(s, p);
        System.out.println("Number of substrings matches = " + anagramStartIndices.size());
    }

    private static List<Integer> getAnagramStartIndices(String s, String p) {
        int stringLength = s.length(), patternLength = p.length();
        List<Integer> anagramIndices = new ArrayList<>();

        if(stringLength < patternLength) {
            return anagramIndices;
        }

        int[] patternCount = new int[26];
        for(int i = 0; i < patternLength; i++) {
            patternCount[p.charAt(i) - 'a']++;
        }

        int[] wordCount = new int[26];
        for(int i = 0; i < patternLength - 1; i++) {
            wordCount[s.charAt(i) - 'a']++;
        }

        for(int i = patternLength - 1; i < stringLength; i++) {
            wordCount[s.charAt(i) - 'a']++;

            if(Arrays.equals(wordCount, patternCount)) {
                anagramIndices.add(i - patternLength + 1);
            }
            wordCount[s.charAt(i - patternLength + 1) - 'a']--;
        }
        return anagramIndices;
    }
}
