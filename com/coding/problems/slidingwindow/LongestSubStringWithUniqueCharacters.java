package com.coding.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithUniqueCharacters {
    public static void main(String[] args) {
        String str = "abcbbc";
        System.out.println("Longest uniform character count : " + getLongestUniformCharCount(str));
    }

    private static int getLongestUniformCharCount(String str) {
        int maxLength = 0;
        int start = 0, end = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();

        for(; end < str.length(); end++) {
            Character currChar = str.charAt(end);
            if(charMap.containsKey(currChar) && charMap.get(currChar) >= start) {
                start = charMap.get(currChar) + 1;
            }
            charMap.put(currChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
