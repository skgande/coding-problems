package com.coding.problems.binarysearch;

public class InsertionIndex {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 7, 8, 9};
        int target = 4;
        System.out.println("Insertion index: " + getInsertionIndex(nums, target));
    }

    private static int getInsertionIndex(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                low = mid +1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
