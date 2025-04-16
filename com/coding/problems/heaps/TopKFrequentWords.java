package com.coding.problems.heaps;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;

        List<String> topWords = getTopWords(words, k);
        System.out.println("Top words are: " + topWords);
    }

    private static List<String> getTopWords(String[] words, int k){
        Map<String, Integer> wordCountMap = new HashMap<>();
        for(String word: words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>((word1, word2) -> {
            int diff = wordCountMap.get(word1) - wordCountMap.get(word2);

            if(diff == 0) {
                return word2.compareTo(word1);
            }
            return diff;
        });

        for(String word: wordCountMap.keySet()) {
            heap.offer(word);
            if(heap.size() > k) {
                heap.poll();
            }
        }

        LinkedList<String> topWords = new LinkedList<>();
        while (!heap.isEmpty()) {
            topWords.addFirst(heap.poll());
        }
        return topWords;
    }
}
