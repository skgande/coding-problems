package com.coding.problems.arrays;

public class NextLexicographicSequence {
    public static void main(String[] args) {
        String str = "dcba";
        System.out.println(getNextLexicographicSequence(str));
    }

    private static String getNextLexicographicSequence(String str) {
        char[] arr = str.toCharArray();
        int  n = str.length();
        int i = n - 2;

        while (i >= 0 && (arr[i] >= arr[i+1])) {
            i--;
        }

        if(i < 0) {
            System.out.println("No next sequence");
            // Print the first sequence by reversing, as the given sequence is last permutation.
            reverse(arr, 0, n-1);
            return String.valueOf(arr);
        }

        int j = n - 1;
        while (j >= 0 && arr[j] <= arr[i]) {
            j--;
        }

        swap(arr, i, j);
        reverse(arr, i + 1, n - 1);
        return String.valueOf(arr);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
