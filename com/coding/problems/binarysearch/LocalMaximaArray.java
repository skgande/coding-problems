package com.coding.problems.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class LocalMaximaArray {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 3};
        List<Integer>  indices = getLocalMaxIndices(nums);
        System.out.println(indices);
    }

    private static List<Integer> getLocalMaxIndices(int[] nums) {
        List<Integer> indices = new ArrayList<>();
        if(nums.length == 0) {
            return indices;
        }

        if(nums.length == 1) {
            indices.add(nums[0]);
            return indices;
        }

        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                if(nums[i + 1] < nums[i]) {
                    indices.add(i);
                }
            } else if(i == nums.length - 1) {
                if(nums[i - 1] < nums[i]) {
                    indices.add(i);
                }
            } else {
                if(nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                    indices.add(i);
                }
            }
        }
        return indices;
    }
}
