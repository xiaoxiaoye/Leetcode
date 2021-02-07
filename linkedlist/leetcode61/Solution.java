package leetcode.linkedlist.leetcode61;

/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 *
 * https://leetcode-cn.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (39.48%)
 * Likes:    298
 * Dislikes: 0
 * Total Accepted:    73.5K
 * Total Submissions: 181.6K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 
 * 
 * 示例 2:
 * 
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
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

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}


public class Solution {
    
    // 主要思路是求倒数第k个元素，以该元素作为头结点
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode firstNode = head;
        ListNode secondNode = head;
        for(int i = 0; i < k; i++) {
            if (secondNode.next != null){
                secondNode = secondNode.next;
            } else {
                secondNode = head;
            }
        }

        // 移动k个元素后回到首节点， 代表刚好整数圈， 链表保持不变
        if (firstNode == secondNode) return head;

        while(secondNode != null) {
            secondNode = secondNode.next;
            firstNode = firstNode.next;
        }

        ListNode newHead = firstNode;
        while(firstNode.next != newHead) {
            if (firstNode.next == null){
                firstNode.next = head;
            }
            firstNode = firstNode.next;
        }

        firstNode.next = null;

        return newHead;
    }
}
// @lc code=end

