package leetcode.leetcode3;

import java.util.*;

/**
 * 题解参考： https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        for (; j < s.length();) {
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int r1 = s.lengthOfLongestSubstring("abcabcbb");
        System.out.println(r1);
        int r2 = s.lengthOfLongestSubstring("bbbbb");
        System.out.println(r2);
        int r3 = s.lengthOfLongestSubstring("pwwkew");
        System.out.println(r3);
    }
}