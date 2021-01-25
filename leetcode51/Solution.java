package leetcode.leetcode51;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (73.52%)
 * Likes:    727
 * Dislikes: 0
 * Total Accepted:    98.8K
 * Total Submissions: 134.3K
 * Testcase Example:  '4'
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 
 * 
 * 
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：[["Q"]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    private List<List<String>> results = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n==0) return Collections.emptyList();
        List<String> result = new LinkedList<>();
        backTrace(result, n);
        return results;
    }

    private void backTrace(List<String> result, int n){
        if(result.size() == n){
            results.add(new LinkedList<>(result));
        }

        for (int i = 0; i < n; i++) {
            if(isValid(n, result.size(), i, result)){
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if(j == i){
                        builder.append("Q");
                        continue;
                    }
                    builder.append(".");
                }
                String line = builder.toString();
                result.add(line);
                backTrace(result, n);
                result.remove(line);
            }
        }
    }

    public boolean isValid(int n, int row, int col, List<String> currents){
        if(currents.isEmpty()) return true;
        for (String line : currents) {
            if(line.charAt(col) == 'Q'){
                return false;
            }
        }

        for(int i=col-1, j=row-1; i>=0 && j>=0; i--,j--){
            if(currents.get(j).charAt(i) == 'Q'){
                return false;
            }
        }

        for(int i=col+1,j=row-1; i<n&&j>=0; i++,j--){
            if(currents.get(j).charAt(i) == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> r = s.solveNQueens(4);
        System.out.println(r);
    }

}
// @lc code=end
