package leetcode.leetcode125;

/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (41.67%)
 * Likes:    258
 * Dislikes: 0
 * Total Accepted:    146.7K
 * Total Submissions: 319.1K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1:
 * 
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "race a car"
 * 输出: false
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }

            if (s.charAt(start) != s.charAt(end)) return false;

            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String  c1 = "A man, a plan, a canal: Panama";
        boolean r1 = s.isPalindrome(c1);
        System.out.println(r1);

        String  c2 = "race a car";
        boolean r2 = s.isPalindrome(c2);
        System.out.println(r2);
    }
}
// @lc code=end

