package leetcode.stack.leetcode224;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=224 lang=java
 *
 * [224] 基本计算器
 *
 * https://leetcode-cn.com/problems/basic-calculator/description/
 *
 * algorithms
 * Hard (36.09%)
 * Likes:    235
 * Dislikes: 0
 * Total Accepted:    17.1K
 * Total Submissions: 44.9K
 * Testcase Example:  '"1 + 1"'
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * 
 * 示例 1:
 * 
 * 输入: "1 + 1"
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 
 * 示例 3:
 * 
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * 
 * 说明：
 * 
 * 
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * 
 * 
 */

// @lc code=start
class Solution {
    private Set<Character> nums = new HashSet<>();

    public int calculate(String s) {
        for (int i = 0; i < 10; i++) {
            nums.add((char) (i + '0'));
        }
        s = s.trim();

        LinkedList<Character> arrList = new LinkedList<>();
        for(char c : s.toCharArray()){
            arrList.add(c);
        }
        return helper(arrList);
    }

    private int helper(LinkedList<Character> arrList){
        LinkedList<Integer> stack = new LinkedList<>();

        char sign = '+';
        int num = 0;

        while(!arrList.isEmpty()){
            char c = arrList.removeFirst();
            if (nums.contains(c)) {
                num = num * 10 + (c - '0');
            }
            if(c == '('){
                num = helper(arrList);
            }

            if (c != ' ' && (!nums.contains(c) || arrList.isEmpty())) {
                if (sign == '+') {
                    stack.addLast(num);
                } else if (sign == '-') {
                    stack.addLast(-num);
                } else if (sign == '*') {
                    int pre = stack.removeLast();
                    stack.add(pre * num);
                } else if (sign == '/') {
                    int pre = stack.removeLast();
                    stack.add(pre / num);
                }

                if(c==')'){
                    break;
                }

                num = 0;
                sign = c;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.removeLast();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int r1 = s.calculate(" 1 - 1 ");
        // System.out.println(r1);
        int r2 = s.calculate("1+(( 1 - 2 )+2)*3");
        System.out.println(r2);
        // int r3 = s.calculate("1 + 1 - 2/3");
        // System.out.println(r3);
    }
}
// @lc code=end
