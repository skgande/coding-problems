package com.coding.problems.arrays;

public class ShiftZerosToEnd {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 2};
        a = shiftZeros(a);
        for(int i: a)
            System.out.print(i + " ");
    }

    private static int[] shiftZeros(int[] a) {
        int count = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] != 0)
                a[count++] = a[i];
        }
        while(count < a.length)
            a[count++] = 0;
        return a;
    }
}
