package com.coding.problems.arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        a = getNextPermuatation(a);
        for(int i : a) {
            System.out.print(i + " ");
        }
    }

    private static int[] getNextPermuatation(int[] a) {
        int n = a.length, i = n-2;
        while (i >= 0 && (a[i] >= a[i+1])) {
            i--;
        }

        if(i < 0){
            System.out.println("No next permutation and prent reverse of array");
            return reverse(a, 0, n-1);
        }

        int j = n-1;
        while(j >=0 && (a[j] <= a[i])) {
            j--;
        }
        swap(a, i, j);
        return reverse(a, i+1, n-1);
    }

    private static int[] reverse(int[] a, int start, int end) {
        while (start < end) {
            swap(a, start, end);
            start++;
            end--;
        }
        return a;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
