package leetcode.leetcode47;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (55.95%)
 * Likes:    333
 * Dislikes: 0
 * Total Accepted:    68K
 * Total Submissions: 114.6K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */

import java.util.*;

// @lc code=start
class Solution {
    // Map<Integer, Boolean> map = new HashMap<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();

        if(nums.length == 0) {
            return result;
        }
        
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, nums.length, 0, used, path, result);
        return result;
    }

    // private void help(int[] nums, LinkedList<Integer> tmp) {
    //     if(tmp.size() == nums.length) {
    //         result.add(new LinkedList<>(tmp));
    //         tmp.remove(new Integer(nums[nums.length-1]));
    //         return;
    //     }

    //     for (int i = 0; i < nums.length; i++) {
    //         if(map.containsKey(i)) continue;
    //         if(i > 0 && nums[i] == nums[i-1]) continue;
    //         tmp.add(nums[i]);
    //         map.put(i, true);
    //         help(nums, tmp);
    //         tmp.remove(new Integer(nums[i]));
    //         map.remove(i);
    //     }
    // }

    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if(len == depth) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if(used[i]) continue;

            // * 树的纵向相等是可以的， 代表path路径。而横向相等是不行的， 代表子树重复，需要剪枝。
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;

            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, len, depth+1, used, path, res);

            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,2};
        
        List<List<Integer>> r1 = s.permuteUnique(nums);
        System.out.println(r1);
    }
}
// @lc code=end

