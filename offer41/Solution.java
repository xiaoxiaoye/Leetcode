package leetcode.offer41;

import java.util.PriorityQueue;

class MedianFinder {
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (maxHeap.size() == 0 || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        while (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
            } else {
                maxHeap.add(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            if (maxHeap.size() > minHeap.size()) {
                return (double) maxHeap.peek();
            } else {
                return (double) minHeap.peek();
            }
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/*
["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
[[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
 */
public class Solution {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(-4);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(-5);
//        System.out.println(medianFinder.findMedian());

    }
}
