package leetcode.leetcode88;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (45.90%)
 * Likes:    573
 * Dislikes: 0
 * Total Accepted:    181.9K
 * Total Submissions: 377.4K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 
 * 
 * 
 * 示例:
 * 
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 */

// @lc code=start
class Solution {
    public void merge_(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if (n == 0) return;

        int n1 = m-1;
        int n2 = n-1;
        for(int i=m+n-1; i>=0; i--) {
            if(n1 < 0) {
                nums1[i] = nums2[n2--];
                continue;
            }
            if (n2 < 0) {
                nums1[i] = nums1[n1--];
                continue;
            }

            if (nums1[n1] >= nums2[n2]) {
                nums1[i] = nums1[n1--];
            } else {
                nums1[i] = nums2[n2--];
            }
        }
    }

    // 官方简单写法
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m-1;
        int n2 = n-1;

        int p = m+n-1;
        while(n1>=0 && n2>=0) {
            nums1[p--] = nums1[n1] >= nums2[n2] ? nums1[n1--] : nums2[n2--];
        }

        System.arraycopy(nums2, 0, nums1, 0, n2+1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = new int[]{1,2,3,0,0,0};
        s.merge(nums1, 3, new int[]{2,5,6}, 3);

        System.out.println(Arrays.toString(nums1));
    }
}
// @lc code=end
