package com.coding.problems.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveNumbers {
    public static void main(String[] args) {
        int[] a = {1, 6, 2, 5, 8, 7, 10, 3};

        System.out.println(longestConsecutiveNumbers(a));
    }

    private static int longestConsecutiveNumbers(int[] a) {
        Set<Integer> s = new HashSet<>();
        for(int x : a) {
            s.add(x);
        }

        int ans = 0;
        for(int x: s) {
            if(!s.contains(x-1)) {
                int y = x + 1;
                while (s.contains(y)) {
                    y++;
                }
                ans = Math.max(ans, y-x);
            }
        }
        return ans;
    }
}
