package leetcode.binarysearch.leetcode33;

/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (36.21%)
 * Likes:    457
 * Dislikes: 0
 * Total Accepted:    62.8K
 * Total Submissions: 173.4K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low + ((high-low)>>1);

            if(nums[mid] == target){
                return mid;
            }

            // 左边有序
            if(nums[low] <= nums[mid]){
                if(nums[low]<= target && target < nums[mid]){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else { // 右边有序
                if(nums[mid]<target && target<=nums[high]){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }

        return -1;
    }
}
// @lc code=end

