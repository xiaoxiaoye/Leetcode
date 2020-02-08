package leetcode.leetcode51;

import java.util.*;

/**
 * 八皇后问题 https://leetcode-cn.com/problems/n-queens/
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        // 用于保存放置结果
        int[] result = new int[n];
        solveNQueensRecur(n, 0, result, res);
        return res;
    }

    void solveNQueensRecur(int n, int row, int[] result, List<List<String>> res) {
        if (row == n) {
            List<String> q = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == result[i]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                q.add(sb.toString());
            }
            res.add(q);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isOK(n, row, i, result)) {
                result[row] = i;
                solveNQueensRecur(n, row + 1, result, res);
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

    void printResult(List<List<String>> queens) {
        for (int i = 0; i < queens.size(); i++) {
            List<String> queen = queens.get(i);
            for (int j = 0; j < queen.size(); j++) {
                System.out.println(queen.get(j));
            }
            System.out.println("=====================");
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> r1 = s.solveNQueens(4);
        s.printResult(r1);
    }
}