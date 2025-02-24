package com.coding.problems.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextLargestNumberToRight {
    public static void main(String[] args) {
        int[] nums = {5, 2, 4, 6, 1};
        int[] result = getNextLargestToRight(nums);

        for(int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] getNextLargestToRight(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i = n -1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return ans;
    }
}
