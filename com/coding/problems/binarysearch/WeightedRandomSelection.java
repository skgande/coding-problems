package com.coding.problems.binarysearch;

import java.util.Random;

public class WeightedRandomSelection {
    int[] prefixSum;
    Random random = new Random();
    WeightedRandomSelection(int[] w) {
        int n = w.length;
        prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] = w[i];
        }
    }

    public int priceIndex() {
        int x = 1 + random.nextInt(prefixSum[prefixSum.length - 1]);
        int left = 1, right = prefixSum.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(prefixSum[mid] >= x) {
                right = mid - 1;
            } else  {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 6};
        WeightedRandomSelection weightedRandomSelection = new WeightedRandomSelection(nums);
        int index = weightedRandomSelection.priceIndex();
        System.out.println(index);
    }
}
