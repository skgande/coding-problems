package com.coding.problems.arrays;

import java.util.*;

public class TripletSum {
    public static void main(String[] args) {
        int[] a = {0, -1, 2, -3, 1};
        Set<ArrayList<Integer>> result = getTriplet(a);
        for(ArrayList<Integer> arr: result) {
            System.out.println(arr);
        }
    }

    private static Set<ArrayList<Integer>> getTriplet(int[] a) {
        Map<Integer, int[]> map = new HashMap<>();
        Set<ArrayList<Integer>> resultSet = new HashSet<>();

        for(int i = 0; i < a.length; i++) {
            for(int j = i+1; j < a.length; j++) {
                if(!map.containsKey(a[i] + a[j])) {
                    map.put(a[i] + a[j], new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            int result = -a[i];
            if(map.containsKey(result)) {
                int[] pointers = map.get(result);
                if(i != pointers[0] && i!= pointers[1]) {
                    ArrayList<Integer> currArray = new ArrayList<>(Arrays.asList(i, pointers[0], pointers[1]));
                    Collections.sort(currArray);
                    resultSet.add(currArray);
                }
            }
        }
        if(resultSet.isEmpty()) {
            resultSet.add(new ArrayList<>(Arrays.asList(-1, -1, -1)));
        }

        return resultSet;
    }
}
