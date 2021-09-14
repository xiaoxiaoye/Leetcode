package leetcode.offer59;

import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> windows = new LinkedList<>();
        int left = 0;
        int right = 0;
        windows.addLast(nums[0]);
        for(right =1; right<k; right++){
            while (!windows.isEmpty() && windows.getLast() < nums[right]) {
                windows.removeLast();
            }
            windows.addLast(nums[right]);
        }

        int[] res = new int[nums.length-k+1];
        int pos = 0;
        res[pos++] = windows.getFirst();
        for (right=k; right< nums.length; right++){
            if (windows.getFirst() == nums[left]) {
                windows.removeFirst();
            }
            left++;

            while (!windows.isEmpty() && windows.getLast() < nums[right]) {
                windows.removeLast();
            }
            windows.addLast(nums[right]);
            res[pos++] = windows.getFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] r = s.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(r));
    }
}