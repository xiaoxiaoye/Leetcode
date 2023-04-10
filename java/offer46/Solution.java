package leetcode.offer46;

import java.util.Arrays;

public class Solution {
    /**
     * 通过求余的形式，从后往前求解
     * 利用动态规划求解，
     * f(i) = f(i-1)+f(i-2), 如果x[i-1]x[i]可整体被翻译
     * f(i) = f(i-1), 如果x[i-1]x[i]不可整体被翻译
     */
    public int translateNum(int num) {
        int a = 1;
        int b = 1;
        int x;
        int y = num % 10;
        while (num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = x * 10 + y;
            // 例如500， 连续的0只能被单独翻译为'a'
            int c = tmp >= 10 && tmp <= 25 ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.translateNum(12);
        System.out.println(r);

        int[][] a = new int[][]{
                {1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}
        };
        long c = Arrays.stream(a).filter(arr->arr[0]==1).count();
        System.out.println(c);
    }
}
