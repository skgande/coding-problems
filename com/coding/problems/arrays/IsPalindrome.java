package com.coding.problems.arrays;

public class IsPalindrome {
    public static void main(String[] args) {
        String str = "a dog! a panic in a pagoda";
        System.out.println(isPalindrome(str));
    }

    private static boolean isPalindrome(String input) {
        input = input.toLowerCase();
        int i = 0, j = input.length() - 1;

        while(i < j) {
            if(!Character.isLetterOrDigit(input.charAt(i))) {
                i++;
                continue;
            }

            if(!Character.isLetterOrDigit(input.charAt(j))) {
                j--;
                continue;
            }

            if(input.charAt(i) != input.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return  true;
    }
}
