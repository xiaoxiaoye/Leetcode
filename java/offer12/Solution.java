package leetcode.offer12;

class Solution {

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        int nRow = board.length;
        int nCol = board[0].length;
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                if (dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, int pos, String word) {
        int nRow = board.length;
        int nCol = board[0].length;

        if (row < 0 || row >= nRow || col < 0 || col >= nCol || board[row][col] != word.charAt(pos)) {
            return false;
        }
        if (pos == word.length() - 1) {
            return true;
        }
        board[row][col] = '\0';
        boolean res = dfs(board, row - 1, col, pos + 1, word) || dfs(board, row + 1, col, pos + 1, word)
                || dfs(board, row, col - 1, pos + 1, word) || dfs(board, row, col+1, pos + 1, word);
        board[row][col] = word.charAt(pos);
        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean r = s.exist(board, "ABCCED");
        System.out.println(r);
    }
}
