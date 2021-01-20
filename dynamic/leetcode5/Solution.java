package leetcode.dynamic.leetcode5;

/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.75%)
 * Likes:    1847
 * Dislikes: 0
 * Total Accepted:    202.2K
 * Total Submissions: 700.7K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */

// @lc code=start
public class Solution {
    public String longestPalindrome(String s){
        return longestPalindrome_center(s);
    }
    // 暴力求解
    public String longestPalindrome_violence(String s) {
        if(s.length()<2) return s;

        int begin=0;
        int maxLen = 1;
        char[] arrayString = s.toCharArray();
        for (int i = 0; i < arrayString.length; i++) {
            for(int j = i+1; j<arrayString.length; j++){
                if(isPalindrome(arrayString, i, j)){
                    int len = j-i+1;
                    if(len>maxLen){
                        begin=i;
                        maxLen = len;
                    }
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }

    private boolean isPalindrome(char[] s, int begin, int end){
        for(int i=begin,j=end;i<=j;i++,j--){
            if(s[i] != s[j]) return false;
        }
        return true;
    }


    // 动态规划求解
    public String longestPalindrome_dp(String s) {
        if(s.length()<2) return s;

        int begin = 0;
        int maxLen = 1;
        char[] arrayString = s.toCharArray();

        boolean[][] dp = new boolean[arrayString.length][arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            dp[i][i]=true;
        }

        for (int j = 1; j < arrayString.length; j++) {
            for (int i = 0; i < j; i++) {
                if(arrayString[i] != arrayString[j]){
                    dp[i][j]=false;
                } else {
                    if(j-i<3){
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && j-i+1>maxLen){
                    begin = i;
                    maxLen = j-i+1;
                }
            }
        }

        return s.substring(begin, begin+maxLen);
    }


    // 中心扩散法
    public String longestPalindrome_center(String s){
        if(s.length() < 2) return s;

        String maxStr = "";
        for (int i = 0; i < s.length()-1; i++) {
            // 奇数串
            String oddStr = centerExpand(s, i, i);
            // 偶数串
            String evenStr = centerExpand(s, i, i+1);
            String max = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if(max.length() > maxStr.length()){
                maxStr = max;
            }
        }
        return maxStr;
    }

    private String centerExpand(String s, int i, int j){
        if(s.charAt(i) != s.charAt(j)) return "";
        while(i>=0 && j<s.length()){
            if(s.charAt(i) != s.charAt(j)){
                break;
            }
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("ccd"));
    }
}
// @lc code=end