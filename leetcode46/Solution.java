package leetcode.leetcode46;

import java.util.*;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (72.98%)
 * Likes:    764
 * Dislikes: 0
 * Total Accepted:    146.4K
 * Total Submissions: 191.9K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    Map<Integer, Boolean> map = new HashMap<>();
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        help(nums, new LinkedList<>());
        return result;
    }

    private void help(int[] nums, LinkedList<Integer> tmp) {
        if(tmp.size() == nums.length) {
            result.add(new LinkedList<>(tmp));
            tmp.removeLast();
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) continue;
            tmp.add(nums[i]);
            map.put(nums[i], true);
            help(nums, tmp);
            tmp.remove(new Integer(nums[i]));
            map.remove(nums[i]);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        
        List<List<Integer>> r1 = s.permute(new int[]{1,2,3});
        System.out.println(r1);
    }
}
// @lc code=end

