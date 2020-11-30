package leetcode.leetcode215;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (59.65%)
 * Likes:    654
 * Dislikes: 0
 * Total Accepted:    184.1K
 * Total Submissions: 285.9K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 
 * 说明: 
 * 
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * 
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
       buildHeap(nums, k);

       for (int i = k; i < nums.length; i++) {
           if (nums[i] > nums[0]) {
               swap(nums, 0, i);
               heapify(nums, 0, k);
           }
       }

       return nums[0];
   }

   private void buildHeap(int[] nums, int k) {
       for (int i = k / 2 - 1; i >= 0; i--) {
           heapify(nums, i, k);
       }
   }

   private void heapify(int[] nums, int pos, int end) {
       int j = pos;
       while (true) {
           int minPos = j;
           if (j * 2 + 1 < end && nums[j * 2 + 1] < nums[minPos]) minPos = j * 2 + 1;
           if (j * 2 + 2 < end && nums[j * 2 + 2] < nums[minPos]) minPos = j * 2 + 2;

           if (minPos == j) break;
           swap(nums, j, minPos);
           j = minPos;
       }
   }

   private void swap(int[] nums, int i, int j) {
       int tmp = nums[i];
       nums[i] = nums[j];
       nums[j] = tmp;
   }
}

// @lc code=end