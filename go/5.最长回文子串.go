package main

import "fmt"

/*
 * @lc app=leetcode.cn id=5 lang=golang
 *
 * [5] 最长回文子串
 *
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (37.50%)
 * Likes:    6385
 * Dislikes: 0
 * Total Accepted:    1.4M
 * Total Submissions: 3.7M
 * Testcase Example:  '"babad"'
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 *
 * 示例 2：
 *
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 *
 */

func longestPalindrome_(s string) string {
	n := len(s)
	if n < 2 {
		return s
	}

	dp := make([][]bool, n)
	// 单个字符都是回文子串
	for i := 0; i < n; i++ {
		dp[i] = make([]bool, n)
		dp[i][i] = true
	}

	maxLen := 1
	begin := 0
	for L := 2; L <= n; L++ {
		for i := 0; i < n; i++ {
			j := i + L - 1
			if j >= n {
				break
			}
			if s[i] != s[j] {
				dp[i][j] = false
			} else {
				// i和j的中间只有一个字符，j-i+1<=3 等同于j-i+1<4，即j-i<3
				if j-i < 3 {
					dp[i][j] = true
				} else {
					dp[i][j] = dp[i+1][j-1]
				}
			}
			// s[i:j+1]是回文子串，且长度大于记录的最大长度
			if dp[i][j] && j-i+1 > maxLen {
				begin = i
				maxLen = j - i + 1
			}
		}
	}

	return s[begin : begin+maxLen]
}

// @lc code=start
// 采用中心扩展法
func longestPalindrome(s string) string {
	n := len(s)
	if n < 2 {
		return s
	}

	ans := ""
	for i := 0; i < n; i++ {
		l1 := expandAroundCenter(s, i, i)
		l2 := expandAroundCenter(s, i, i+1)
		maxLen := l1
		if maxLen < l2 {
			maxLen = l2
		}

		if maxLen > len(ans) {
			l := i - (maxLen-1)/2
			r := i + maxLen/2
			ans = s[l : r+1]
		}

	}
	return ans
}

func expandAroundCenter(s string, l, r int) int {
	for l >= 0 && r < len(s) && s[l] == s[r] {
		l--
		r++
	}
	return r - l - 1
}

// @lc code=end

func main() {
	fmt.Println(longestPalindrome_("bb"))
}
