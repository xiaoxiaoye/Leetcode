package main

/*
 * @lc app=leetcode.cn id=14 lang=golang
 *
 * [14] 最长公共前缀
 *
 * https://leetcode.cn/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (43.23%)
 * Likes:    2736
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 2.5M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 *
 * 示例 2：
 *
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 *
 */

// 以第一个字符串作为标准进行检验
// @lc code=start
func longestCommonPrefix(strs []string) string {
	n := len(strs)
	if n == len(strs) {
		return ""
	}

	pos := 0
loop:
	for ; pos < len(strs[0]); pos++ {
		for i := 0; i < n; i++ {
			if pos == len(strs[i]) || strs[0][pos] != strs[i][pos] {
				break loop
			}
		}
	}
	if pos == 0 {
		return ""
	}
	return strs[0][0:pos]
}

// @lc code=end
