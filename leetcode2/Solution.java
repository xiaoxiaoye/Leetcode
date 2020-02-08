package leetcode.leetcode2;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int carry = 0; // 进位数
        // 从低位开始相加
        while (l1 != null && l2 != null) {
            int val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            head.next = new ListNode(val);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        // 剩余高位
        ListNode remain = l1;
        if(remain == null) remain = l2;
        while(remain != null){
            int val = (remain.val + carry) % 10;
            carry = (remain.val + carry) / 10;
            head.next = new ListNode(val);
            head = head.next;
            remain = remain.next;
        }

        // 最终进位
        if(carry != 0){
            head.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode num1_1 = new ListNode(2);
        ListNode num1_2 = new ListNode(4);
        // ListNode num1_3 = new ListNode(3);
        num1_1.next = num1_2;
        // num1_2.next = num1_3;

        ListNode num2_1 = new ListNode(9);
        ListNode num2_2 = new ListNode(9);
        ListNode num2_3 = new ListNode(9);
        num2_1.next = num2_2;
        num2_2.next = num2_3;

        ListNode r1 = s.addTwoNumbers(num1_1, num2_1);
        while (r1 != null) {
            System.out.print("" + r1.val + "->");
            r1 = r1.next;
        }
        System.out.println();
    }
}