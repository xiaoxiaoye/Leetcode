package leetcode.offer52;

import leetcode.common.ListNode;

import java.util.Arrays;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l3.next = l4;
        l4.next = l5;

        Solution s = new Solution();
        ListNode r = s.getIntersectionNode(l1, l3);
        System.out.println(r);

        String str = "   a good   example";
        String[] arr = str.split("[ ]+");
        System.out.println(Arrays.toString(arr));

    }
}
