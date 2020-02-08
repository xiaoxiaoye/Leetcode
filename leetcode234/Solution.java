package leetcode.leetcode234;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode reserved = new ListNode(-1);
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            ListNode prev = slow;
            fast = fast.next.next;
            slow = slow.next;

            // 翻转前半部分链表
            prev.next = reserved.next;
            reserved.next = prev;
        }

        // 验证是否回文串
        ListNode unreserved = fast == null ? slow : slow.next;
        reserved = reserved.next;
        while (reserved != null) {
            if (reserved.val != unreserved.val) {
                return false;
            }
            reserved = reserved.next;
            unreserved = unreserved.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode list = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        list.next = node1;
        node1.next = node2;
        node2.next = node3;

        boolean r = s.isPalindrome(list);
        System.out.println(r);

    }
}