package leetcode.leetcode19;

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
    ListNode(int x) {
        val = x;
    }
}

// 利用前后两个指针的间隔距离为n，当后面的节点到达尾端，前面的节点到链表尾部的距离就是n，也就是倒数第n个数.
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        for(int i = 0; i<n; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        // 删除节点
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        
    }
}