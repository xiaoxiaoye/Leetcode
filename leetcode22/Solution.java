package leetcode.leetcode22;

import java.util.*;
/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (72.51%)
 * Likes:    943
 * Dislikes: 0
 * Total Accepted:    114.8K
 * Total Submissions: 152.6K
 * Testcase Example:  '3'
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：n = 3
 * 输出：[
 * ⁠      "((()))",
 * ⁠      "(()())",
 * ⁠      "(())()",
 * ⁠      "()(())",
 * ⁠      "()()()"
 * ⁠    ]
 * 
 * 
 */

// @lc code=start
class Solution {
    List<String> ret = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        dfs("", n, n);
        return ret;
    }

    private void dfs(String p, int left, int right){
        if(left == 0 && right == 0){
            // if(isValid(p)){
            //     ret.add(p);
            // }

            // 只要先添加左括号，而且保证添加过程中，左括号的数量多于右括号，就一定是有效的
            ret.add(p);
            return;
        }
        if(left>right){
            return;
        }

        if(left != 0){
            dfs(p+"(", left-1, right);
        }
        if (right != 0){
            dfs(p+")", left, right-1);
        }
    }

    public boolean isValid(String p){
        char[] ps = p.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : ps) {
            if(c == '('){
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                char tmp = stack.pop();
                if(tmp != '('){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean r = s.isValid("((()))");
        System.out.println(r);

        List<String> r1 = s.generateParenthesis(3);
        System.out.println(r1);
    }
}
// @lc code=end

