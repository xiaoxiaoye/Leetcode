package main

import (
	"math"
)

/*
 * @lc app=leetcode.cn id=7 lang=golang
 *
 * [7] 整数反转
 *
 * https://leetcode.cn/problems/reverse-integer/description/
 *
 * algorithms
 * Medium (35.39%)
 * Likes:    3810
 * Dislikes: 0
 * Total Accepted:    1.2M
 * Total Submissions: 3.3M
 * Testcase Example:  '123'
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：x = 123
 * 输出：321
 *
 *
 * 示例 2：
 *
 *
 * 输入：x = -123
 * 输出：-321
 *
 *
 * 示例 3：
 *
 *
 * 输入：x = 120
 * 输出：21
 *
 *
 * 示例 4：
 *
 *
 * 输入：x = 0
 * 输出：0
 *
 *
 *
 *
 * 提示：
 *
 *
 * -2^31
 *
 *
 */

// @lc code=start
func reverse(x int) int {
	isNegtive := x < 0
	revNum := 0
	for x != 0 {
		b := x % 10
		x = x / 10
		if isNegtive {
			if revNum < math.MinInt32/10 {
				return 0
			}
			if revNum == math.MinInt32/10 && b < math.MinInt32%10 {
				return 0
			}
		} else {
			if revNum > math.MaxInt32/10 {
				return 0
			}
			if revNum == math.MaxInt32 && b > math.MaxInt32%10 {
				return 0
			}
		}
		revNum = revNum*10 + b
	}
	return revNum
}

// @lc code=end

// func main() {
// 	fmt.Println(math.MaxInt32)
// 	fmt.Println(math.MinInt32 / 10)
// 	fmt.Println(math.MinInt32 % 10)
// 	fmt.Print(reverse(-1463847412))
// }
