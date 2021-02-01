package leetcode.leetcode92;

import leetcode.common.*;

/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (48.12%)
 * Likes:    455
 * Dislikes: 0
 * Total Accepted:    65.4K
 * Total Submissions: 128.4K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
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
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        for(int i = 0; i<m-1; i++){
            prev = prev.next;
        }
        ListNode end = prev;
        for(int j=0; j<n-m+1; j++) {
            end = end.next;
        }

        ListNode start = prev.next;
        ListNode next = end.next;
        end.next = null;

        prev.next=reverse(start);
        start.next = next;

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;

            cur.next = dummy.next;
            dummy.next = cur;

            cur = next;
        }
        return dummy.next;
    }
}
// @lc code=end

