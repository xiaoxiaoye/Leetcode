package main

/*
 * @lc app=leetcode.cn id=22 lang=golang
 *
 * [22] 括号生成
 *
 * https://leetcode.cn/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (77.50%)
 * Likes:    3198
 * Dislikes: 0
 * Total Accepted:    688.1K
 * Total Submissions: 888K
 * Testcase Example:  '3'
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 *
 * 示例 2：
 *
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= n <= 8
 *
 *
 */

// 回溯法
// @lc code=start
func generateParenthesis(n int) []string {
	results := make([]string, 0)
	backtrack(&results, "", 0, 0, n)
	return results
}

func backtrack(results *[]string, cur string, l, r, n int) {
	if len(cur) == n*2 {
		*results = append(*results, cur)
		return
	}
	if l < n {
		backtrack(results, cur+"(", l+1, r, n)
	}

	if r < l {
		backtrack(results, cur+")", l, r+1, n)
	}
}

// @lc code=end
