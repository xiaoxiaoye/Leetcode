package leetcode.leetcode52;

import java.util.*;

/**
 * 八皇后问题 https://leetcode-cn.com/problems/n-queens/
 */
class Solution {

    int count;
    public int totalNQueens(int n) {
        // 用于保存放置结果
        int[] result = new int[n];
        solveNQueensRecur(n, 0, result);
        return count;
    }

    void solveNQueensRecur(int n, int row, int[] result) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isOK(n, row, i, result)) {
                result[row] = i;
                solveNQueensRecur(n, row + 1, result);
            }
        }
    }

    boolean isOK(int n, int row, int col, int[] result) {
        int left = col - 1;
        int right = col + 1;
        for (int i = row - 1; i >= 0; i--) {
            // 左对角
            if (left >= 0 && result[i] == left) {
                return false;
            }
            // 右对角
            if (right < n && result[i] == right) {
                return false;
            }
            // 向上
            if (result[i] == col) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalNQueens(5));
        System.out.println(s.totalNQueens(6));
        System.out.println(s.totalNQueens(7));
        System.out.println(s.totalNQueens(8));
        System.out.println(s.totalNQueens(9));
    }
}