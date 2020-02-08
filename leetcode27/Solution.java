package leetcode.leetcode27;

import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[--j];
            } else {
                i++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] c1 = new int[] { 3, 3, 2, 2, 3, 3 };
        int r1 = s.removeElement(c1, 3);
        System.out.println(r1);
        System.out.println(Arrays.toString(c1));

        int[] c2 = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
        int r2 = s.removeElement(c2, 2);
        System.out.println(r2);
        System.out.println(Arrays.toString(c2));
    }
}