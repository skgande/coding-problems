package com.coding.problems.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfIntegerStreams {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    MedianOfIntegerStreams() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double getMedian() {
        if((minHeap.size() + maxHeap.size()) % 2 == 0){
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianOfIntegerStreams medianOfIntegerStreams = new MedianOfIntegerStreams();
        medianOfIntegerStreams.addNum(1);
        System.out.println(medianOfIntegerStreams.getMedian());
        medianOfIntegerStreams.addNum(2);
        System.out.println(medianOfIntegerStreams.getMedian());
        medianOfIntegerStreams.addNum(3);
        System.out.println(medianOfIntegerStreams.getMedian());
    }
}
