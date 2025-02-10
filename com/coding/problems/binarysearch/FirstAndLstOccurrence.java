package com.coding.problems.binarysearch;

public class FirstAndLstOccurrence {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10, 11};
        int target = 4;
        int[] res = getOccurrences(nums, target);
        System.out.println("First and last occurrence: " + res[0] + " and " + res[1]);
    }

    private static int[] getOccurrences(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            if(nums[low] == target && nums[high] == target) {
                return new int[]{low, high};
            }

            if(nums[low] < target) {
                low++;
            }

            if(nums[high] > target) {
                high--;
            }
        }
        return new int[]{-1, -1};
    }
}
