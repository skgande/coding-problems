package com.coding.problems.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] res = getMaxSlidingWindow(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] +  " ");
        }
    }

    private static int[] getMaxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0) {
            return new int[0];
        }

        int n = nums.length;;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            if(!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);
            if(i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return  res;
    }
}
