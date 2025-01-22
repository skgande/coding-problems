package com.coding.problems.arrays;

public class ZeroStripping {
    public static void main(String[] args) {
        int[][] a  = {
                {1, 2, 3, 4, 5},
                {6, 0, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 0}
        };
        int m = a.length, n = a[0].length;
        setZeros(a, m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setZeros(int[][] a, int m, int n) {
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(a[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(row[i] | col[j]) {
                    a[i][j] = 0;
                }
            }
        }
    }
}
