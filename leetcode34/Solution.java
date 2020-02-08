package leetcode.leetcode34;

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

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = searchFirst(nums, target);
        int last = searchLast(nums, target);
        return new int[]{first, last};
    }

    public int searchFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] >= target){
                if (nums[mid] == target){
                    if(mid == 0){
                        return mid;
                    } else if(mid - 1 >= 0 && nums[mid-1] < target){
                        return mid;
                    }
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int searchLast(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] <= target){
                if(nums[mid] == target){
                    if(mid == nums.length - 1){
                        return mid;
                    } else if(mid+1 <= nums.length-1 && nums[mid+1] > target){
                        return mid;
                    }
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int c1 = s.searchFirst(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(c1);
        int c2 = s.searchLast(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(c2);

        int[] cc1 = s.searchRange(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(Arrays.toString(cc1));

        int[] cc2 = s.searchRange(new int[]{6}, 6);
        System.out.println(Arrays.toString(cc2));
    }
}