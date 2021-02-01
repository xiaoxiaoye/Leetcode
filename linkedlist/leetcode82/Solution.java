package leetcode.leetcode82;

import leetcode.common.*;

/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (44.61%)
 * Likes:    309
 * Dislikes: 0
 * Total Accepted:    53K
 * Total Submissions: 109.9K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        while (prev != null) {
            ListNode dupStart = prev.next;
            ListNode dupEnd = prev.next;
            while (dupEnd != null && dupEnd.next != null && dupEnd.next.val == dupStart.val) {
                dupEnd = dupEnd.next;
            }
            if (dupEnd == null)
                break;

            if (dupStart != dupEnd) {
                prev.next = dupEnd.next;
            } else {
                prev = prev.next;
            }
        }

        return dummy.next;
    }
}
// @lc code=end
