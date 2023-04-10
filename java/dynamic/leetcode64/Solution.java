package leetcode.dynamic.leetcode64;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (63.43%)
 * Likes:    596
 * Dislikes: 0
 * Total Accepted:    128K
 * Total Submissions: 189.9K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 */

// @lc code=start
class Solution {
    private int minSum;
    public int minPathSum_(int[][] grid) {
        helper(grid, 0, 0, 0);
        return minSum;
    }

    private void helper(int[][] grid, int row, int col, int curSum){
        if(row == grid.length || col == grid[0].length) return;

        curSum+=grid[row][col];

        if(row == grid.length-1 && col == grid[0].length-1){
            if(minSum==0 || curSum<minSum) {
                minSum = curSum;
            }
            return;
        }

        if(row < grid.length){
            helper(grid, row+1, col, curSum);
        }
        if(col < grid[0].length){
            helper(grid, row, col+1, curSum);
        }
    }


    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;
        int[][] status = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                status[i][j] = grid[i][j];
            }
        }

        for (int i = 1; i < row; i++) {
            status[i][0] += status[i-1][0];
        }

        for (int i = 1; i < col; i++) {
            status[0][i] += status[0][i-1];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                status[i][j] += Math.min(status[i-1][j], status[i][j-1]);
            }
        }

        return status[row-1][col-1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] c = new int[][]{
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        int r = s.minPathSum(c);
        System.out.println(r);
    }
}
// @lc code=end


