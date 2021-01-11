package leetcode.dynamic.leetcode32;

import java.util.Stack;

// https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/ 方法3
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    int len = i - stack.peek();
                    if (max < len) {
                        max = len;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int param1 = s.longestValidParentheses(")()())");
        System.out.println(param1);
    }
}