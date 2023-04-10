package leetcode.array.leetcode78;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (79.53%)
 * Likes:    1009
 * Dislikes: 0
 * Total Accepted:    199K
 * Total Submissions: 250.3K
 * Testcase Example:  '[1,2,3]'
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10 
 * nums 中的所有元素 互不相同
 * 
 * 
 */
import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        LinkedList<Integer> route = new LinkedList<>();
        helper(nums, 0, route, results);
        return results;
    }

    private void helper(int[] nums, int pos, LinkedList<Integer> route, List<List<Integer>> results) {
        if (pos == nums.length) {
            results.add(new LinkedList<>(route));
            return;
        }

        // 不选第i个元素
        helper(nums, pos + 1, route, results);

        // 选第i个元素
        route.add(nums[pos]);
        helper(nums, pos + 1, route, results);
        route.removeLast();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> r1 = s.subsets(new int[] { 1, 2, 3 });
        System.out.println(r1);
    }
}
// @lc code=end
