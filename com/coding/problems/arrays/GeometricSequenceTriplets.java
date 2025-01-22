package com.coding.problems.arrays;

public class GeometricSequenceTriplets {
    public static void main(String[] args) {
        int[] a = {2, 1, 2, 4, 8, 8};
        int r = 2;

        int n = a.length; int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    if (a[i] * r == a[j] && a[j] * r == a[k]) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
