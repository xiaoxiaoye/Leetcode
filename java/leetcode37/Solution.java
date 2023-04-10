package leetcode.leetcode37;

/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 *
 * https://leetcode-cn.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (58.31%)
 * Likes:    391
 * Dislikes: 0
 * Total Accepted:    25.5K
 * Total Submissions: 41.8K
 * Testcase Example:  '
 * [
 *  ["5","3",".",".","7",".",".",".","."],
 *  ["6",".",".","1","9","5",".",".","."],
 *  [".","9","8",".",".",".",".","6","."],
 *  ["8",".",".",".","6",".",".",".","3"],
 *  ["4",".",".","8",".","3",".",".","1"],
 *  ["7",".",".",".","2",".",".",".","6"],
 *  [".","6",".",".",".",".","2","8","."],
 *  [".",".",".","4","1","9",".",".","5"],
 *  [".",".",".",".","8",".",".","7","9"]
 * ]'
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * 
 * 一个数独的解法需遵循如下规则：
 * 
 * 
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 
 * 
 * 空白格用 '.' 表示。
 * 
 * 
 * 
 * 一个数独。
 * 
 * 
 * 
 * 答案被标成红色。
 * 
 * Note:
 * 
 * 
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * 
 */

// @lc code=start
class Solution {
    int[][] rows = new int[9][10];
    int[][] cols = new int[9][10];
    int[][] boxs = new int[9][10];

    boolean findFlag = false;

    char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;

        // 预处理
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int number = Character.getNumericValue(board[i][j]);
                    placeNumber(i, j, number);
                }
            }
        }
        backTrace(0, 0);
    }

    private void backTrace(int row, int col) {
        if (col == 9) {
            col = 0;
            row++;
        }

        while (row < 9 && board[row][col] != '.') {
            col++;
            if (col == 9) {
                col = 0;
                row++;
            }
        }

        if (row == 9) {
            findFlag = true;
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (canPlace(row, col, i)) {
                placeNumber(row, col, i);
                backTrace(row, col + 1);
                if (!findFlag) {
                    removeNumber(row, col, i);
                }
            }
        }
    }

    private void placeNumber(int row, int col, int number) {
        int boxIndex = row / 3 * 3 + col / 3;
        boxs[boxIndex][number]++;
        rows[row][number]++;
        cols[col][number]++;
        board[row][col] = (char) ('0' + number);
    }

    private void removeNumber(int row, int col, int number) {
        int box = row / 3 * 3 + col / 3;
        boxs[box][number]--;
        rows[row][number]--;
        cols[col][number]--;
        board[row][col] = '.';
    }

    private boolean canPlace(int row, int col, int number) {
        int box = row / 3 * 3 + col / 3;
        return boxs[box][number] + rows[row][number] + cols[col][number] == 0;
    }
}
// @lc code=end
