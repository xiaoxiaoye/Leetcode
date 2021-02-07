package leetcode.dynamic.leetcode1143;

/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 *
 * https://leetcode-cn.com/problems/longest-common-subsequence/description/
 *
 * algorithms
 * Medium (60.69%)
 * Likes:    356
 * Dislikes: 0
 * Total Accepted:    66.5K
 * Total Submissions: 109.2K
 * Testcase Example:  '"abcde"\n"ace"'
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * 
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde"
 * 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * 
 * 若这两个字符串没有公共子序列，则返回 0。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入：text1 = "abcde", text2 = "ace" 
 * 输出：3  
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 
 * 
 * 示例 3:
 * 
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequenceByRecur(text1, text2);
    }

    // 基于动态规划
    public int longestCommonSubsequenceByDP(String text1, String text2){
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }


    // 基于递归加mem
    private int[][] mem;
    public int longestCommonSubsequenceByRecur(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        mem = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mem[i][j] = -1;
            }
        }

        return dp(s1, 0, s2, 0);
    }

    private int dp(String s1, int p1, String s2, int p2){
        if(p1 == s1.length() || p2 == s2.length()) return 0;

        if(mem[p1][p2] != -1) return mem[p1][p2];

        int len = 0;
        if(s1.charAt(p1) == s2.charAt(p2)){
            len = dp(s1, p1+1, s2, p2+1)+1;
        } else {
            len = Math.max(dp(s1, p1, s2, p2+1), dp(s1, p1+1, s2, p2));
        }
        mem[p1][p2] = len;
        return len;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.longestCommonSubsequenceByRecur("abcde", "ace");
        System.out.println(r);

        int n = '1';
        System.out.println(n);
    }
}
// @lc code=end

