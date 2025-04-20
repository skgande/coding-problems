package com.coding.problems.heaps;

import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void main(String[] args) {
        int[] nums = {5, 1, 9, 4, 7, 10};
        int k = 2;

        int[] res = getSortKSortedArray(nums, k);
        for(int i: res) {
            System.out.print(i + " ");
        }
    }

    private static int[] getSortKSortedArray(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i <= k; i++) {
            minHeap.add(nums[i]);
        }

        int index = 0;
        for(int i = k + 1; i < nums.length; i++) {
            nums[index++] = minHeap.poll();
            minHeap.add(nums[i]);
        }

        while (!minHeap.isEmpty()) {
            nums[index++] = minHeap.poll();
        }
        return nums;
    }
}
