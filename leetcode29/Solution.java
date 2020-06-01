package leetcode.leetcode29;

/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 *
 * https://leetcode-cn.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (18.90%)
 * Likes:    229
 * Dislikes: 0
 * Total Accepted:    28.1K
 * Total Submissions: 148.9K
 * Testcase Example:  '10\n3'
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 
 * 示例 1:
 * 
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 
 * 说明:
 * 
 * 
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 1) return dividend;
        if(divisor == -1){
            if(dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }

        boolean sign = (dividend > 0) ^ (divisor > 0);

        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        int ret = helper(dividend, divisor);
        return sign ? -ret : ret;
    }

   private int helper(int dividend, int divisor){
        if(dividend > divisor) return 0;
        int count = 1;
        int tb = divisor;

        while((tb+tb) >= dividend && tb+tb < 0){ // 如果tb+tb溢出， 则不再小于0
            tb = tb+tb;
            count = count + count;
        }

        return count + helper(dividend - tb, divisor);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int r1 = s.divide(10, 3);
        System.out.println(r1);

        int r2 = s.divide(7, -3);
        System.out.println(r2);


        System.out.println(Integer.MIN_VALUE - 1);
    }
}
// @lc code=end
