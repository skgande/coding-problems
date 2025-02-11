package com.coding.problems.binarysearch;

public class SearchTargetInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {8, 9, 1, 2, 3, 4, 5, 6, 7};
        int target = 1;

        System.out.println("Found target at index " + getTargetIndexInRotatedSortedArray(nums, target));
    }

    private static int getTargetIndexInRotatedSortedArray(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[low] <= nums[mid]) {
                if(target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
