package leetcode.leetcode16;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (42.18%)
 * Likes:    314
 * Dislikes: 0
 * Total Accepted:    61.8K
 * Total Submissions: 145.8K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int currentValue = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i+1;
            int end = nums.length-1;
            while(start < end) {
                int t = nums[i] + nums[start] + nums[end];
                if (Math.abs(t - target) <= Math.abs(currentValue - target)) {
                    currentValue = t;
                }

                if(t < target) {
                    start++;
                } else if (t > target) {
                    end--;
                } else {
                    return t;
                }
            }
        }
        return currentValue;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int r1 = s.threeSumClosest(new int[]{-1,2,1,-4}, 1);
        System.out.println(r1);
    }
}
// @lc code=end