package com.coding.problems.arrays;

import java.util.Map;

public class LargestContainer {
    public static void main(String[] args) {
        int[] a = {2, 7, 8, 3, 7, 6};
        System.out.println(largestContainer(a));
    }

    private static int largestContainer(int[] a) {
        int left = 0, right = a.length - 1;
        int area = 0;

        while (left < right) {
            area = Math.max(area, Math.min(a[left], a[right]) * (right - left));
            if(a[left] < a[right])
                left++;
            else
                right--;
        }
        return area;
    }
}
