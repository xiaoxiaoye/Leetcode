package leetcode;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x,y)->y-x);
        int[] arr = new int[]{1,3,2,5};
        for (int i=0; i<arr.length;i++){
            queue.add(arr[i]);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
