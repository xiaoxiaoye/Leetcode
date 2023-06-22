package main

/*
 * @lc app=leetcode.cn id=61 lang=golang
 *
 * [61] 旋转链表
 *
 * https://leetcode.cn/problems/rotate-list/description/
 *
 * algorithms
 * Medium (41.51%)
 * Likes:    923
 * Dislikes: 0
 * Total Accepted:    312.6K
 * Total Submissions: 753.7K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 *
 * 示例 2：
 *
 *
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *
 *
 *
 *
 * 提示：
 *
 *
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10^9
 *
 *
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil || head.Next == nil || k == 0 {
		return head
	}

	dummy := &ListNode{}
	dummy.Next = head
	tail := dummy
	count := 0
	for tail.Next != nil {
		count++
		tail = tail.Next
	}
	// if count%k == 0 {
	// 	return head
	// }
	tail.Next = head

	k = k % count
	for i := 0; i < count-k; i++ {
		tail = tail.Next
	}

	head = tail.Next
	tail.Next = nil
	return head
}

// @lc code=end
