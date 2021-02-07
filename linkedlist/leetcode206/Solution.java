package leetcode.linkedlist.leetcode206;

import leetcode.common.ListNode;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (65.90%)
 * Likes:    1137
 * Dislikes: 0
 * Total Accepted:    296.1K
 * Total Submissions: 422.6K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);

        while(head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;

            head = next;
        }
        return dummy.next;
    }
}
// @lc code=end

