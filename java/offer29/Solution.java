package leetcode.offer29;

import java.util.Arrays;

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        int[] res = new int[nRow * nCol];
        int pos = 0;

        int left = 0;
        int right = nCol - 1;
        int up = 0;
        int down = nRow - 1;
        while (left <= right && up <= down) {
            // 上
            for (int j = left; j <= right; j++) {
                if (pos >= res.length) {
                    break;
                }
                res[pos++] = matrix[up][j];
            }

            // 右
            for (int i = up + 1; i <= down; i++) {
                if (pos >= res.length) {
                    break;
                }
                res[pos++] = matrix[i][right];
            }

            // 下
            for (int j = right - 1; j >= left; j--) {
                if (pos >= res.length) {
                    break;
                }
                res[pos++] = matrix[down][j];
            }

            // 左
            for (int i = down - 1; i > up; i--) {
                if (pos >= res.length) {
                    break;
                }
                res[pos++] = matrix[i][left];
            }

            left++;
            right--;
            up++;
            down--;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] r = s.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });
        System.out.println(Arrays.toString(r));
    }
}
