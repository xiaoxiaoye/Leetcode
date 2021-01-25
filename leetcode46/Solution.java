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
    private ArrayList<Integer> route;
    public List<List<Integer>> permute(int[] nums) {
        route = new ArrayList<>(nums.length);
        List<List<Integer>> results = new LinkedList<>();
        backtrack(nums, results);
        return results;
    }

    public void backtrack(int[] nums, List<List<Integer>> results){
        if(route.size() == nums.length){
            results.add(new LinkedList<>(route));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(route.contains(nums[i])) continue;
            route.add(nums[i]);
            backtrack(nums, results);
            route.remove(route.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        
        List<List<Integer>> r1 = s.permute(new int[]{1,2,3});
        System.out.println(r1);
    }
}
// @lc code=end

