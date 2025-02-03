package com.coding.problems.linkedlists;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 21;
        System.out.println(n + " is happy number? " + isHappyNumber(n));
    }

    private static boolean isHappyNumber(int n) {
        int sum = n, x = n;
        while (sum > 9) {
            sum = 0;
            while ( x > 0) {
                int d = x % 10;
                sum = sum + d * d;
                x = x / 10;
            }
            x = sum;
        }

        return (sum == 1 || sum == 7);
    }
}
