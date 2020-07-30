package leetcode.leetcode42;

import java.util.*;
/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (47.33%)
 * Likes:    1339
 * Dislikes: 0
 * Total Accepted:    107.5K
 * Total Submissions: 210.1K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */


// @lc code=start
class Solution {

    // 单调递减栈
    public int trap_stack(int[] height) {
        if(height.length <= 2) return 0;
        int sum = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.lastElement()]) {
                int top = stack.pop();

                if(stack.isEmpty()){
                    continue;
                }
                int distance = i - stack.lastElement() - 1;
                int capHeight = Math.min(height[stack.lastElement()], height[i]) - height[top];
                sum += distance * capHeight;
            }

            stack.add(i);
        }

        return sum;
    }

    // 双指针
    public int trap(int[] height) {
        if(height.length <= 2) return 0;
        int sum = 0;

        int left = 0, left_max = 0;
        int right = height.length - 1, right_max = 0;

        while(left < right) {
            if(height[left] < height[right]) {
                if(height[left] >= left_max) {
                    left_max = height[left++];
                } else {
                    sum += left_max - height[left++];
                }
            } else {
                if(height[right] >= right_max) {
                    right_max = height[right--];
                } else {
                    sum += right_max - height[right--];
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int r1 = s.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(r1);
    }
}
// @lc code=end