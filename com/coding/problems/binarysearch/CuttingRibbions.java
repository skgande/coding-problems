package com.coding.problems.binarysearch;

public class CuttingRibbions {
    public static void main(String[] args) {
        int[] ribbons = {9, 7 , 5};
        int k = 5;

        System.out.println("Get n equal segments " + maxLength(ribbons, k));
    }

    private static int maxLength(int[] ribbons, int k) {
        int minLength = 0;
        int maxLength = 0;

        for(int ribbon : ribbons) {
            maxLength = Math.max(maxLength, ribbon);
        }

        while (minLength < maxLength) {
            int midLength = (minLength + maxLength + 1) / 2;
            int count  = 0;
            for(int ribbon: ribbons) {
                count = count + ribbon/midLength;
            }

            if(count >= k) {
                minLength = midLength;
            }else  {
                maxLength = midLength - 1;
            }
        }

        return minLength;
    }
}
