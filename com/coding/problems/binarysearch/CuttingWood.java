package com.coding.problems.binarysearch;

public class CuttingWood {
    public static void main(String[] args) {
        int[] trees = {20, 15, 10, 17};
        int k = 7;
        System.out.println(maxSawbladeheight(trees, k));
    }

    private static int maxSawbladeheight(int[] trees, int k) {
        int low = 0, high = getMaxHeight(trees);
        int bestH = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long woodCollected = getWoodCollected(trees, mid);

            if(woodCollected >= k) {
                bestH = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return bestH;
    }

    private static long getWoodCollected(int[] trees, int k) {
        long total = 0;
        for(int tree: trees) {
            if (tree > k) {
                total = total + (tree - k);
            }
        }
        return total;
    }

    private static int getMaxHeight(int[] trees) {
        int max = 0;
        for(int tree: trees) {
            max = Math.max(max, tree);
        }
        return max;
    }
}
