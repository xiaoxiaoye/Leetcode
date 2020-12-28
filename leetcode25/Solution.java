package leetcode.leetcode25;

import leetcode.common.*;

/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 *
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (63.65%)
 * Likes:    808
 * Dislikes: 0
 * Total Accepted:    117.8K
 * Total Submissions: 185K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 
 * 
 * 示例：
 * 
 * 给你这个链表：1->2->3->4->5
 * 
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 
 * 
 * 
 * 说明：
 * 
 * 
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        while (true) {
            ListNode groupStart = prev.next;
            ListNode groupEnd = prev.next;

            for (int i = 1; i < k && groupEnd != null; i++) {
                groupEnd = groupEnd.next;
            }
            if (groupEnd == null)
                break;
            ListNode nextGroupStart = groupEnd.next;
            groupEnd.next = null;

            prev.next = reverse(groupStart);

            // 将当前组和下一组连接，防止下一组数量不够无法翻转而丢失
            groupStart.next = nextGroupStart;

            prev = groupStart;
        }

        return dummy.next;
    }

    // 链表翻转
    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);

        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode r1 = s.reverseKGroup(n1, 3);
        while (r1 != null) {
            System.out.println(r1.val);
            r1 = r1.next;
        }
    }
}
// @lc code=end