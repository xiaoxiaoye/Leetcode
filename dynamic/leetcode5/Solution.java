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
    public String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > (end - start + 1)) {
                // 这里为什么是(len -1)有点不太好理解， 可以写个数列，试着算一下
                // 0, 1, 2, 3, 4
                // 如果i=1, 以1，2为中心扩展， len=4. start=1-4/2=-1, end=1+4/2=3. 
                start = i - (len - 1) / 2;
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int begin, int end) {
        int left = begin;
        int right = end;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return right - left - 1;
    }
}
// @lc code=end