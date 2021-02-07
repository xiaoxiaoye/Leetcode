package leetcode.array.leetcode54;

import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 *
 * https://leetcode-cn.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (37.80%)
 * Likes:    433
 * Dislikes: 0
 * Total Accepted:    70.7K
 * Total Submissions: 173.6K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return res;
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;

        while(left<=right && top<=bottom){
            for(int col=left; col<=right; col++){
                res.add(matrix[top][col]);
            }
            for(int row=top+1; row<=bottom; row++){
                res.add(matrix[row][right]);
            }

            // 条件判断用于 ， 最后只有一行或者一列的情况, 这样下面的遍历会导致多数据
            if(left<right && top<bottom){
                for(int col=right-1; col>=left; col--){
                    res.add(matrix[bottom][col]);
                }
    
                for(int row=bottom-1; row>=top+1; row--){
                    res.add(matrix[row][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return res;
    }
}
// @lc code=end
