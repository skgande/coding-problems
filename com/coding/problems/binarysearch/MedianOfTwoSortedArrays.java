package com.coding.problems.binarysearch;

import java.awt.*;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {0, 2, 5, 6, 8};
        int[] nums2 = {1, 3, 7};

        System.out.println("Median of two sorted arrays : " + getMedianOfTwoSortedArrays(nums1, nums2));
    }

    private static double getMedianOfTwoSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;

        if(n > m) {
            return getMedianOfTwoSortedArrays(nums2, nums1);
        }

        int low = 0, high = n;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = (n + m + 1) / 2 - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int r1 = (mid1 == n) ? Integer.MAX_VALUE : nums1[mid1];

            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int r2 = (mid2 == m) ? Integer.MAX_VALUE : nums2[mid2];

            if(l1 <= r2 && l2 <= r1) {
                if((n + m) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            }

            if(l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
         }
        return  0;
    }
}
