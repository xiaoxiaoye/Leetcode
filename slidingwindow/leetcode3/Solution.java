package leetcode.slidingwindow.leetcode3;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (32.15%)
 * Likes:    2821
 * Dislikes: 0
 * Total Accepted:    290K
 * Total Submissions: 902.2K
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();

        int left = 0;
        int right = 0;
        int maxLen = 0;
        Map<Character, Integer> window = new HashMap<>();
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0)+1);
            // if(window.get(c)>1){
            //     if(right-1-left > maxLen){
            //         maxLen = right-1-left;
            //     }
            // } else {
            //     if(right-left > maxLen){
            //         maxLen = right-left;
            //     }
            // }
            while(window.get(c) > 1){
                char d = s.charAt(left);
                left++;
                if(window.get(d) > 1) {
                    window.put(d, window.get(d)-1);
                } else {
                    window.remove(d);
                }
            }
            maxLen = Math.max(maxLen, right-left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.lengthOfLongestSubstring("au");
        System.out.println(r);
    }
}
// @lc code=end

