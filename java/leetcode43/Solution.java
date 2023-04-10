package leetcode.leetcode43;

import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 *
 * https://leetcode-cn.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (40.94%)
 * Likes:    371
 * Dislikes: 0
 * Total Accepted:    70K
 * Total Submissions: 164.9K
 * Testcase Example:  '"2"\n"3"'
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
 * 示例 1:
 * 
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 
 * 示例 2:
 * 
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 
 * 说明：
 * 
 * 
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 
 * 
 */

import java.util.*;

// @lc code=start
class Solution {
    // 思路是采用竖式计算
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        List<String> middleNums = new LinkedList<>();

        // 补位0， 便于位计算
        int k = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            // 乘数
            int multiplier = num2.charAt(i) - '0';
            // 进位
            int carry = 0;

            StringBuilder s = new StringBuilder();
            for (int j = num1.length() - 1; j >= 0; j--) {
                int multiplicand = num1.charAt(j) - '0';
                int accum = multiplier * multiplicand + carry;
                s.append(accum % 10);
                carry = accum / 10;
            }
            if (carry > 0)
                s.append(carry);

            s = s.reverse();
            for (int j = 0; j < k; j++) {
                s.append('0');
            }
            k++;
            middleNums.add(s.reverse().toString());
        }

        int carry = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < middleNums.get(middleNums.size() - 1).length(); i++) {
            int sum = 0;

            for (String m : middleNums) {
                if (m.length() <= i)
                    continue;
                sum += m.charAt(i) - '0';
            }
            sum += carry;
            res.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0)
            res.append(carry);

        res = res.reverse();

        return res.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String r1 = s.multiply("123", "456");
        System.out.println(r1);
    }
}
// @lc code=end
