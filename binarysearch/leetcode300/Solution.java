package leetcode.binarysearch.leetcode300;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (46.34%)
 * Likes:    1312
 * Dislikes: 0
 * Total Accepted:    200.1K
 * Total Submissions: 425.6K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7]
 * 的子序列。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10^4 
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 
 * 你可以设计时间复杂度为 O(n^2) 的解决方案吗？
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        return solveByBinarysearch(nums);
    }

    // 基于动态规划
    public int solveByDp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxLen = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                maxLen = Math.max(dp[i], maxLen);
            }
        }
        return maxLen;
    }

    // 基于贪心和二分
    public int solveByBinarysearch(int[] nums) {
        int len = 1;
        int[] dp = new int[nums.length + 1];
        dp[len] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
            } else {
                int pos = binarySearch(dp, 1, len, nums[i]);
                dp[pos] = nums[i];
            }
        }
        return len;
    }

    private int binarySearch(int[] nums, int begin, int end, int target) {
        int left = begin;
        int right = end;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (mid == begin || nums[mid - 1] < target)
                    return mid;
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // int r1 = s.solveByDp(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 });
        // System.out.println(r1);

        // int r2 = s.solveByDp(new int[] { 7, 7, 7, 7, 7, 7, 7 });
        // System.out.println(r2);

        // int r3 = s.solveByBinarysearch(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 });
        // System.out.println(r3);

        // int r4 = s.solveByBinarysearch(new int[] { 7, 7, 7, 7, 7, 7, 7 });
        // System.out.println(r4);

        int r5 = s.solveByBinarysearch(new int[] { 1, 2, -10, -8, -7 });
        System.out.println(r5);
    }
}
// @lc code=end
