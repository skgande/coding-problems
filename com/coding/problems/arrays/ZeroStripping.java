package com.coding.problems.arrays;

import java.util.HashSet;
import java.util.Set;

public class ZeroStripping {
    public static void main(String[] args) {
        int[][] a  = {
                {1, 2, 3, 4, 5},
                {6, 0, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 0}
        };
        int m = a.length;
        int n = a[0].length;
        Set<int[]> set = new HashSet<int[]>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(a[i][j] == 0) {
                    set.add(new int[] {i, j});
                }
            }
        }

        setZeros(a, set, m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setZeros(int[][] a, Set<int[]> set, int m, int n) {
        for(int[] k: set) { //{3, 4}
            for(int i = 0; i < n; i++) {
                a[k[0]][i] = 0;
            }

            for(int i = 0; i < m; i++) {
                a[i][k[1]] = 0;
            }
        }
    }
}
