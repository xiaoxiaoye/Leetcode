package leetcode.linkedlist.leetcode143;

import leetcode.common.ListNode;

/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 *
 * https://leetcode-cn.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (59.47%)
 * Likes:    518
 * Dislikes: 0
 * Total Accepted:    80.7K
 * Total Submissions: 135.7K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 示例 1:
 * 
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 
 * 示例 2:
 * 
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;

        ListNode f = head;
        ListNode s = head;
        while(f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
        }

        ListNode left = head;
        ListNode right = reverse(s.next);
        s.next = null;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(right != null){
            ListNode next = left.next;
            left.next = tail.next;
            tail.next = left;
            left = next;
            tail = tail.next;

            next = right.next;
            right.next = tail.next;
            tail.next = right;
            right = next;
            tail = tail.next;
        }

        if(left != null){
            tail.next = left;
        }
    }

    private ListNode reverse(ListNode root){
        ListNode dummy = new ListNode(-1);
        while(root != null){
            ListNode next = root.next;
            root.next = dummy.next;
            dummy.next = root;

            root = next;
        }
        return dummy.next;
    }
}
// @lc code=end

