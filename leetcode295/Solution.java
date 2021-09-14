package leetcode.leetcode295;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        MedianFinder s = new MedianFinder();
//        s.addNum(-1);
//        System.out.println(s.findMedian());
//        s.addNum(-2);
//        System.out.println(s.findMedian());
//        s.addNum(-3);
//        System.out.println(s.findMedian());
//        s.addNum(-4);
//        System.out.println(s.findMedian());
//        s.addNum(-5);
//        System.out.println(s.findMedian());

        s.addNum(1);
        System.out.println(s.findMedian());
        s.addNum(2);
        System.out.println(s.findMedian());
        s.addNum(3);
        System.out.println(s.findMedian());

//        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> y-x);
//        heap.add(1);
//        heap.add(2);
//        heap.add(3);
//        System.out.println(heap.peek());
//        System.out.println(heap.size());
    }

}

class MedianFinder {

    private ArrayList<Integer> bHeap = new ArrayList<>();
    private ArrayList<Integer> sHeap = new ArrayList<>();

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (sHeap.size() == 0 || num <= sHeap.get(0)) {
            addToBigHeap(num);
        } else {
            addToSmallHeap(num);
        }


        while (Math.abs(bHeap.size() - sHeap.size()) > 1) {
            if (bHeap.size() > sHeap.size()) {
                addToSmallHeap(removeFromBigHeap());
            } else {
                addToBigHeap(removeFromSmallHeap());
            }
        }
    }

    public double findMedian() {
        if (bHeap.size() == sHeap.size()) {
            return ((double) (bHeap.get(0) + sHeap.get(0))) / 2;
        } else {
            if (bHeap.size() > sHeap.size()) {
                return bHeap.get(0);
            } else {
                return sHeap.get(0);
            }
        }
    }

    private void addToBigHeap(int num) {
        bHeap.add(num);
        int pos = bHeap.size() - 1;
        while (pos > 0) {
            int parent = (pos - 1) / 2;
            if (parent == pos || bHeap.get(parent) >= bHeap.get(pos)) {
                break;
            }
            swap(bHeap, parent, pos);
            pos = parent;
        }
    }

    private int removeFromBigHeap() {
        swap(bHeap, 0, bHeap.size() - 1);
        int pos = 0;
        while (pos < bHeap.size() - 1) {
            int child = pos;
            if (pos * 2 + 1 < bHeap.size() - 1 && bHeap.get(child) < bHeap.get(pos * 2 + 1)) {
                child = pos * 2 + 1;
            }
            if (pos * 2 + 2 < bHeap.size() - 1 && bHeap.get(child) < bHeap.get(pos * 2 + 2)) {
                child = pos * 2 + 2;
            }

            if (child == pos) {
                break;
            }
            swap(bHeap, child, pos);
            pos = child;
        }
        return bHeap.remove(bHeap.size() - 1);
    }

    private void addToSmallHeap(int num) {
        sHeap.add(num);
        int pos = sHeap.size() - 1;
        while (true) {
            int parent = (pos - 1) / 2;
            if (parent == pos || sHeap.get(parent) <= sHeap.get(pos)) {
                break;
            }
            swap(sHeap, parent, pos);
            pos = parent;
        }
    }

    private int removeFromSmallHeap() {
        swap(sHeap, 0, sHeap.size() - 1);
        int pos = 0;
        while (pos < sHeap.size()) {
            int child = pos;
            if (pos * 2 + 1 < sHeap.size() - 1 && sHeap.get(child) > sHeap.get(pos * 2 + 1)) {
                child = pos * 2 + 1;
            }
            if (pos * 2 + 2 < sHeap.size() - 1 && sHeap.get(child) > sHeap.get(pos * 2 + 2)) {
                child = pos * 2 + 2;
            }

            if (child == pos) {
                break;
            }
            swap(sHeap, child, pos);
            pos = child;
        }
        return sHeap.remove(sHeap.size() - 1);
    }

    private void swap(ArrayList<Integer> arr, int i, int j) {
        Integer tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 * <p>
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
