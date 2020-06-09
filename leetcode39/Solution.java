package leetcode.leetcode39;

import java.util.*;
/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 *
 * https://leetcode-cn.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (67.49%)
 * Likes:    688
 * Dislikes: 0
 * Total Accepted:    96.8K
 * Total Submissions: 140.4K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 */

// @lc code=start
class Solution {
    // 存储最终结果
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> cm = new LinkedList<>();

        // 排序是为了减枝
        Arrays.sort(candidates);

        sum(candidates, target, 0, 0, cm);
        return result;
    }

    private void sum(int[] candidates, int target, int current, int index, LinkedList<Integer> cm) {
        if (current > target)
            return;

        if (current == target) {
            // 因为中间结果只有一份，这里需要使用副本，以免结果被覆盖
            result.add(new LinkedList<>(cm));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 如果加上下一个候选值大于目标值，则候选值后面的所有值都可以不用试了
            if ((current + candidates[i]) > target)
                return;

            cm.addLast(candidates[i]);
            sum(candidates, target, current + candidates[i], i, cm);
            cm.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<Integer>> r1 = s.combinationSum(new int[] { 2, 3, 5 }, 8);
        System.out.println(r1);
    }
}
// @lc code=end
