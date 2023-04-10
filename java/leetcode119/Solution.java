package leetcode.leetcode119;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 *
 * https://leetcode-cn.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (59.07%)
 * Likes:    166
 * Dislikes: 0
 * Total Accepted:    62.3K
 * Total Submissions: 101.3K
 * Testcase Example:  '3'
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出: [1,3,3,1]
 * 
 * 
 * 进阶：
 * 
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * 
 */

import java.util.*;

// @lc code=start
class Solution {
    // 从前往后加
    public List<Integer> getRow_(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<>(rowIndex+1);

        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 0; j < i-1; j++) {
                res.set(j, res.get(j) + res.get(j+1));
            }
            res.add(0,1);
        }

        return res;
    }

    // 从后往前加, 可以避免数组移动
    public List<Integer> getRow(int rowIndex) {
        Integer[] res  = new Integer[rowIndex+1];
        
        res[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            res[i] = 1;
            for (int j = i-1; j > 0; j--) {
                res[j] = res[j] + res[j-1];
            }
        }
        return Arrays.asList(res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        List<Integer> r1 = s.getRow_(5);
        System.out.println(r1);
    }
}
// @lc code=end

