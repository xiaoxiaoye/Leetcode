package main

import "fmt"

/*
 * @lc app=leetcode.cn id=20 lang=golang
 *
 * [20] 有效的括号
 *
 * https://leetcode.cn/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (44.15%)
 * Likes:    3887
 * Dislikes: 0
 * Total Accepted:    1.5M
 * Total Submissions: 3.3M
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：s = "()"
 * 输出：true
 *
 *
 * 示例 2：
 *
 *
 * 输入：s = "()[]{}"
 * 输出：true
 *
 *
 * 示例 3：
 *
 *
 * 输入：s = "(]"
 * 输出：false
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= s.length <= 10^4
 * s 仅由括号 '()[]{}' 组成
 *
 *
 */

// @lc code=start

type ByteStack []byte

func (bStack *ByteStack) Add(ele byte) {
	*bStack = append(*bStack, ele)
}

func (bStack *ByteStack) Pop() byte {
	if len(*bStack) == 0 {
		return 0
	}
	ret := (*bStack)[len(*bStack)-1]
	*bStack = (*bStack)[:len(*bStack)-1]
	return ret
}

func (bStack ByteStack) Length() int {
	return len(bStack)
}

func isValid(s string) bool {
	bracketMap := map[byte]byte{
		')': '(',
		']': '[',
		'}': '{',
	}
	stack := make(ByteStack, 0)
	for i := 0; i < len(s); i++ {
		if l, ok := bracketMap[s[i]]; ok {
			if stack.Pop() != l {
				return false
			}
			continue
		}
		stack.Add(s[i])
	}
	return stack.Length() == 0
}

// @lc code=end

func main() {
	s := "()"
	fmt.Printf("%v", isValid(s))
}
