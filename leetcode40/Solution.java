package leetcode.leetcode40;

import java.util.*;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (58.66%)
 * Likes:    278
 * Dislikes: 0
 * Total Accepted:    60.3K
 * Total Submissions: 97.7K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> cm = new LinkedList<>();

        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, cm);
        return result;
    }

    private void dfs(int[] candidates, int target, int current, int index, LinkedList<Integer> cm) {
        if(current > target) return;

        if(current == target) {
            result.add(new LinkedList<Integer>(cm));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if((current+candidates[i]) > target) break;

            // 和上一个候选项一样的话，直接过滤掉
            if(i > index && candidates[i] == candidates[i-1]) continue;

            cm.addLast(candidates[i]);
            dfs(candidates, target, current+candidates[i],i+1, cm);
            cm.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> r1 = s.combinationSum2(new int[]{2,5,2,1,2}, 5);
        System.out.println(r1);
    }
}
// @lc code=end

