package leetcode.leetcode83;

/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (48.37%)
 * Likes:    357
 * Dislikes: 0
 * Total Accepted:    123K
 * Total Submissions: 241.1K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 
 * 示例 1:
 * 
 * 输入: 1->1->2
 * 输出: 1->2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
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
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) { // 相同节点往当前节点收缩
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = null;
            } else {
                cur = cur.next; // 节点不相等的时候， 当前节点移动到下一个位置
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


        Solution s = new Solution();
        ListNode r1 = s.deleteDuplicates(head);
        System.out.println(r1);
    }
}
// @lc code=end

