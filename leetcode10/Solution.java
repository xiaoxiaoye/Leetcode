package leetcode.leetcode10;

class Solution {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty())
            return text.isEmpty();
        boolean firstMatch = false;
        if (!text.isEmpty() && (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.')) {
            firstMatch = true;
        }

        // 回溯， 如果下个字符是*， 先尝试匹配0个，不行再尝试匹配一个
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return isMatch(text, pattern.substring(2))
            || firstMatch && isMatch(text.substring(1), pattern);
        } else {
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        boolean r1 = s.isMatch("aa", "a");
        System.out.println(r1);

        boolean r2 = s.isMatch("aa", "a.");
        System.out.println(r2);

        boolean r3 = s.isMatch("aaa", "a*");
        System.out.println(r3);
    }
}