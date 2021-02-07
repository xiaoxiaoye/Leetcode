package leetcode.linkedlist.leetcode234;

/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (39.37%)
 * Likes:    587
 * Dislikes: 0
 * Total Accepted:    112K
 * Total Submissions: 261.4K
 * Testcase Example:  '[1,2]'
 *
 * 请判断一个链表是否为回文链表。
 * 
 * 示例 1:
 * 
 * 输入: 1->2
 * 输出: false
 * 
 * 示例 2:
 * 
 * 输入: 1->2->2->1
 * 输出: true
 * 
 * 
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 
 */
import leetcode.common.ListNode;

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        
        // 找到中位点
        ListNode s = head;
        ListNode f = head;
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }

        // 翻转后半部分
        ListNode next = s.next;
        s.next = null;
        ListNode rStart = reverse(next);

        // 首位依次对比， 奇数的中位点可忽略不对比
        ListNode lStart = head;
        while (lStart != null && rStart != null) {
            if (lStart.val != rStart.val)
                return false;
            lStart = lStart.next;
            rStart = rStart.next;
        }
        return true;
    }

    /**
     * 链表翻转
     * 
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode();

        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;

            cur = next;
        }
        return dummy.next;
    }
}
// @lc code=end
