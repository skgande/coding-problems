package com.coding.problems.slidingwindow;

public class LongestUniformSubStringAfterReplacement {
    public static void main(String[] args) {
        String str = "aabcdcca";
        System.out.println("Longest uniform substring after replacement " + getLongestString(str, 2));
    }

    private static int getLongestString(String str, int k) {
        str = str.toUpperCase();
        int maxLength = 0, start = 0, end = 0;
        int[] letterCount = new int[26];

        for(; end < str.length(); end++) {
            char currChar = str.charAt(end);
            letterCount[currChar - 'A']++;

            maxLength = Math.max(maxLength, letterCount[currChar - 'A']);

            if(end - start + 1 - maxLength > k) {
                letterCount[str.charAt(start) -  'A']--;
                start++;
            }
        }

        return end - start;
    }
}
