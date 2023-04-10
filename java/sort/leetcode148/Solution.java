package leetcode.sort.leetcode148;

import leetcode.common.ListNode;

/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 *
 * https://leetcode-cn.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (67.75%)
 * Likes:    988
 * Dislikes: 0
 * Total Accepted:    137.9K
 * Total Submissions: 204K
 * Testcase Example:  '[4,2,1,3]'
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 
 * 进阶：
 * 
 * 
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：head = []
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目在范围 [0, 5 * 10^4] 内
 * -10^5 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. 
 * public class ListNode {
 *  int val;
 *  ListNode next;
 *  ListNode() {}
 *  ListNode(int val) { 
 *      this.val = val;
 *  }
 *  ListNode(int val, ListNode next) { 
 *      this.val = val;
 *      this.next = next;
 *  }
 *}
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }

    private ListNode merge(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                ListNode next = p1.next;

                p1.next = tail.next;
                tail.next = p1;

                p1 = next;
            } else {
                ListNode next = p2.next;

                p2.next = tail.next;
                tail.next = p2;

                p2 = next;
            }

            tail = tail.next;
        }

        ListNode last = p1 != null ? p1 : p2;
        tail.next = last;
        return dummy.next;
    }
}
// @lc code=end
