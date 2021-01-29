package leetcode.binarysearch.leetcode34;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (38.25%)
 * Likes:    275
 * Dislikes: 0
 * Total Accepted:    51.6K
 * Total Submissions: 134.6K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 
 * 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 
 */

// @lc code=start
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        int first = searchFirst(nums, target);
        // 左边界没有搜索到，说明数组中没有这个元素，可以直接返回，不用搜索右边界了
        if(first == -1) return new int[]{-1,-1};
        int last = searchLast(nums, target);
        return new int[]{first, last};
    }

    public int searchFirst(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            } else if (nums[mid]>target){
                right = mid-1;
            } else {
                right=mid-1; //向左收缩
            }
        }
        if(left>=nums.length || nums[left] != target) return -1;
        // 收缩右边界，可以返回right+1， for循环终结的区间是[right+1, right], left=right+1
        return left;
    }

    public int searchLast(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            } else if (nums[mid]>target){
                right = mid-1;
            } else {
                left = mid+1; //向右收缩
            }
        }
        if(right<0 || nums[right] != target) return -1;
        return right;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int c1 = s.searchFirst(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(c1);
        int c2 = s.searchLast(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(c2);

        int[] cc1 = s.searchRange(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(Arrays.toString(cc1));

        int[] cc2 = s.searchRange(new int[]{2,2}, 3);
        System.out.println(Arrays.toString(cc2));
    }
}
// @lc code=end