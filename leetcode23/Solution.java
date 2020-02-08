package leetcode.leetcode23;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

//参考题解 https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode/
class Solution {
    // 利用分治，两两合并, 复杂度O(Nlogk)
    public ListNode mergeKListsH(ListNode[] lists) {
        if(lists.length == 0) return null;
        return startMergeKLists(lists, 0, lists.length - 1);
    }
    public ListNode startMergeKLists(ListNode[] lists, int left, int right){
        if(left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode l1 = startMergeKLists(lists, left, mid);
        ListNode l2 = startMergeKLists(lists, mid + 1, right);
        return mergeLists(l1, l2);
    }
    public ListNode mergeLists(ListNode l1, ListNode l2){
        ListNode l3 = new ListNode(-1);
        ListNode temp = l3;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return l3.next;
    }

    // 逐一比较选取最小节点加入到有序链表中， 负载度为O(kn)
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode guard = new ListNode(-1);
        ListNode head = guard;
        while (true) {
            ListNode min = null;
            int pos = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null)
                    continue;
                if (min == null){
                    min = lists[i];
                    pos = i;
                }
                if (min.val > lists[i].val) {
                    min = lists[i];
                    pos = i;
                }
            }

            // 链表全为空则合并结束
            if (min == null)
                break;
            lists[pos] = lists[pos].next;
            min.next = null;
            head.next = min;
            head = head.next;
        }
        return guard.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode node11 = new ListNode(4);
        ListNode node12 = new ListNode(5);
        list1.next = node11;
        node11.next = node12;
        node12.next = null;

        ListNode list2 = new ListNode(1);
        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(4);
        list2.next = node21;
        node21.next = node22;
        node22.next = null;

        ListNode list3 = new ListNode(2);
        ListNode node31 = new ListNode(6);
        list3.next = node31;
        node31.next = null;

        ListNode[] lists = new ListNode[]{list1, list2, list3};

        Solution s = new Solution();
        ListNode r = s.mergeKListsH(lists);

        System.out.print("[");
        ListNode h = r;
        while(h != null){
            System.out.printf("%d,", h.val);
            h = h.next;
        }
        System.out.print("]\n");
    }
}