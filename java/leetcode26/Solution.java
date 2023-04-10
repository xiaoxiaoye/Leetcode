package leetcode.leetcode26;

import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while(true){
            while(j < nums.length && nums[i] == nums[j]) j++;
            if(j >= nums.length) break;
            nums[++i] = nums[j];
        }
        return i+1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] c1 = new int[] { 1, 1, 2 };
        int r1 = s.removeDuplicates(c1);
        System.out.println(r1);
        System.out.println(Arrays.toString(c1));

        int[] c2 = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int r2 = s.removeDuplicates(c2);
        System.out.println(r2);
        System.out.println(Arrays.toString(c2));
    }
}