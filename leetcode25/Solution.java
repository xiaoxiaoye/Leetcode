package leetcode.leetcode25;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode start = dummy;
        ListNode end = dummy;
        ListNode next = head;

        ListNode tail = dummy;

        while(next != null){
            ListNode tmp = next;

            int group = k;
            while(--group > 0){
                if(next.next == null) break;
                next = next.next;
            }
            if(group != 0){
                start.next = tmp;
                break;
            }

            start = tmp;
            end = next;
            next = next.next;
            end.next = null;

            tail.next = reverse(start);
            tail = start;
        }


        return dummy.next;
    }

    // 题解中代码更加清晰的版本 https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
    public ListNode reverseKGroup_(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
    
        ListNode pre = dummy;
        ListNode end = dummy;
    
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
    
            end = pre;
        }
        return dummy.next;
    }

    // group的翻转
    public ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(-1);
        ListNode curNode = head;

        while(curNode != null){
            ListNode nextNode = curNode.next;
            curNode.next = dummy.next;
            dummy.next = curNode;
            curNode = nextNode;
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

        ListNode r1 = s.reverseKGroup_(n1, 3);
        while(r1 != null){
            System.out.println(r1.val);
            r1 = r1.next;
        }
    }
}