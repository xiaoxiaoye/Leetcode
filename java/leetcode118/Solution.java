package leetcode.leetcode118;


/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 *
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (64.97%)
 * Likes:    327
 * Dislikes: 0
 * Total Accepted:    89.2K
 * Total Submissions: 133.6K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 5
 * 输出:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 */

import java.util.*;

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        if (numRows == 0) return res;

        res.add(new ArrayList<>());
        res.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = res.get(i-1);
            List<Integer> cur = new ArrayList<>(i+1);
            cur.add(1);
            for (int j = 1; j < i; j++) {
                cur.add(prev.get(j-1) + prev.get(j));
            }
            cur.add(1);

            res.add(cur);
        }
        return res;
    }
}
// @lc code=end

