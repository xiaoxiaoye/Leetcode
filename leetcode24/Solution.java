package leetcode.leetcode24;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null){
            ListNode next = cur.next;
            ListNode nextNext = cur.next.next;
            cur.next = nextNext;
            next.next = nextNext.next;
            nextNext.next = next;

            cur = cur.next.next;
        }


        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode r1 = s.swapPairs(n1);
        while(r1 != null){
            System.out.println(r1.val);
            r1 = r1.next;
        }
    }
}