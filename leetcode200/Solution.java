package leetcode.leetcode200;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 参考:
 * https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/
 */
class Solution {
    // BFS 广度优先遍历
    public int numIslandsBFS(char[][] grid) {
        if (grid.length == 0)
            return 0;
        int nl = grid.length; // 行
        int nr = grid[0].length; // 列
        int res = 0;
        for (int i = 0; i < nl; i++) {
            for (int j = 0; j < nr; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    res++;
                    Deque<Integer> deque = new LinkedList<>();
                    deque.add(i * nr + j);
                    while (!deque.isEmpty()) {
                        int pos = deque.pop();
                        System.out.println(pos);
                        int l = pos / nr;
                        int r = pos % nr;
                        // grid[l][r] = '0';
                         // 向左
                        if (r - 1 >= 0 && grid[l][r - 1] == '1'){
                            deque.add(l * nr + r - 1);
                            grid[l][r-1] = '0'; //所有加入队列的结点，都应该马上被标记为 “已经访问”，否则有可能会被重复加入队列。
                        }
                        // 向右
                        if (r + 1 < nr && grid[l][r + 1] == '1'){
                            deque.add(l * nr + r + 1);
                            grid[l][r+1] = '0';
                        }
                        // 向下
                        if (l + 1 < nl && grid[l + 1][r] == '1'){
                            deque.add((l + 1) * nr + r);
                            grid[l+1][r] = '0';
                        }
                        // 向上
                        if (l - 1 >= 0 && grid[l - 1][r] == '1'){
                            deque.add((l - 1) * nr + r);
                            grid[l-1][r] = '0';
                        }
                    }
                }
            }
        }
        return res;
    }

    // DFS深度优先遍历
    public int numIslandsDFS(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rowNums = grid.length;
        int colNums = grid[0].length;
        int res = 0;
        for(int i = 0; i < rowNums; i++){
            for(int j = 0; j < colNums; j++){
                if(grid[i][j] == '1'){
                    res++;
                    grid[i][j] = '0';
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid, int row, int col){
        int rowNums = grid.length;
        int colNums = grid[0].length;
        // 向上
        if(row-1 >= 0 && grid[row-1][col] == '1'){
            grid[row-1][col] = '0';
            dfs(grid, row-1, col);
        }
        // 向下
        if(row+1 < rowNums && grid[row+1][col] == '1'){
            grid[row+1][col] = '0';
            dfs(grid, row+1, col);
        }

        // 向左
        if(col-1 >= 0 && grid[row][col-1] == '1'){
            grid[row][col-1] = '0';
            dfs(grid, row, col-1);
        }

        // 向右
        if(col+1 < colNums && grid[row][col+1] == '1'){
            grid[row][col+1] = '0';
            dfs(grid, row, col+1);
        }
    }

    public int numIslands(char[][] grid) {
        return numIslandsDFS(grid);
    }



    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println("=========================");
        char[][] graph = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0',
        '1', '0' },
        { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
        int r = s.numIslands(graph);
        System.out.println(r);
        System.out.println("=========================");

        char[][] graph1 = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1',
        '0', '0', '0' },
        { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };
        int r1 = s.numIslands(graph1);
        System.out.println(r1);
        System.out.println("=========================");

        char[][] graph2 = new char[][] { { '1', '1', '1' }, { '0', '1', '0' }, { '1', '1', '1' } };
        int r2 = s.numIslands(graph2);
        System.out.println(r2);
    }
}