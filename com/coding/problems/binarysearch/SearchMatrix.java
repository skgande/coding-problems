package com.coding.problems.binarysearch;

public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 300;

        System.out.println(target + " found in matrix? " + searchnMatrix(matrix, target));
    }

    private static boolean searchnMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
