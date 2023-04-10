package leetcode.offer13;

public class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] matrix = new boolean[m][n];
        return dfs(matrix, 0, 0, k);
    }

    private int dfs(boolean[][] matrix, int m, int n, int k) {
        if (m >= matrix.length || n >= matrix[0].length || matrix[m][n]) {
            return 0;
        }
        if (bitSum(m) + bitSum(n) > k) {
            return 0;
        }
        matrix[m][n] = true;
        return dfs(matrix, m + 1, n, k) + dfs(matrix, m, n + 1, k) + 1;
    }

    private int bitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
