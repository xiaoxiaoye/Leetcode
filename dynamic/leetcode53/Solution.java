package leetcode.dynamic.leetcode53;

/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (48.31%)
 * Likes:    2167
 * Dislikes: 0
 * Total Accepted:    275.4K
 * Total Submissions: 532.8K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 
 * 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];

        int ans = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(sum < 0) {
                sum = nums[i];
                if(sum > ans) ans = sum;
                continue;
            }

            sum += nums[i];
            if(ans < sum) {
                ans = sum;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int r1 = s.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(r1);
    }

    
}
// @lc code=end

